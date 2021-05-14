package com.jeanbarrossilva.period.model

import java.io.Serializable
import kotlin.reflect.KProperty

open class ChemicalElementProperty<T> internal constructor(open val value: T): Serializable {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = value
}