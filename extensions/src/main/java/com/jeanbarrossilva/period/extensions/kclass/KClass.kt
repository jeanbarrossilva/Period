package com.jeanbarrossilva.period.extensions

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

fun <T: Any> KClass<T>.values(vararg args: Any?) = sealedSubclasses.map { it.objectInstance ?: it.primaryConstructor!!.call(*args) }