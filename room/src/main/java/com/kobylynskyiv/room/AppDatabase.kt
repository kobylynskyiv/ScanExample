package com.kobylynskyiv.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kobylynskyiv.room.dao.SectionDao
import com.kobylynskyiv.room.model.EntitySection
import kotlin.concurrent.Volatile


@Database(entities = [EntitySection::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun sectionDao(): SectionDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }

        const val DB_NAME = "testVpnDatabase"
    }
}
