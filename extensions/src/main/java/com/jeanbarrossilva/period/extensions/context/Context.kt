package com.jeanbarrossilva.period.extensions.context

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.TypedArray
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.annotation.StyleableRes
import androidx.core.content.getSystemService
import androidx.core.content.res.use
import androidx.core.content.withStyledAttributes
import androidx.preference.PreferenceManager
import com.afollestad.materialdialogs.MaterialDialog
import com.jeanbarrossilva.period.extensions.number.to

val Context.inputMethodManager
    get() = getSystemService<InputMethodManager>()
val Context.isInLandscape
    get() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
val Context.preferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)

infix fun Context.colorOf(@AttrRes attrRes: Int) = obtainStyledAttributes(intArrayOf(attrRes)).use {
    it.getColor(0, Color.TRANSPARENT)
}

@PublishedApi
internal inline infix fun <reified N : Number> Context.convert(conversion: Pair<Number, Int>) = conversion.let { (value, unit) ->
    TypedValue.applyDimension(unit, value.toFloat(), resources.displayMetrics).to<N>()
}

fun Context.dialog(onShow: MaterialDialog.() -> Unit) {
    MaterialDialog(this).show {
        if (Build.VERSION.SDK_INT >= 30)
            cornerRadius(25f)
        onShow()
    }
}

fun Context.toast(
    message: String,
    length: Int = Toast.LENGTH_SHORT,
    update: Toast.() -> Unit = {
    }
) {
    Toast.makeText(this, message, length).apply(update).show()
}

fun Context.withStyledAttributes(attrs: AttributeSet?, defStyleAttr: Int, @StyleableRes styleableRes: IntArray, onEachIndex: TypedArray.(Int) -> Unit) =
    withStyledAttributes(attrs, styleableRes, defStyleAttr, 0) {
        0.until(indexCount).forEach { index ->
            onEachIndex(this, index)
        }
    }