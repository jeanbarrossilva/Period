package com.jeanbarrossilva.period.extensions.number

import android.content.Context
import android.util.TypedValue
import com.jeanbarrossilva.period.extensions.convert
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
@PublishedApi
internal fun <T : Number> Number.to(numberClass: KClass<T>): T =
    when (numberClass) {
        Byte::class -> toByte()
        Float::class -> toFloat()
        Int::class -> toInt()
        Long::class -> toLong()
        Short::class -> toInt().toShort()
        else -> throw IllegalStateException()
    } as T

fun Number.dp(context: Context?) = context?.convert(this to TypedValue.COMPLEX_UNIT_DIP) ?: this.toInt()

inline fun <reified T : Number> Number.to() = to(T::class)