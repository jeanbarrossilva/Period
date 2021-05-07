package com.jeanbarrossilva.period.extensions

import android.view.View

val View.centerX
    get() = x + width / 2
val View.centerY
    get() = y + height / 2

fun View.reveal(
    onEnd: () -> Unit = {
    }
) = createCircularReveal(this, startRadius = 0f, endRadius = hypot(width, height))
    .doOnEnd(onEnd)
    .start()

fun View.setPadding(left: Int = paddingLeft, top: Int = paddingTop, right: Int = paddingRight, bottom: Int = paddingBottom) = setPadding(left, top, right, bottom)

fun View.unreveal(
    onEnd: () -> Unit = {
    }
) = createCircularReveal(this, startRadius = hypot(width, height), endRadius = 0f)
    .doOnEnd(onEnd)
    .start()