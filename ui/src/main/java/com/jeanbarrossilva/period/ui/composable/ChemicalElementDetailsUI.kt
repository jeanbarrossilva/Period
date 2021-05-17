package com.jeanbarrossilva.period.ui.composable

import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.jeanbarrossilva.period.ui.fragment.ChemicalElementDetailsFragment
import com.jeanbarrossilva.period.ui.view.ChemicalElementDetailsView
import com.jeanbarrossilva.period.ui.view.ChemicalElementSymbolView

@Composable
fun ChemicalElementDetailsFragment.ChemicalElementDetailsUI(element: ChemicalElement, modifier: Modifier = Modifier) {
    PeriodTheme(modifier) {
        LazyColumn {
            item {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, bottom = 92.dp),
                    Arrangement.spacedBy(50.dp),
                    Alignment.CenterHorizontally
                ) {
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
                                setMargins(4.dp(context))
                            }
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
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

                AndroidView(
                    { context ->
                        ChemicalElementDetailsView(context)
                    },
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) { view ->
                    view.element = element
                }
            }
        }
    }
}