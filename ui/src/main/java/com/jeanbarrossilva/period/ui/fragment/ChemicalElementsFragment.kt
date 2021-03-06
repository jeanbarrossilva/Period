package com.jeanbarrossilva.period.ui.fragment

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.jeanbarrossilva.period.extensions.activity.fab
import com.jeanbarrossilva.period.extensions.activity.toolbar
import com.jeanbarrossilva.period.extensions.animator.doOnEnd
import com.jeanbarrossilva.period.extensions.context.dialog
import com.jeanbarrossilva.period.extensions.context.isInLandscape
import com.jeanbarrossilva.period.extensions.filter.clear
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.extensions.valueanimator.addUpdateListener
import com.jeanbarrossilva.period.extensions.view.updatePadding
import com.jeanbarrossilva.period.extensions.viewmodelprovider.viewModelFactory
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.model.ChemicalElementSortingOption
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.activity.core.SearchActivity
import com.jeanbarrossilva.period.ui.adapter.ChemicalElementAdapter
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener
import com.jeanbarrossilva.period.ui.viewmodel.ChemicalElementsViewModel

class ChemicalElementsFragment: Fragment(R.layout.fragment_chemical_elements) {
    private val Toolbar.searchItem
        get() = menu.findItem(R.id.menu_item_search)

    private val viewModel by viewModels<ChemicalElementsViewModel> {
        viewModelFactory(context)
    }

    private var didRequestSortingDialog = false
    private var didClickOnSomeElement = false

    private lateinit var elementsView: RecyclerView

    private fun assignViews(view: View) {
        elementsView = view.findViewById(R.id.elements_view)
    }

    private fun configToolbar() {
        activity?.toolbar?.menu?.clear()
        activity?.toolbar?.inflateMenu(R.menu.menu_main_toolbar)
        activity?.toolbar?.searchItem?.setOnMenuItemClickListener {
            (activity as? SearchActivity)?.onSearchEvent(isSearching = true)
            true
        }
    }

    private fun configFab() {
        context?.let { context ->
            val sortingOptionTitles = ChemicalElementSortingOption.values(context).map { sortingOption ->
                sortingOption.title
            }

            activity?.fab?.setImageResource(R.drawable.ic_round_filter_alt_24)
            activity?.fab?.setOnClickListener {
                didRequestSortingDialog = true
                if (!didClickOnSomeElement)
                    context.dialog {
                        title(R.string.MaterialDialog_title_sort)
                        onDismiss {
                            didRequestSortingDialog = false
                        }
                        listItemsSingleChoice(items = sortingOptionTitles, initialSelection = ChemicalElementSortingOption.getPreferredIndex(context)) { _, index, _ ->
                            val selectedSortingOption = ChemicalElementSortingOption.values(context)[index]
                            viewModel.setSortingOption(selectedSortingOption)
                            dismiss()
                        }
                    }
            }
            activity?.fab?.show()
        }
    }

    private fun configSearchIconVisibility() {
        (activity as? SearchActivity)?.addOnSearchEventListener { isSearching ->
            activity?.toolbar?.searchItem?.isVisible = !isSearching
        }
    }

    private fun configElementSearch(adapter: ChemicalElementAdapter) {
        (activity as? SearchActivity)?.run {
            addOnQueryChangeListener { query ->
                adapter.filter.filter(query)
            }
            addOnSearchEventListener { isSearching ->
                if (!isSearching)
                    adapter.filter.clear()
            }
        }
    }

    private fun onElementClick(element: ChemicalElement) {
        if (!didRequestSortingDialog) {
            didClickOnSomeElement = true
            (activity as? SearchActivity)?.onSearchEvent(isSearching = false)
            findNavController().navigate(ChemicalElementsFragmentDirections.toDetailsOf(element)).also {
                viewModel.getSortingOption().value?.let { sortingOption ->
                    setFragmentResult("sortingOption", bundleOf("sortingOption" to sortingOption))
                }
            }
        }
    }

    private fun showElements() {
        viewModel.getSortingOption().observe(viewLifecycleOwner) { sortingOption ->
            elementsView.adapter = ChemicalElementAdapter(sortingOption, ::onElementClick).also(::configElementSearch)
            elementsView.layoutManager = if (context?.isInLandscape == true) GridLayoutManager(context, 2) else LinearLayoutManager(context)
        }
    }

    private fun listenToSortingOption() {
        viewModel.getSortingOption().observe(viewLifecycleOwner) { sortingOption ->
            context?.let {
                ChemicalElementSortingOption.prefer(it, sortingOption)
            }
        }
    }

    @Suppress("Recycle")
    private fun freeUpSpaceForBoxOnSearchEvent() {
        (activity as? SearchActivity)?.addOnSearchEventListener(OnSearchEventListener { isSearching ->
            val finalPaddingTop = if (isSearching) 100.dp(context) else 0
            ValueAnimator
                .ofInt(elementsView.paddingTop, finalPaddingTop)
                .addUpdateListener<Int> {
                    elementsView.updatePadding(top = it)
                }
                .doOnEnd {
                    if (isSearching && elementsView.computeVerticalScrollOffset() <= 3000)
                        elementsView.smoothScrollToPosition(0)
                }
                .start()
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        super.onCreateView(inflater, container, savedInstanceState)?.also { view ->
            assignViews(view)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configSearchIconVisibility()
        showElements()
        listenToSortingOption()
        freeUpSpaceForBoxOnSearchEvent()
    }

    override fun onResume() {
        super.onResume()
        didClickOnSomeElement = false
        configToolbar()
        configFab()
    }
}