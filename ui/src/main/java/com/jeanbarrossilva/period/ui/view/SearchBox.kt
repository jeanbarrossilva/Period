package com.jeanbarrossilva.period.ui.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import androidx.cardview.widget.CardView
import androidx.core.content.res.getStringOrThrow
import com.jeanbarrossilva.period.extensions.context.withStyledAttributes
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.extensions.view.edittext.closeKeyboard
import com.jeanbarrossilva.period.extensions.view.edittext.doOnTextChanged
import com.jeanbarrossilva.period.extensions.view.edittext.openKeyboard
import com.jeanbarrossilva.period.extensions.view.reveal
import com.jeanbarrossilva.period.extensions.view.unreveal
import com.jeanbarrossilva.period.ui.R

class SearchBox: CardView {
    private var onQueryChangeListeners = mutableListOf<OnQueryChangeListener>()

    private lateinit var fieldLayout: FrameLayout
    private lateinit var field: EditText

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
        radius = 50.dp(context).toFloat()
        setContentPadding(0, 5.dp(context), 0, 5.dp(context))
        setOnClickListener {
            field.requestFocus()
        }
    }

    private fun initViews() {
        fieldLayout = FrameLayout(context).apply {
            layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }

        // For some reason, instantiating it as EditText(context, attrs, defStyleAttr) makes the View unusable.
        field = EditText(context).apply {
            textAlignment = TEXT_ALIGNMENT_TEXT_START
            isSingleLine = true
            background = ColorDrawable(Color.TRANSPARENT)
            layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                gravity = Gravity.CENTER
            }
            setHint(R.string.SearchBox_hint)
            doOnTextChanged { text ->
                textAlignment = if (text.isEmpty()) TEXT_ALIGNMENT_TEXT_START else TEXT_ALIGNMENT_CENTER
                onQueryChangeListeners.forEach { listener ->
                    listener.onQueryChange(text)
                }
            }
        }
    }

    private fun addViews() {
        addView(fieldLayout)
        fieldLayout.addView(field)
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
        when {
            isAttachedToWindow ->
                if (willBeVisible) {
                    super.setVisibility(visibility)
                    reveal {
                        if (opensKeyboardIfVisible)
                            field.openKeyboard()
                    }
                } else
                    unreveal {
                        super.setVisibility(visibility)
                        field.closeKeyboard()
                        field.text.clear()
                    }
            else -> super.setVisibility(visibility)
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