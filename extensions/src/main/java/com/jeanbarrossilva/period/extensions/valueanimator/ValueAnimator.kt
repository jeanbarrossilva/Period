package com.jeanbarrossilva.period.extensions.valueanimator

import android.animation.ValueAnimator

fun <T> ValueAnimator.addUpdateListener(listener: (T) -> Unit) = this.also {
    addUpdateListener { animator ->
        listener(animator.animatedValue as T)
    }
}