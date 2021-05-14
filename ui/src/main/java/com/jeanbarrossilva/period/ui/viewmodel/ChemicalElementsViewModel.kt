package com.jeanbarrossilva.period.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.period.model.ChemicalElementSortingOption
import com.jeanbarrossilva.period.extensions.mutablelivedata.immutable

class ChemicalElementsViewModel(context: Context): ViewModel() {
    private val sortingOption = MutableLiveData(ChemicalElementSortingOption.getPreferred(context))

    fun getSortingOption() = sortingOption.immutable()

    fun setSortingOption(sortingOption: ChemicalElementSortingOption<*>) {
        this.sortingOption.value = sortingOption
    }
}