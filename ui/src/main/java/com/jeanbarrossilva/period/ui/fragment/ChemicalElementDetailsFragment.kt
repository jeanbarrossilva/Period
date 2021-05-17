package com.jeanbarrossilva.period.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomappbar.BottomAppBar
import com.jeanbarrossilva.period.extensions.activity.fab
import com.jeanbarrossilva.period.extensions.activity.toolbar
import com.jeanbarrossilva.period.ui.composable.ChemicalElementDetailsUI

class ChemicalElementDetailsFragment: Fragment() {
    private val navArgs by navArgs<ChemicalElementDetailsFragmentArgs>()
    private val element by lazy {
        navArgs.element
    }

    private fun configToolbar() {
        activity?.toolbar?.menu?.clear()
        (activity?.toolbar as? BottomAppBar)?.performHide()
    }

    private fun configFab() {
        activity?.fab?.hide()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ChemicalElementDetailsUI(element)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        configToolbar()
        configFab()
    }
}