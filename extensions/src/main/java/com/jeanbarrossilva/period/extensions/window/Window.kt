package com.jeanbarrossilva.period.extensions

import android.view.Window
import androidx.core.view.WindowInsetsControllerCompat

val Window.insetsControllerCompat
    get() = WindowInsetsControllerCompat(this, decorView)