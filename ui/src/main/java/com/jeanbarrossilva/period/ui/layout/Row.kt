package com.jeanbarrossilva.period.ui.layout

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.jeanbarrossilva.period.extensions.withStyledAttributes
import com.jeanbarrossilva.period.ui.R
import top.defaults.drawabletoolbox.DrawableBuilder

class Row: LinearLayout {
    var spacing = 0f
        set(value) {
            field = value
            dividerDrawable = DrawableBuilder().width(spacing.toInt()).build()
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

    private fun config() {
        showDividers = SHOW_DIVIDER_MIDDLE
    }

    private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) = context.withStyledAttributes(attrs, defStyleAttr, R.styleable.Row) {
        if (it == R.styleable.Row_spacing)
            spacing = getDimension(it, spacing)
    }

    private fun init(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        config()
        getAttrs(attrs, defStyleAttr)
    }

    override fun setOrientation(orientation: Int) {
        super.setOrientation(HORIZONTAL)
    }
}