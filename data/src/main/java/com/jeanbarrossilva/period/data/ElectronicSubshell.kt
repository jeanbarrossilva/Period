package com.jeanbarrossilva.period.data

import androidx.annotation.IntRange
import com.jeanbarrossilva.period.extensions.int.superscript

sealed class ElectronicSubshell(val name: Char, val electronCount: Int): Representable {
    override val representation = "$name${electronCount.superscript}"

    class S(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronicSubshell('s', electronCount)

    class P(@IntRange(from = 1, to = P_CAPACITY) electronCount: Int):
        ElectronicSubshell('p', electronCount)

    class D(@IntRange(from = 1, to = D_CAPACITY) electronCount: Int):
        ElectronicSubshell('d', electronCount,)

    class F(@IntRange(from = 1, to = F_CAPACITY) electronCount: Int):
        ElectronicSubshell('f', electronCount)

    companion object {
        const val S_CAPACITY = 2L
        const val P_CAPACITY = 6L
        const val D_CAPACITY = 10L
        const val F_CAPACITY = 14L
    }
}