package com.jeanbarrossilva.period.extensions

import android.view.View
import android.view.ViewAnimationUtils
import com.jeanbarrossilva.period.extensions.view.centerX
import com.jeanbarrossilva.period.extensions.view.centerY

fun createCircularReveal(view: View, centerX: Int = view.centerX.toInt(), centerY: Int = view.centerY.toInt(), startRadius: Float, endRadius: Float) =
    ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius)