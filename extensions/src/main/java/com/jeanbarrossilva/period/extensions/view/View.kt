package com.jeanbarrossilva.period.extensions.view

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import com.jeanbarrossilva.period.extensions.animator.doOnEnd
import com.jeanbarrossilva.period.extensions.createCircularReveal
import com.jeanbarrossilva.period.extensions.hypot
import kotlin.reflect.KClass

val View.centerX
    get() = x + width / 2
val View.centerY
    get() = y + height / 2

@Suppress("UNCHECKED_CAST")
@PublishedApi
internal fun <V: View> View.searchFor(isInclusive: Boolean, viewClass: KClass<V>): V? {
    var foundView: V? = null
    if (this::class == viewClass && isInclusive)
        foundView =  this as V
    else if (this is ViewGroup)
        for (child in children)
            if (child::class == viewClass) {
                foundView = child as V
                break
            } else if (child is ViewGroup)
                foundView = child.searchFor(isInclusive = false, viewClass)
    return foundView
}

fun View.reveal(
    onEnd: () -> Unit = {
    }
) = createCircularReveal(this, startRadius = 0f, endRadius = hypot(width, height))
    .doOnEnd(onEnd)
    .start()

inline fun <reified V: View> View.searchFor(isInclusive: Boolean = true) = searchFor(isInclusive, V::class)

fun View.unreveal(
    onEnd: () -> Unit = {
    }
) = createCircularReveal(this, startRadius = hypot(width, height), endRadius = 0f)
    .doOnEnd(onEnd)
    .start()

fun View.updatePadding(left: Int = paddingLeft, top: Int = paddingTop, right: Int = paddingRight, bottom: Int = paddingBottom) = setPadding(left, top, right, bottom)