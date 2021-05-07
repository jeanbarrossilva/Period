package com.jeanbarrossilva.period.extensions

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.StyleableRes
import androidx.core.content.res.use
import androidx.core.content.withStyledAttributes
import androidx.preference.PreferenceManager
import com.jeanbarrossilva.period.extensions.number.to

val Context.isSystemInDarkTheme
    get() = resources.configuration.uiMode == Configuration.UI_MODE_NIGHT_YES
val Context.preferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)

infix fun Context.colorOf(@AttrRes attrRes: Int) = obtainStyledAttributes(intArrayOf(attrRes)).use {
    it.getColor(0, Color.TRANSPARENT)
}

@PublishedApi
internal inline infix fun <reified N : Number> Context.convert(conversion: Pair<Number, Int>) = conversion.let { (value, unit) ->
    TypedValue.applyDimension(unit, value.toFloat(), resources.displayMetrics).to<N>()
}

fun Context.withStyledAttributes(attrs: AttributeSet?, defStyleAttr: Int, @StyleableRes styleableRes: IntArray, onEachIndex: TypedArray.(Int) -> Unit) =
    withStyledAttributes(attrs, styleableRes, defStyleAttr, 0) {
        0.until(indexCount).forEach { index ->
            onEachIndex(this, index)
        }
    }