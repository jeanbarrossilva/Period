package com.jeanbarrossilva.period.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeanbarrossilva.period.extensions.context.withStyledAttributes
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.model.ChemicalElementProperty.Companion.displayValue
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.compose.theme.androidEuclidBold
import com.jeanbarrossilva.period.ui.compose.workaround.cardBackgroundColor
import com.jeanbarrossilva.period.ui.compose.workaround.textColor

open class ChemicalElementSymbolView: AbstractComposeView {
    protected var isCompact by mutableStateOf(false)

    var element by mutableStateOf<ChemicalElement?>(null)

    constructor(context: Context): super(context) {
        getAttrs()
    }

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        getAttrs(attrs, defStyleAttr)
    }

    private fun getAttrs(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        context.withStyledAttributes(attrs, defStyleAttr, R.styleable.ChemicalElementSymbolView) { index ->
            if (index == R.styleable.ChemicalElementSymbolView_element)
                element = ChemicalElement of getInt(index, ChemicalElement.default.atomicNumber.value)
        }
    }

    @Composable
    override fun Content() {
        val size = if (isCompact) 60.dp else 150.dp
        val shapeCornerRadius = if (isCompact) 10.dp else 20.dp
        val elevation = 1.dp
        val padding = if (isCompact) 7.dp else 15.dp
        val atomicNumberFontSize = if (isCompact) 7.sp else 14.sp
        val symbolFontSize = if (isCompact) 14.sp else 40.sp
        val symbolAlpha = if (isCompact) ContentAlpha.medium else ContentAlpha.high

        element?.let { element ->
            Card(
                Modifier
                    .size(size)
                    .padding(elevation + 2.dp),
                RoundedCornerShape(shapeCornerRadius),
                cardBackgroundColor(),
                elevation = elevation
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    Text(
                        element.atomicNumber.displayValue,
                        Modifier
                            .alpha(ContentAlpha.medium),
                        textColor(),
                        atomicNumberFontSize
                    )

                    Text(
                        element.symbol.displayValue,
                        Modifier
                            .alpha(symbolAlpha)
                            .align(Alignment.Center),
                        textColor(),
                        symbolFontSize,
                        fontFamily = androidEuclidBold
                    )
                }
            }
        }
    }
}