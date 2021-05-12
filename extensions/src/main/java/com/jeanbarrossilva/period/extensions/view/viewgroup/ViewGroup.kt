package com.jeanbarrossilva.period.extensions.view.viewgroup

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
@PublishedApi
internal fun <V: View> ViewGroup.searchFor(isInclusive: Boolean, viewClass: KClass<V>): V? {
    var foundView: V? = null
    if (this::class == viewClass && isInclusive)
        foundView =  this as V
    else
        for (child in children)
            if (child::class == viewClass) {
                foundView = child as V
                break
            } else if (child is ViewGroup)
                foundView =  child.searchFor(isInclusive = false, viewClass)
    return foundView
}

inline fun <reified V: View> ViewGroup.searchFor(isInclusive: Boolean = true) = searchFor(isInclusive, V::class)