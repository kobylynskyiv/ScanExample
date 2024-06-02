package com.kobylynskyiv.testvpn.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kobylynskyiv.testvpn.R
import com.kobylynskyiv.testvpn.databinding.RowDashboardBinding
import com.kobylynskyiv.testvpn.databinding.RowEmptyBinding
import com.kobylynskyiv.testvpn.main.adapter.AdapterSectionViewHolder
import com.kobylynskyiv.testvpn.utils.ItemDiffCallback

class BaseAdapter<T : AdapterModel>: ListAdapter<T, RecyclerView.ViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.row_dashboard -> AdapterSectionViewHolder(
                RowDashboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            else -> AdapterViewHolderEmpty(
                RowEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int = (getItem(position) as AdapterModel).layout

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AdapterSectionViewHolder -> holder.bind(getItem(position) as AdapterModel.SectionModel)
            is AdapterViewHolderEmpty -> holder.bind()
        }
    }

}