package com.kobylynskyiv.testvpn.main.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.kobylynskyiv.testvpn.base.AdapterModel
import com.kobylynskyiv.testvpn.databinding.RowDashboardBinding
import com.kobylynskyiv.testvpn.utils.setMarginWithCondition

class AdapterSectionViewHolder(private val binding: RowDashboardBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AdapterModel.SectionModel) {
        with(item.section){
            binding.name.text = nameSection
            binding.description.text = description
            binding.icon.setImageResource(icon)
            alerts.takeIf { it > 0 }?.let {
                binding.alerts.isVisible = true
                binding.alerts.text = it.toString()
            }
            binding.linearLayout.setMarginWithCondition { alerts }
        }
    }
}