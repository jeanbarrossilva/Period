package com.jeanbarrossilva.period.extensions.activity

import android.app.Activity
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.children
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.period.extensions.view.searchFor

private val Activity.content
    get() = findViewById<FrameLayout>(android.R.id.content)

val Activity.fab
    get() = view.searchFor<FloatingActionButton>()

val Activity.toolbar
    get() = view.searchFor<Toolbar>() ?: view.searchFor<BottomAppBar>()

val Activity.view
    get() = content.children.first()