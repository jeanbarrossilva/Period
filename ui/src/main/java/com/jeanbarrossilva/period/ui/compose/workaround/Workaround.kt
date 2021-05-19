package com.jeanbarrossilva.period.ui.compose.workaround

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
/** As of 1.0.0-beta06, the default color used in [Text] is black regardless of the current theme.  **/
fun textColor(): Color {
    return if (isSystemInDarkTheme()) Color.White else Color.Black
}