package com.jeanbarrossilva.period.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jeanbarrossilva.period.extensions.activity.fab
import com.jeanbarrossilva.period.extensions.activity.toolbar
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.view.ChemicalElementSymbolView

class ChemicalElementDetailsFragment: Fragment(R.layout.fragment_chemical_element_details) {
    private val navArgs by navArgs<ChemicalElementDetailsFragmentArgs>()
    private val element by lazy {
        navArgs.element
    }

    private lateinit var symbolView: ChemicalElementSymbolView
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
        symbolView = view.findViewById(R.id.symbol_view)
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

    private fun configToolbar() {
        activity?.toolbar?.menu?.clear()
    }

    private fun configFab() {
        activity?.fab?.hide()
    }

    private fun showDetails() {
        symbolView.element = element
        nameView.text = element.name.value
        electronConfigurationView.text = element.electronConfiguration.value
        kindView.text = element.kind.name
        groupView.text = element.group?.value.toString()
        periodView.text = element.period?.value.toString()
        protonsView.text = element.protons.value.toString()
        neutronsView.text = element.neutrons.value.toString()
        electronsView.text = element.electrons.toString()
        electronegativityView.text = element.electronegativity?.value.toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        super.onCreateView(inflater, container, savedInstanceState)?.also { view ->
            assignViews(view)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDetails()
    }

    override fun onResume() {
        super.onResume()
        configToolbar()
        configFab()
    }
}