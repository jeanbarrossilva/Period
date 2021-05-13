package com.jeanbarrossilva.period.extensions.activity

import android.app.Activity
import android.widget.FrameLayout
import androidx.core.view.children

private val Activity.content
    get() = findViewById<FrameLayout>(android.R.id.content)

val Activity.view
    get() = content.children.first()