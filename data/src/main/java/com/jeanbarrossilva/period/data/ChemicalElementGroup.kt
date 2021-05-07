package com.jeanbarrossilva.period.data

import androidx.annotation.IntRange

data class ChemicalElementGroup(@IntRange(from = 1, to = 18) val value: Int): Representable {
    override val representation = value.toString()
}