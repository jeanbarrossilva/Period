package com.jeanbarrossilva.period.data

import java.io.Serializable
import kotlin.reflect.KProperty

interface Representable: Serializable {
    val representation: String

    operator fun contains(other: CharSequence) = representation.contains(other, ignoreCase = true)

    operator fun getValue(thisRef: Any?, property: KProperty<*>) = representation
}