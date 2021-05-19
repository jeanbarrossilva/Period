package com.jeanbarrossilva.period.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.period.extensions.context.withStyledAttributes
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.model.ChemicalElementProperty.Companion.displayValue
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.compose.theme.androidEuclidBold
import com.jeanbarrossilva.period.ui.compose.workaround.textColor

class ChemicalElementDetailsView: AbstractComposeView {
    var element by mutableStateOf<ChemicalElement?>(null)

    constructor(context: Context): super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        init(attrs, defStyleAttr)
    }

    private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        context.withStyledAttributes(attrs, defStyleAttr, R.styleable.ChemicalElementDetailsView) { index ->
            if (index == R.styleable.ChemicalElementDetailsView_element)
                element = ChemicalElement of getInt(index, ChemicalElement.default.atomicNumber.value)
        }
    }

    private fun populateForPreview() {
        if (isInEditMode)
            element = ChemicalElement.default
    }

    private fun init(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        getAttrs(attrs, defStyleAttr)
        populateForPreview()
    }

    @Composable
    override fun Content() {
        element?.let { element ->
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                listOf(
                    R.string.ChemicalElementDetailsView_kind to element.kind,
                    R.string.ChemicalElementDetailsView_atomic_mass to element.atomicMass,
                    R.string.ChemicalElementDetailsView_group to element.group,
                    R.string.ChemicalElementDetailsView_period to element.period,
                    R.string.ChemicalElementDetailsView_protons to element.protons,
                    R.string.ChemicalElementDetailsView_neutrons to element.neutrons,
                    R.string.ChemicalElementDetailsView_electrons to element.electrons,
                    R.string.ChemicalElementDetailsView_electronegativity to element.electronegativity
                ).forEach { (propertyTitleRes, property) ->
                    Row(
                        Modifier
                            .padding(horizontal = 30.dp, vertical = 10.dp)
                    ) {
                        Text(
                            stringResource(propertyTitleRes),
                            Modifier
                                .fillMaxWidth(0.5f)
                                .alpha(ContentAlpha.medium),
                            textColor(),
                            fontFamily = androidEuclidBold,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            property.displayValue,
                            Modifier
                                .fillMaxWidth()
                                .alpha(ContentAlpha.medium),
                            textColor(),
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}