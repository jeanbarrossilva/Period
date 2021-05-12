package com.jeanbarrossilva.period.extensions.view.edittext

import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.jeanbarrossilva.period.extensions.context.inputMethodManager

fun EditText.doOnTextChanged(action: (text: String) -> Unit) = doOnTextChanged { text, _, _, _ ->
    text?.let {
        action("$it")
    }
}

fun EditText.closeKeyboard() {
    clearFocus()
    context.inputMethodManager?.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS and InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun EditText.openKeyboard() {
    requestFocus()
    context.inputMethodManager?.showSoftInput(this@openKeyboard, InputMethodManager.SHOW_FORCED and InputMethodManager.SHOW_IMPLICIT)
}

fun EditText.toggleKeyboard(shouldOpen: Boolean) = if (shouldOpen) openKeyboard() else closeKeyboard()