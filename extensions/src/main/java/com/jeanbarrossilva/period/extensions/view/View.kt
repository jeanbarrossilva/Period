package com.jeanbarrossilva.period.extensions.view

import android.view.View
import android.view.ViewGroup
import com.jeanbarrossilva.period.extensions.animator.doOnEnd
import com.jeanbarrossilva.period.extensions.createCircularReveal
import com.jeanbarrossilva.period.extensions.hypot
import kotlin.reflect.full.primaryConstructor

val View.centerX
    get() = x + width / 2
val View.centerY
    get() = y + height / 2

fun View.matchParent() = setSize(ViewGroup.LayoutParams.MATCH_PARENT)

fun View.reveal(
    onEnd: () -> Unit = {
    }
) = createCircularReveal(this, startRadius = 0f, endRadius = hypot(width, height))
    .doOnEnd(onEnd)
    .start()

fun View.setSize(size: Int) = updateLayoutParams {
    width = size
    height = size
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
@JvmName("updateLayoutParamsWithGenerics")
inline fun <reified LP: ViewGroup.LayoutParams> View.updateLayoutParams(noinline update: LP.() -> Unit) {
    LP::class.primaryConstructor?.call(width, height)?.let { fallback ->
        updateLayoutParams(fallback, update as ViewGroup.LayoutParams.() -> Unit)
    }
}

fun View.wrapContent() = setSize(ViewGroup.LayoutParams.WRAP_CONTENT)