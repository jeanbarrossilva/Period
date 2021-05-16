package com.jeanbarrossilva.period.ui.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.StringRes
import com.jeanbarrossilva.period.extensions.context.colorOf
import com.jeanbarrossilva.period.extensions.context.withStyledAttributes
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.model.ChemicalElementProperty
import com.jeanbarrossilva.period.ui.R

class ChemicalElementDetailsView: TableLayout {
    var element: ChemicalElement? = null
        set(value) {
            field = value
            value?.let {
                updateWith(it)
            }
        }

    constructor(context: Context): super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        init(attrs)
    }

    private fun updateWith(element: ChemicalElement) {
        listOf(
            createTableRow(R.string.ChemicalElementDetailsView_kind, element.kind),
            createTableRow(R.string.ChemicalElementDetailsView_group, element.group),
            createTableRow(R.string.ChemicalElementDetailsView_period, element.period),
            createTableRow(R.string.ChemicalElementDetailsView_protons, element.protons),
            createTableRow(R.string.ChemicalElementDetailsView_neutrons, element.neutrons),
            createTableRow(R.string.ChemicalElementDetailsView_electrons, element.electrons),
            createTableRow(R.string.ChemicalElementDetailsView_electronegativity, element.electronegativity)
        ).forEach { tableRow ->
            addView(tableRow)
        }
    }

    private fun createPropertyTitleTextView(@StringRes titleRes: Int): TextView {
        return TextView(context).apply {
            textAlignment = TEXT_ALIGNMENT_VIEW_START
            layoutParams = TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                weight = 0.5f
            }
            setTypeface(typeface, Typeface.BOLD)
            setText(titleRes)
        }
    }

    private fun createPropertyValueTextView(property: ChemicalElementProperty<*>?): TextView {
        return TextView(context).apply {
            text = property?.value?.toString() ?: "N/A"
            textAlignment = TEXT_ALIGNMENT_VIEW_END
            layoutParams = TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                weight = 0.5f
            }
            setTextColor(context colorOf android.R.attr.textColorSecondary)
        }
    }

    private fun createTableRow(@StringRes titleRes: Int, property: ChemicalElementProperty<*>?): TableRow {
        return TableRow(context).apply {
            setPadding(30.dp(context), 10.dp(context), 30.dp(context), 10.dp(context))
            addView(createPropertyTitleTextView(titleRes))
            addView(createPropertyValueTextView(property))
        }
    }

    private fun getAttrs(attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, defStyleAttr = 0, R.styleable.ChemicalElementDetailsView) { index ->
            if (index == R.styleable.ChemicalElementDetailsView_element)
                element = ChemicalElement of getInt(index, ChemicalElement.default.atomicNumber.value)
        }
    }

    private fun populateForPreview() {
        if (isInEditMode)
            element = ChemicalElement.default
    }

    private fun init(attrs: AttributeSet? = null) {
        getAttrs(attrs)
        populateForPreview()
    }
}