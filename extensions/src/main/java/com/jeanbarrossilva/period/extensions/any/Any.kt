package com.jeanbarrossilva.period.extensions.any

import kotlin.reflect.KClass

fun <T> T.doIf(condition: Boolean, action: T.() -> T) = if (condition) this.action() else this

fun <T> T.doIf(condition: T.() -> Boolean, action: T.() -> T) = doIf(this.condition(), action)

fun <T: Any> T.instanceof(vararg classes: KClass<*>) = classes.any {
    this::class == it
}