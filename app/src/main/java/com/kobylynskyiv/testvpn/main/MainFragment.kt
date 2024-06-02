package com.kobylynskyiv.testvpn.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.kobylynskyiv.room.DatabaseManager
import com.kobylynskyiv.testvpn.R
import com.kobylynskyiv.testvpn.base.AdapterModel
import com.kobylynskyiv.testvpn.base.BaseAdapter
import com.kobylynskyiv.testvpn.base.BaseFragment
import com.kobylynskyiv.testvpn.base.convert
import com.kobylynskyiv.testvpn.databinding.MainFragmentBinding
import com.kobylynskyiv.testvpn.main.viewmodel.MainViewModel
import com.kobylynskyiv.testvpn.main.viewmodel.MainViewModelFactory
import com.kobylynskyiv.testvpn.utils.getApplication
import com.kobylynskyiv.testvpn.utils.setPeekHeightInPercent


class MainFragment: BaseFragment<MainFragmentBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(getApplication(), DatabaseManager(requireContext()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BaseAdapter<AdapterModel.SectionModel>()
        binding.bottomSheet.recyclerView.adapter = adapter

        viewModel.sectionObservable.observe(viewLifecycleOwner) { sections ->
            if (sections == null) return@observe
            adapter.submitList(sections.map(::convert))
        }

        BottomSheetBehavior.from<View>(binding.bottomSheet.root).apply {
            setPeekHeightInPercent(percent = 38)
            setBottomSheetCallback(object : BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_DRAGGING -> state = BottomSheetBehavior.STATE_EXPANDED
                        BottomSheetBehavior.STATE_COLLAPSED ->  setPeekHeightInPercent(percent = 38)
                        BottomSheetBehavior.STATE_EXPANDED -> setPeekHeight(BottomSheetBehavior.PEEK_HEIGHT_AUTO, true)
                    }
                }
                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })
        }

        viewModel.totalsAlertsObservable.observe(viewLifecycleOwner){
            binding.includeScan.problems.text = String.format(getString(R.string.problems), it)
        }

    }

    override fun inflateViewBinding(inflater: LayoutInflater): MainFragmentBinding {
        return MainFragmentBinding.inflate(layoutInflater)
    }
}