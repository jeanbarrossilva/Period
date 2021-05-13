package com.jeanbarrossilva.period.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jeanbarrossilva.period.ui.R

class ChemicalElementDetailsFragment: Fragment(R.layout.fragment_chemical_element_details) {
    private val navArgs by navArgs<ChemicalElementDetailsFragmentArgs>()
    private val element by lazy {
        navArgs.element
    }

    private lateinit var atomicNumberView: TextView
    private lateinit var symbolView: TextView
    private lateinit var atomicMassView: TextView
    private lateinit var nameView: TextView
    private lateinit var electronConfigurationView: TextView
    private lateinit var kindView: TextView
    private lateinit var groupView: TextView
    private lateinit var periodView: TextView
    private lateinit var protonsView: TextView
    private lateinit var neutronsView: TextView
    private lateinit var electronsView: TextView
    private lateinit var electronegativityView: TextView

    private fun assignViews(view: View) {
        atomicNumberView = view.findViewById(R.id.atomic_number_view)
        symbolView = view.findViewById(R.id.symbol_view)
        atomicMassView = view.findViewById(R.id.atomic_mass_view)
        nameView = view.findViewById(R.id.name_view)
        electronConfigurationView = view.findViewById(R.id.electron_configuration_view)
        kindView = view.findViewById(R.id.kind_view)
        groupView = view.findViewById(R.id.group_view)
        periodView = view.findViewById(R.id.period_view)
        protonsView = view.findViewById(R.id.protons_view)
        neutronsView = view.findViewById(R.id.neutrons_view)
        electronsView = view.findViewById(R.id.electrons_view)
        electronegativityView = view.findViewById(R.id.electronegativity_view)
    }

    private fun showDetails() {
        atomicNumberView.text = element.atomicNumber.representation
        symbolView.text = element.symbol.representation
        atomicMassView.text = element.atomicMass.representation
        nameView.text = element.name.representation
        electronConfigurationView.text = element.electronConfiguration.representation
        kindView.text = element.kind.representation
        groupView.text = element.group?.representation
        periodView.text = element.period?.representation
        protonsView.text = element.protons.representation
        neutronsView.text = element.neutrons.representation
        electronsView.text = element.electrons.representation
        electronegativityView.text = element.electronegativity?.representation.toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        super.onCreateView(inflater, container, savedInstanceState)?.also { view ->
            assignViews(view)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDetails()
    }
}