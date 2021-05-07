package com.jeanbarrossilva.period.extensions

import android.view.View
import android.view.ViewAnimationUtils

fun createCircularReveal(view: View, centerX: Int = view.centerX.toInt(), centerY: Int = view.centerY.toInt(), startRadius: Float, endRadius: Float) =
    ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius)