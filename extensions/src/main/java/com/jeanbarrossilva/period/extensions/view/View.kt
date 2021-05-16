package com.jeanbarrossilva.period.extensions.view

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import com.jeanbarrossilva.period.extensions.animator.doOnEnd
import com.jeanbarrossilva.period.extensions.createCircularReveal
import com.jeanbarrossilva.period.extensions.hypot
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

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

fun View.matchParent() = setSize(ViewGroup.LayoutParams.MATCH_PARENT)

fun View.reveal(
    onEnd: () -> Unit = {
    }
) = createCircularReveal(this, startRadius = 0f, endRadius = hypot(width, height))
    .doOnEnd(onEnd)
    .start()

inline fun <reified V: View> View.searchFor(isInclusive: Boolean = true) = searchFor(isInclusive, V::class)

fun View.setHeight(height: Int) {
    updateLayoutParams {
        this.height = height
    }
}

fun View.setSize(size: Int) {
    setWidth(size)
    setHeight(size)
}

fun View.setWidth(width: Int) {
    updateLayoutParams {
        this.width = width
    }
}

fun View.unreveal(
    onEnd: () -> Unit = {
    }
) = createCircularReveal(this, startRadius = hypot(width, height), endRadius = 0f)
    .doOnEnd(onEnd)
    .start()

fun View.updatePadding(left: Int = paddingLeft, top: Int = paddingTop, right: Int = paddingRight, bottom: Int = paddingBottom) = setPadding(left, top, right, bottom)

fun View.updateLayoutParams(
    fallback: ViewGroup.LayoutParams = ViewGroup.LayoutParams(width, height),
    update: ViewGroup.LayoutParams.() -> Unit
) {
    if (layoutParams == null)
        layoutParams = fallback
    layoutParams!!.update()
}

@Suppress("UNCHECKED_CAST")
inline fun <reified LP: ViewGroup.LayoutParams> View.updateLayoutParams(noinline update: LP.() -> Unit) {
    updateLayoutParams(fallback = LP::class.primaryConstructor!!.call(width, height), update as ViewGroup.LayoutParams.() -> Unit)
}

fun View.wrapContent() = setSize(ViewGroup.LayoutParams.WRAP_CONTENT)