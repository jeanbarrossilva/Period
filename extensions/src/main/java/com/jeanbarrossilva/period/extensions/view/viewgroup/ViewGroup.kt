package com.jeanbarrossilva.period.extensions.view.viewgroup

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children

fun ViewGroup.identifyUnidentifiedChildren() {
    children.filter { child ->
        child.id == View.NO_ID
    }.forEach { child ->
        child.id = View.generateViewId()
    }
}