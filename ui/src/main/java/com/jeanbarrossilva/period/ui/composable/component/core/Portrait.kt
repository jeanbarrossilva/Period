package com.jeanbarrossilva.period.ui.composable.component.core

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Portrait(content: @Composable () -> Unit) {
    val isInPortrait = LocalContext.current.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    if (isInPortrait)
        content()
}