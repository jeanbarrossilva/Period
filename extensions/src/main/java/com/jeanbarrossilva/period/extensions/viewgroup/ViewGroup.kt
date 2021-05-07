package com.jeanbarrossilva.period.extensions.viewgroup

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
@PublishedApi
internal fun <V: View> ViewGroup.searchFor(isInclusive: Boolean, viewClass: KClass<V>): V? {
    if (this::class == viewClass && isInclusive)
        return this as V
    else
        children.forEach { child ->
            if (child::class == viewClass)
                return child as V
            else if (child is ViewGroup)
                child.searchFor(isInclusive = false, viewClass)
        }

    return null
}

inline fun <reified V: View> ViewGroup.searchFor(isInclusive: Boolean = true) = searchFor(isInclusive, V::class)