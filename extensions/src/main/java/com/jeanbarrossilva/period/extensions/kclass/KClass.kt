package com.jeanbarrossilva.period.extensions.kclass

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.kotlinFunction

fun <T: Any> KClass<T>.values(vararg args: Any?) = sealedSubclasses.map { it.objectInstance ?: it.primaryConstructor!!.call(*args) }