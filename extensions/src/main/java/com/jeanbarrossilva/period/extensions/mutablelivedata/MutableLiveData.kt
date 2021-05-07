package com.jeanbarrossilva.period.extensions

import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KProperty

operator fun <T> MutableLiveData<T>.getValue(thisRef: Any?, property: KProperty<*>) = value

operator fun <T> MutableLiveData<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
}