package com.jeanbarrossilva.period.data

import kotlin.math.roundToInt

data class ChemicalElementAtomicMass(val value: Float): Representable {
    override val representation = "$value u"

    operator fun minus(other: ChemicalElementAtomicNumber) = ChemicalElementNeutrons(this.value.roundToInt() - other.value)
}