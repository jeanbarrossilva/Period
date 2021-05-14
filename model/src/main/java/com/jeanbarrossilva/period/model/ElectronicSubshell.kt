package com.jeanbarrossilva.period.model

import androidx.annotation.IntRange
import com.jeanbarrossilva.period.extensions.int.superscript

sealed class ElectronicSubshell(val name: Char, electronCount: Int): ChemicalElementProperty<String>("$name${electronCount.superscript}") {
    class S internal constructor(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronicSubshell('s', electronCount)

    class P internal constructor(@IntRange(from = 1, to = P_CAPACITY) electronCount: Int):
        ElectronicSubshell('p', electronCount)

    class D internal constructor(@IntRange(from = 1, to = D_CAPACITY) electronCount: Int):
        ElectronicSubshell('d', electronCount,)

    class F internal constructor(@IntRange(from = 1, to = F_CAPACITY) electronCount: Int):
        ElectronicSubshell('f', electronCount)

    companion object {
        const val S_CAPACITY = 2L
        const val P_CAPACITY = 6L
        const val D_CAPACITY = 10L
        const val F_CAPACITY = 14L
    }
}