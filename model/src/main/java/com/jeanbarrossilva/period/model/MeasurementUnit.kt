package com.jeanbarrossilva.period.model

sealed class MeasurementUnit(val symbol: String) {
    object AtomicMass: MeasurementUnit("u")
}