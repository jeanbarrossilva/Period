package com.jeanbarrossilva.period.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.jvm.internal.Reflection
import kotlin.reflect.full.primaryConstructor

fun viewModelFactory(vararg args: Any?) = object: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) = Reflection.createKotlinClass(modelClass).primaryConstructor!!.call(*args) as T
}