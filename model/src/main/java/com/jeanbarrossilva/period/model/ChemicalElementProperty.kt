package com.jeanbarrossilva.period.model

import java.io.Serializable
import kotlin.reflect.KProperty

open class ChemicalElementProperty<T> internal constructor(open val value: T): Serializable {
    override fun toString(): String {
        return "ChemicalElementProperty(value=$value)"
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>) = value
}