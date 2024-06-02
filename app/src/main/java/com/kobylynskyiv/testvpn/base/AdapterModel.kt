package com.kobylynskyiv.testvpn.base

import androidx.annotation.LayoutRes
import com.kobylynskyiv.testvpn.R
import com.kobylynskyiv.testvpn.model.Section

sealed class AdapterModel(@LayoutRes val layout: Int) {
    data class SectionModel(val section: Section): AdapterModel(R.layout.row_dashboard)
}

fun convert(section: Section): AdapterModel.SectionModel {
    return AdapterModel.SectionModel(section)
}