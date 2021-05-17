package com.jeanbarrossilva.period.ui.composable.component

import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.setMargins
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.ui.composable.theme.PeriodTheme
import com.jeanbarrossilva.period.ui.composable.theme.androidEuclidBold
import com.jeanbarrossilva.period.ui.view.ChemicalElementSymbolView

@Composable
fun ChemicalElementHeadline(element: ChemicalElement, modifier: Modifier = Modifier) {
    PeriodTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AndroidView(
                { context ->
                    ChemicalElementSymbolView(context)
                },
                Modifier
                    .shadow(elevation = 4.dp, RoundedCornerShape(20.dp))
            ) { view ->
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
                    fontSize = 35.sp,
                    fontFamily = androidEuclidBold,
                    textAlign = TextAlign.Center
                )

                Text(
                    element.electronConfiguration.value,
                    Modifier.alpha(ContentAlpha.medium),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}