package com.kobylynskyiv.testvpn

import android.os.Bundle
import com.kobylynskyiv.testvpn.base.BaseActivity
import com.kobylynskyiv.testvpn.utils.call

class MainActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        window.call()
    }

}