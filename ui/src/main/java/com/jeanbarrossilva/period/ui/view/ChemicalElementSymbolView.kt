package com.jeanbarrossilva.period.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import com.jeanbarrossilva.period.extensions.context.colorOf
import com.jeanbarrossilva.period.extensions.context.withStyledAttributes
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.extensions.view.viewgroup.cardview.setContentPadding
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.ui.R

open class ChemicalElementSymbolView: CardView {
    private lateinit var layout: CoordinatorLayout
    private lateinit var atomicNumberView: TextView
    private lateinit var symbolView: TextView
    private lateinit var atomicMassView: TextView

    protected var isCompact = false
        set(isCompact) {
            field = isCompact
            radius = if (isCompact) 10.dp(context).toFloat() else 20.dp(context).toFloat()
            setContentPadding(if (isCompact) 7.dp(context) else 15.dp(context))
            atomicNumberView.textSize = if (isCompact) 10f else 14f
            symbolView.textSize = if (isCompact) 14f else 40f
            symbolView.setTextColor(context colorOf if (isCompact) android.R.attr.textColorSecondary else android.R.attr.textColorPrimary)
            atomicMassView.isVisible = !isCompact
        }

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

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        init(attrs, defStyleAttr)
    }

    private fun updateWith(element: ChemicalElement) {
        atomicNumberView.text = element.atomicNumber.value.toString()
        symbolView.text = element.symbol.value
        atomicMassView.text = element.atomicMass.value.toString()
    }

    private fun config() {
        isCompact = false
    }

    private fun assignViews(attrs: AttributeSet?, defStyleAttr: Int) {
        layout = CoordinatorLayout(context, attrs, defStyleAttr).apply {
            layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
        atomicNumberView = TextView(context, attrs, defStyleAttr).apply {
            setTextColor(context colorOf android.R.attr.textColorSecondary)
        }
        symbolView = TextView(context, attrs, defStyleAttr).apply {
            layoutParams = CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                gravity = Gravity.CENTER
                typeface = ResourcesCompat.getFont(context, R.font.android_euclid_bold)
            }
        }
        atomicMassView = TextView(context, attrs, defStyleAttr).apply {
            layoutParams = CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                gravity = Gravity.BOTTOM and Gravity.CENTER_HORIZONTAL
            }
            setTextColor(context colorOf android.R.attr.textColorSecondary)
        }
    }

    private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        context.withStyledAttributes(attrs, defStyleAttr, R.styleable.ChemicalElementSymbolView) { index ->
            if (index == R.styleable.ChemicalElementSymbolView_element)
                element = ChemicalElement of getInt(index, ChemicalElement.default.atomicNumber.value)
        }
    }

    private fun addViews() {
        addView(layout)
        layout.addView(atomicNumberView)
        layout.addView(symbolView)
    }

    private fun populateForPreview() {
        if (isInEditMode && element == null)
            element = ChemicalElement.default
    }

    private fun init(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        assignViews(attrs, defStyleAttr)
        config()
        getAttrs(attrs, defStyleAttr)
        addViews()
        populateForPreview()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = if (isCompact) 60.dp(context) else 150.dp(context)
        val spec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY)
        super.onMeasure(spec, spec)
    }
}