package com.kobylynskyiv.room.repository

import com.kobylynskyiv.room.R
import com.kobylynskyiv.room.dao.SectionDao
import com.kobylynskyiv.room.model.EntitySection

class SectionRepository(private val sectionDao: SectionDao) {

    suspend fun fetchInitialData() {
        sectionDao.deleteAll()

        val section = listOf(
            EntitySection(
                icon = R.drawable.ic_info,
                nameSection = "Device info",
                description = "Show you all info about phone"
            ),
            EntitySection(
                icon = R.drawable.ic_callibration,
                nameSection = "Calibration of sensors",
                description = "Show you all info about",
                alerts = 1
            ),
            EntitySection(
                icon = R.drawable.ic_monitoring,
                nameSection = "App monitoring",
                description = "Show you all info about"
            ),
            EntitySection(
                icon = R.drawable.ic_manager,
                nameSection = "AntiVirus",
                description = "Show you all info about"
            ),
            EntitySection(
                icon = R.drawable.ic_memory,
                nameSection = "Device Memory Information",
                description = "Show you all info about"
            ),
            EntitySection(
                icon = R.drawable.ic_manager,
                nameSection = "File manager",
                description = "Show you all info about"
            ),
            EntitySection(
                icon = R.drawable.ic_battery,
                nameSection = "Battery info",
                description = "Show you all info about"
            )
        )

        sectionDao.insert(section)
    }

    suspend fun getSections(): List<EntitySection?>? {
        return sectionDao.getAllSections()
    }
}