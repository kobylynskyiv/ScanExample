package com.kobylynskyiv.room.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey


@Entity(tableName = "sections")
data class EntitySection(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "icon") @DrawableRes var icon: Int = 0,
    @ColumnInfo(name = "nameSection") var nameSection: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "alerts") var alerts: Int = 0

)