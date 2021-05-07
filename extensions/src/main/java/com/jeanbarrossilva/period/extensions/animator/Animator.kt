package com.jeanbarrossilva.period.extensions

import android.animation.Animator
import androidx.core.animation.doOnEnd

fun Animator.doOnEnd(action: () -> Unit) = this.also {
    doOnEnd {
        action()
    }
}