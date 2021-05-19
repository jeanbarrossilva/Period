package com.jeanbarrossilva.period.ui.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import com.jeanbarrossilva.period.ui.R

val androidEuclidBold = Font(R.font.android_euclid_bold).toFontFamily()
val androidEuclidMedium = Font(R.font.android_euclid_medium).toFontFamily()

@Composable
private fun PeriodTheme(modifier: Modifier = Modifier, fills: Boolean, content: @Composable () -> Unit) {
    MaterialTheme(typography = Typography(androidEuclidMedium)) {
        if (fills) Surface(modifier, content = content) else content()
    }
}

@Composable
fun PeriodTheme(modifier: Modifier, content: @Composable () -> Unit) {
    PeriodTheme(modifier, fills = true, content)
}

@Composable
fun PeriodTheme(content: @Composable () -> Unit) {
    PeriodTheme(fills = false, content = content)
}