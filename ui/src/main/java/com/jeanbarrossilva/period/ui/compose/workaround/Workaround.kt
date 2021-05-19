package com.jeanbarrossilva.period.ui.compose.workaround

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.jeanbarrossilva.period.ui.R

@Composable
/** As of 1.0.0-beta-6, the default background color used in [Card] is white regardless of the current theme. **/
fun cardBackgroundColor(): Color {
    val value = ContextCompat.getColor(LocalContext.current, R.color.cardViewBackground)
    return Color(value)
}

@Composable
/** As of 1.0.0-beta06, the default color used in [Text] is black regardless of the current theme.  **/
fun textColor(): Color {
    return if (isSystemInDarkTheme()) Color.White else Color.Black
}