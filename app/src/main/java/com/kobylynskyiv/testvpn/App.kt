package com.kobylynskyiv.testvpn

import android.app.Application
import com.airbnb.lottie.AsyncUpdates
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieConfig


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        Lottie.initialize(
            LottieConfig.Builder()
                .setEnableSystraceMarkers(true)
                .setEnableNetworkCache(true)
                .setEnableSystraceMarkers(true)
                .setDefaultAsyncUpdates(AsyncUpdates.AUTOMATIC)
                .build()
        )
    }

    companion object {
        lateinit var application: Application
    }

}