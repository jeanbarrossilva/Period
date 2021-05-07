package com.jeanbarrossilva.period.extensions

import android.app.Activity
import androidx.appcompat.widget.ContentFrameLayout
import androidx.core.view.children

private val Activity.content
    get() = window.findViewById<ContentFrameLayout>(android.R.id.content)

val Activity.view
    get() = content.children.first()