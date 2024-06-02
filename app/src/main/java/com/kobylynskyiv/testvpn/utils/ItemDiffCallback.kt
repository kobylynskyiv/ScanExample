package com.kobylynskyiv.testvpn.utils

import androidx.recyclerview.widget.DiffUtil
import com.kobylynskyiv.testvpn.base.AdapterModel

class ItemDiffCallback<T : AdapterModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return true
    }
}


