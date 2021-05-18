package com.jeanbarrossilva.period.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomappbar.BottomAppBar
import com.jeanbarrossilva.period.extensions.activity.fab
import com.jeanbarrossilva.period.extensions.activity.toolbar
import com.jeanbarrossilva.period.model.ChemicalElementSortingOption
import com.jeanbarrossilva.period.ui.composable.ChemicalElementDetailsUI
import com.jeanbarrossilva.period.ui.viewmodel.ChemicalElementDetailsViewModel

class ChemicalElementDetailsFragment: Fragment() {
    private val viewModel by viewModels<ChemicalElementDetailsViewModel>()
    private val navArgs by navArgs<ChemicalElementDetailsFragmentArgs>()
    private val element by lazy {
        navArgs.element
    }

    private fun configToolbar() {
        activity?.toolbar?.menu?.clear()
        (activity?.toolbar as? BottomAppBar)?.performShow()
    }

    private fun configFab() {
        activity?.fab?.hide()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("sortingOption") { _, bundle ->
            viewModel.setSortingOption(bundle["sortingOption"] as ChemicalElementSortingOption<*>)
        }
    }

    @Suppress("LocalVariableName")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val _sortingOption by viewModel.getSortingOption().observeAsState()
                val elementIndex = _sortingOption?.getElements().orEmpty().indexOf(element)

                _sortingOption?.let { sortingOption ->
                    ChemicalElementDetailsUI(elementIndex, sortingOption)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        configToolbar()
        configFab()
    }
}