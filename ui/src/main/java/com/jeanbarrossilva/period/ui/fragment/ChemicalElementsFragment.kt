package com.jeanbarrossilva.period.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.period.extensions.viewModelFactory
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.viewmodel.ChemicalElementsViewModel

class ChemicalElementsFragment: Fragment(R.layout.fragment_chemical_elements) {
    private val viewModel by viewModels<ChemicalElementsViewModel> { viewModelFactory(this) }

    lateinit var elementsView: RecyclerView
        private set

    private fun assignViews(root: View) {
        elementsView = root.findViewById(R.id.elements_view)
    }

    override fun onResume() {
        super.onResume()
        viewModel.configFab(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        super.onCreateView(inflater, container, savedInstanceState)?.also { root ->
            assignViews(root)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.run {
            showElements(this@ChemicalElementsFragment)
            listenToSortingOption(this@ChemicalElementsFragment)
            bringElementsDownOnSearch(this@ChemicalElementsFragment)
            configElementsSearch(this@ChemicalElementsFragment)
        }
    }
}