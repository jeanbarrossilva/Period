package com.jeanbarrossilva.period.model

import androidx.annotation.IntRange

data class ChemicalElementPeriod(@IntRange(from = 1, to = 7) val value: Int): Representable {
    override val representation = value.toString()
}