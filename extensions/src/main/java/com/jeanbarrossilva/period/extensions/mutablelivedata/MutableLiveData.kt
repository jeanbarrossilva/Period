package com.jeanbarrossilva.period.extensions.mutablelivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KProperty

operator fun <T> MutableLiveData<T>.getValue(thisRef: Any?, property: KProperty<*>) = value

operator fun <T> MutableLiveData<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
}

fun <T> MutableLiveData<T>.immutable(): LiveData<T> = this