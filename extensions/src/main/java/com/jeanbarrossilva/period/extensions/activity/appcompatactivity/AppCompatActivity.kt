package com.jeanbarrossilva.period.extensions.activity.appcompatactivity

import androidx.appcompat.app.AppCompatActivity

val AppCompatActivity.currentFragment
    get() = with(supportFragmentManager) {
        primaryNavigationFragment?.childFragmentManager?.fragments?.lastOrNull() ?: fragments.lastOrNull()
    }