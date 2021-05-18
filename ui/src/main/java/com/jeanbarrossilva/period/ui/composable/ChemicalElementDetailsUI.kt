package com.jeanbarrossilva.period.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.extensions.view.updatePadding
import com.jeanbarrossilva.period.model.ChemicalElementSortingOption
import com.jeanbarrossilva.period.ui.composable.component.ChemicalElementHeadline
import com.jeanbarrossilva.period.ui.composable.component.core.Landscape
import com.jeanbarrossilva.period.ui.composable.component.core.Portrait
import com.jeanbarrossilva.period.ui.composable.theme.PeriodTheme
import com.jeanbarrossilva.period.ui.view.ChemicalElementDetailsView

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ChemicalElementDetailsUI(elementIndex: Int, sortingOption: ChemicalElementSortingOption<*>, modifier: Modifier = Modifier) {
    val elements = sortingOption.getElements()
    val pagerState = rememberPagerState(pageCount = elements.size, initialPage = elementIndex)

    PeriodTheme {
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
                                    AndroidView(
                                        { context ->
                                            ChemicalElementDetailsView(context)
                                        },
                                        Modifier
                                            .fillMaxSize()
                                    ) { view ->
                                        view.element = element
                                        view.clipToPadding = false
                                        if (view.canScrollVertically(ItemTouchHelper.UP)) {
                                            view.updatePadding(top = 20.dp(view.context), bottom = 20.dp(view.context))
                                        }
                                    }
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
                                    AndroidView(
                                        { context ->
                                            ChemicalElementDetailsView(context)
                                        },
                                        Modifier
                                            .fillMaxSize()
                                    ) { view ->
                                        view.element = element
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}