package com.kobylynskyiv.testvpn.utils

import android.app.Application
import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowInsets
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kobylynskyiv.testvpn.App


fun BottomSheetBehavior<*>.setPeekHeightInPercent(percent: Int) {
    val screenHeight = App.application.applicationContext?.resources?.displayMetrics?.heightPixels ?: 0
    val peekHeight = (screenHeight * percent) / 100
    setPeekHeight(peekHeight, true)
}

fun View.setMarginWithCondition(
    condition: () -> Int
) {
    val margin = condition()
    val marginValue = if (margin > 0) 10 else 0
    setMargins(leftMargin = marginValue)
}

fun View.setMargins(
    leftMargin: Int = 0,
    topMargin: Int = 0,
    rightMargin: Int = 0,
    bottomMargin: Int = 0
) {

    val layoutParams = this.layoutParams ?: ViewGroup.MarginLayoutParams(width, height)

    if (layoutParams is ViewGroup.MarginLayoutParams) {
        layoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin)
        this.layoutParams = layoutParams
        requestLayout()
    }
}


fun Fragment.hideKeyboard() {
    val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view?.windowToken, 0)
}


fun Fragment.getApplication(): Application = this.requireActivity().application


fun Window.call(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        insetsController?.hide(WindowInsets.Type.navigationBars())
    } else {
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
    }
}