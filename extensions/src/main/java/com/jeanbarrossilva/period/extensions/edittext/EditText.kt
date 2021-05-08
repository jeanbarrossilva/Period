package com.jeanbarrossilva.period.extensions

import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.getSystemService
import androidx.core.widget.doOnTextChanged

fun EditText.doOnTextChanged(action: (text: String) -> Unit) = doOnTextChanged { text, _, _, _ ->
    text?.let {
        action("$it")
    }
}

fun EditText.closeKeyboard() {
    clearFocus()
    context.getSystemService<InputMethodManager>()?.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun EditText.openKeyboard() {
    requestFocus()
    context.getSystemService<InputMethodManager>()?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}