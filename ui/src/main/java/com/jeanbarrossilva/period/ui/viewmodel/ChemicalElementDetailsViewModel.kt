package com.jeanbarrossilva.period.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.period.data.ChemicalElement
import com.jeanbarrossilva.period.ui.fragment.ChemicalElementDetailsFragment

class ChemicalElementDetailsViewModel: ViewModel() {
    fun showElementDetails(fragment: ChemicalElementDetailsFragment, element: ChemicalElement) {
        fragment.atomicNumberView.text = element.atomicNumber.representation
        fragment.symbolView.text = element.symbol.representation
        fragment.atomicMassView.text = element.atomicMass.representation
        fragment.nameView.text = element.name.representation
        fragment.electronConfigurationView.text = element.electronConfiguration.representation
        fragment.kindView.text = element.kind.representation
        fragment.groupView.text = element.group?.representation
        fragment.periodView.text = element.period?.representation
        fragment.protonsView.text = element.protons.representation
        fragment.neutronsView.text = element.neutrons.representation
        fragment.electronsView.text = element.electrons.representation
        fragment.electronegativityView.text = element.electronegativity?.representation.toString()
    }
}