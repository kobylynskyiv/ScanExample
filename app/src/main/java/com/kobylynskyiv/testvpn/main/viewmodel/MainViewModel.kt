package com.kobylynskyiv.testvpn.main.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kobylynskyiv.room.repository.SectionRepository
import com.kobylynskyiv.room.utils.totalAlerts
import com.kobylynskyiv.testvpn.base.BaseViewModel
import com.kobylynskyiv.testvpn.model.Section
import com.kobylynskyiv.testvpn.model.convert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    app: Application,
    private val repository: SectionRepository
): BaseViewModel(app) {

    val sectionObservable = MutableLiveData<List<Section>>()
    val totalsAlertsObservable = MutableLiveData<Int>()

    init {
        getSection()
    }

    private fun getSection(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) { repository.fetchInitialData() }

            val sections = repository.getSections()
            totalsAlertsObservable.postValue(sections?.totalAlerts())
            sectionObservable.postValue(sections?.mapNotNull(::convert))
        }
    }
}