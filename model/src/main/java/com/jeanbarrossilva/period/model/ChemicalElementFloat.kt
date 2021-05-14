package com.jeanbarrossilva.period.model

import kotlin.math.roundToInt

sealed class ChemicalElementFloat(override val value: Float): ChemicalElementProperty<Float>(value) {
    data class AtomicMass(override val value: Float): ChemicalElementFloat(value) {
        operator fun minus(other: ChemicalElementInteger.AtomicNumber) = ChemicalElementInteger.Neutrons(value.roundToInt() - other.value)
    }

    data class Electronegativity(override val value: Float): ChemicalElementFloat(value)
}