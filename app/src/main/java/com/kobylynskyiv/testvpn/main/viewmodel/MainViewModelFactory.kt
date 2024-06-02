package com.kobylynskyiv.testvpn.main.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kobylynskyiv.room.DatabaseManager

class MainViewModelFactory(
    private val application: Application,
    private val manager: DatabaseManager
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(application, manager.createSectionRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}