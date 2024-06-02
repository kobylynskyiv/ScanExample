package com.kobylynskyiv.testvpn.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.kobylynskyiv.testvpn.utils.hideKeyboard

abstract class BaseFragment<VB : ViewBinding?, VM : ViewModel>() : Fragment(){

    open var _binding: VB? = null
    val binding: VB get() = _binding ?: throw IllegalStateException("Trying to access the binding outside of the view lifecycle.")

    abstract val viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflateViewBinding(layoutInflater)
        return binding?.root
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    abstract fun inflateViewBinding(inflater: LayoutInflater): VB
}