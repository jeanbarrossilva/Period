package com.jeanbarrossilva.period.model

import kotlin.math.roundToInt

sealed class ChemicalElementFloat(override val value: Float, measurementUnit: MeasurementUnit? = null): ChemicalElementProperty<Float>(value, measurementUnit) {
    data class AtomicMass(override val value: Float): ChemicalElementFloat(value, MeasurementUnit.AtomicMass) {
        operator fun minus(other: ChemicalElementInteger.AtomicNumber) = ChemicalElementInteger.Neutrons(value.roundToInt() - other.value)
    }

    data class Electronegativity(override val value: Float): ChemicalElementFloat(value)
}