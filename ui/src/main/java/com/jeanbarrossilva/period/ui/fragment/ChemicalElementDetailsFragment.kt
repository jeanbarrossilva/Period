package com.jeanbarrossilva.period.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.viewmodel.ChemicalElementDetailsViewModel

class ChemicalElementDetailsFragment: Fragment(R.layout.fragment_chemical_element_details) {
    private val viewModel by viewModels<ChemicalElementDetailsViewModel>()
    private val navArgs by navArgs<ChemicalElementDetailsFragmentArgs>()
    private val element by lazy {
        navArgs.element
    }

    lateinit var atomicNumberView: TextView
        private set
    lateinit var symbolView: TextView
        private set
    lateinit var atomicMassView: TextView
        private set
    lateinit var nameView: TextView
        private set
    lateinit var electronConfigurationView: TextView
        private set
    lateinit var kindView: TextView
        private set
    lateinit var groupView: TextView
        private set
    lateinit var periodView: TextView
        private set
    lateinit var protonsView: TextView
        private set
    lateinit var neutronsView: TextView
        private set
    lateinit var electronsView: TextView
        private set
    lateinit var electronegativityView: TextView
        private set

    private fun assignViews(root: View) {
        atomicNumberView = root.findViewById(R.id.atomic_number_view)
        symbolView = root.findViewById(R.id.symbol_view)
        atomicMassView = root.findViewById(R.id.atomic_mass_view)
        nameView = root.findViewById(R.id.name_view)
        electronConfigurationView = root.findViewById(R.id.electron_configuration_view)
        kindView = root.findViewById(R.id.kind_view)
        groupView = root.findViewById(R.id.group_view)
        periodView = root.findViewById(R.id.period_view)
        protonsView = root.findViewById(R.id.protons_view)
        neutronsView = root.findViewById(R.id.neutrons_view)
        electronsView = root.findViewById(R.id.electrons_view)
        electronegativityView = root.findViewById(R.id.electronegativity_view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        super.onCreateView(inflater, container, savedInstanceState)?.also { root ->
            assignViews(root)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showElementDetails(this, element)
    }
}