package com.kobylynskyiv.room

import android.content.Context
import com.kobylynskyiv.room.repository.SectionRepository

class DatabaseManager(private val context: Context) {

    private val database by lazy { AppDatabase.getDatabase(context) }

    fun createSectionRepository(): SectionRepository {
        return SectionRepository(database.sectionDao())
    }
}