package com.jeanbarrossilva.period.model

import java.io.Serializable

sealed class MeasurementUnit(val symbol: String): Serializable {
    object AtomicMass: MeasurementUnit("u")
}