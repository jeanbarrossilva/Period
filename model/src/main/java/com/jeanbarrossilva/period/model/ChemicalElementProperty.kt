package com.jeanbarrossilva.period.model

import java.io.Serializable
import kotlin.reflect.KProperty

open class ChemicalElementProperty<T: Comparable<T>> internal constructor(open val value: T, val measurementUnit: MeasurementUnit? = null): Serializable {
    override fun toString(): String {
        return "ChemicalElementProperty(value=$value)"
    }

    operator fun contains(other: CharSequence): Boolean {
        return value is CharSequence && (value as CharSequence).contains(other, ignoreCase = true)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>) = value
}