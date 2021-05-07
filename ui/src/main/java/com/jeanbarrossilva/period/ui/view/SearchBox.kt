package com.jeanbarrossilva.period.ui.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.core.content.res.getStringOrThrow
import com.jeanbarrossilva.period.extensions.*
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.ui.R

class SearchBox: CardView {
    private lateinit var field: EditText
    private var onQueryChangeListeners = mutableListOf<OnQueryChangeListener>()

    var opensKeyboardIfVisible = true

    constructor(context: Context): super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        init(attrs, defStyleAttr)
    }

    fun interface OnQueryChangeListener {
        fun onQueryChange(query: String)
    }

    private fun config() {
        elevation = 8.dp(context).toFloat()
        setContentPadding(0, 10.dp(context), 0, 10.dp(context))
    }

    private fun initViews() {
        // For some reason, instantiating it as EditText(context, attrs, defStyleAttr) makes the View unusable.
        field = EditText(context).apply {
            gravity = Gravity.CENTER
            isSingleLine = true
            background = ColorDrawable(Color.TRANSPARENT)
            layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setHint(R.string.SearchBox_hint)
            doOnTextChanged { text ->
                onQueryChangeListeners.forEach {
                    it.onQueryChange(text)
                }
            }
        }
    }

    private fun addViews() {
        addView(field)
    }

    private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) = context.withStyledAttributes(attrs, defStyleAttr, R.styleable.SearchBox) {
        if (it == R.styleable.SearchBox_query)
            setQuery(getStringOrThrow(it))
    }

    private fun init(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        config()
        initViews()
        addViews()
        getAttrs(attrs, defStyleAttr)
    }

    override fun setVisibility(visibility: Int) {
        val willBeVisible = visibility == VISIBLE
        if (willBeVisible) {
            super.setVisibility(visibility)
            reveal {
                if (opensKeyboardIfVisible)
                    field.showKeyboard()
            }
        } else
            unreveal {
                super.setVisibility(visibility)
                field.text.clear()
            }
    }

    fun getQuery() = field.text?.toString() ?: ""

    fun setQuery(query: String) {
        field.setText(query)
        onQueryChangeListeners.forEach {
            it.onQueryChange(query)
        }
    }

    fun addOnQueryChangeListener(listener: OnQueryChangeListener) {
        onQueryChangeListeners.add(listener)
    }
}