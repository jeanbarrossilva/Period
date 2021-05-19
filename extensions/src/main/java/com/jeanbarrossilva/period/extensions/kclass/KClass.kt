package com.jeanbarrossilva.period.extensions.kclass

import com.jeanbarrossilva.period.extensions.any.doIf
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

@Suppress("UNCHECKED_CAST")
inline fun <reified T: Any> KClass<T>.values(vararg args: Any?): List<T> {
    return sealedSubclasses.map {
        it.objectInstance ?: it.primaryConstructor!!.call(*args)
    }.doIf({
        all { value ->
            value is Comparable<*>
        }
    }) {
        sortedBy { value ->
            value as Comparable<T>
            value
        }
    }
}