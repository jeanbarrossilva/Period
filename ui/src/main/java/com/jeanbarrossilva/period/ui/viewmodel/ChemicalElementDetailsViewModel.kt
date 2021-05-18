package com.jeanbarrossilva.period.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.period.model.ChemicalElementSortingOption

class ChemicalElementDetailsViewModel: ViewModel() {
    private val sortingOption = MutableLiveData<ChemicalElementSortingOption<*>>()

    fun getSortingOption(): LiveData<ChemicalElementSortingOption<*>> {
        return sortingOption
    }

    fun setSortingOption(sortingOption: ChemicalElementSortingOption<*>) {
        this.sortingOption.value = sortingOption
    }
}