package com.jeanbarrossilva.period.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomappbar.BottomAppBar
import com.jeanbarrossilva.period.extensions.activity.fab
import com.jeanbarrossilva.period.extensions.activity.toolbar
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.view.ChemicalElementDetailsView
import com.jeanbarrossilva.period.ui.view.ChemicalElementSymbolView

class ChemicalElementDetailsFragment: Fragment(R.layout.fragment_chemical_element_details) {
    private val navArgs by navArgs<ChemicalElementDetailsFragmentArgs>()
    private val element by lazy {
        navArgs.element
    }

    private lateinit var symbolView: ChemicalElementSymbolView
    private lateinit var nameView: TextView
    private lateinit var electronConfigurationView: TextView
    private lateinit var detailsView: ChemicalElementDetailsView

    private fun assignViews(view: View) {
        symbolView = view.findViewById(R.id.symbol_view)
        nameView = view.findViewById(R.id.name_view)
        electronConfigurationView = view.findViewById(R.id.electron_configuration_view)
        detailsView = view.findViewById(R.id.details_view)
    }

    private fun configToolbar() {
        activity?.toolbar?.menu?.clear()
        (activity?.toolbar as? BottomAppBar)?.performHide()
    }

    private fun configFab() {
        activity?.fab?.hide()
    }

    private fun showDetails() {
        symbolView.element = element
        nameView.text = element.name.value
        electronConfigurationView.text = element.electronConfiguration.value
        detailsView.element = element
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