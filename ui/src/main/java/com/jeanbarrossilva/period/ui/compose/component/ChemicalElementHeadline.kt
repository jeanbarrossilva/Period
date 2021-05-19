package com.jeanbarrossilva.period.ui.compose.component

import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.setMargins
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.ui.compose.theme.PeriodTheme
import com.jeanbarrossilva.period.ui.compose.theme.androidEuclidBold
import com.jeanbarrossilva.period.ui.compose.workaround.textColor
import com.jeanbarrossilva.period.ui.view.ChemicalElementSymbolView

@Composable
fun ChemicalElementHeadline(element: ChemicalElement, modifier: Modifier = Modifier) {
    PeriodTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AndroidView({ context ->
                ChemicalElementSymbolView(context)
            }) { view ->
                view.element = element
                view.layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    setMargins(4.dp(view.context))
                }
            }

            Column(
                modifier,
                Arrangement.spacedBy(5.dp),
                Alignment.CenterHorizontally
            ) {
                Text(
                    element.name.value,
                    color = textColor(),
                    fontSize = 35.sp,
                    fontFamily = androidEuclidBold,
                    textAlign = TextAlign.Center
                )

                Text(
                    element.electronConfiguration.value,
                    Modifier.alpha(ContentAlpha.medium),
                    textColor(),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}