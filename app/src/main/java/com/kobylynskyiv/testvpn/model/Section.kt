package com.kobylynskyiv.testvpn.model

import androidx.annotation.DrawableRes
import com.kobylynskyiv.room.model.EntitySection
import com.kobylynskyiv.testvpn.App
import com.kobylynskyiv.testvpn.R

data class Section (
    var nameSection: String,
    var description: String,
    @DrawableRes var icon: Int,
    var alerts: Int
)

fun convert(entity: EntitySection?): Section {
    return Section(
        nameSection = entity?.nameSection ?: App.application.getString(R.string.name_section_empty),
        description = entity?.description ?: App.application.getString(R.string.description_section_empty),
        icon = entity?.icon ?: 0,
        alerts = entity?.alerts ?: 0
    )
}