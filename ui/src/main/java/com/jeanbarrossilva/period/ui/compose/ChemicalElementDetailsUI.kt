package com.jeanbarrossilva.period.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.model.ChemicalElementSortingOption
import com.jeanbarrossilva.period.ui.compose.component.ChemicalElementHeadline
import com.jeanbarrossilva.period.ui.compose.component.core.Landscape
import com.jeanbarrossilva.period.ui.compose.component.core.Portrait
import com.jeanbarrossilva.period.ui.compose.theme.PeriodTheme
import com.jeanbarrossilva.period.ui.view.ChemicalElementDetailsView

@Composable
private fun ChemicalElementDetails(element: ChemicalElement, modifier: Modifier = Modifier) {
    PeriodTheme {
        AndroidView(
            { context ->
                ChemicalElementDetailsView(context)
            },
            modifier
                .padding(bottom = 40.dp)
        ) { view ->
            view.element = element
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ChemicalElementDetailsUI(elementIndex: Int, sortingOption: ChemicalElementSortingOption<*>, modifier: Modifier = Modifier) {
    val elements = sortingOption.getElements()
    val pagerState = rememberPagerState(pageCount = elements.size, initialPage = elementIndex)

    PeriodTheme(
        modifier
            .padding(bottom = 56.dp)
    ) {
        HorizontalPager(pagerState) { pageIndex ->
            elements[pageIndex].let @Composable { element ->
                Portrait {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                    ) {
                        item {
                            Column(
                                modifier
                                    .fillMaxSize()
                                    .padding(top = 50.dp),
                                Arrangement.spacedBy(50.dp)
                            ) {
                                Box(
                                    Modifier
                                        .fillMaxWidth(),
                                    Alignment.Center
                                ) {
                                    ChemicalElementHeadline(element)
                                }

                                Box(
                                    Modifier
                                        .fillMaxSize(),
                                    Alignment.Center
                                ) {
                                    ChemicalElementDetails(
                                        element,
                                        Modifier
                                            .fillMaxSize()
                                    )
                                }
                            }
                        }
                    }
                }

                Landscape {
                    Row(
                        Modifier
                            .fillMaxSize()
                    ) {
                        Box(
                            Modifier
                                .fillMaxWidth(0.5f)
                                .fillMaxHeight()
                                .padding(20.dp),
                            Alignment.Center
                        ) {
                            ChemicalElementHeadline(element)
                        }

                        Box(
                            Modifier
                                .fillMaxSize(),
                            Alignment.Center
                        ) {
                            LazyColumn(
                                Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically)
                            ) {
                                item {
                                    ChemicalElementDetails(
                                        element,
                                        Modifier
                                            .fillMaxSize()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}