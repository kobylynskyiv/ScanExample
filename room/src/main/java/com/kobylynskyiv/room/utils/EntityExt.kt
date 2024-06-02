package com.kobylynskyiv.room.utils

import com.kobylynskyiv.room.model.EntitySection

fun List<EntitySection?>.totalAlerts(): Int = sumOf { it?.alerts ?: 0 }