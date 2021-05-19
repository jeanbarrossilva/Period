package com.jeanbarrossilva.period.ui.compose.component.core

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Landscape(content: @Composable () -> Unit) {
    val isInLandscape = LocalContext.current.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    if (isInLandscape)
        content()
}