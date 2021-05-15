package com.jeanbarrossilva.period.ui.fragment

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.jeanbarrossilva.period.extensions.activity.toolbar
import com.jeanbarrossilva.period.extensions.animator.doOnEnd
import com.jeanbarrossilva.period.extensions.context.dialog
import com.jeanbarrossilva.period.extensions.filter.clear
import com.jeanbarrossilva.period.extensions.fragment.withFab
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

    private lateinit var elementsView: RecyclerView

    private fun assignViews(view: View) {
        elementsView = view.findViewById(R.id.elements_view)
    }

    private fun configToolbar() {
        activity?.toolbar?.inflateMenu(R.menu.menu_main_toolbar)
        activity?.toolbar?.searchItem?.setOnMenuItemClickListener {
            (activity as? SearchActivity)?.onStartSearch()
            true
        }
    }

    private fun configFab() {
        context?.let { context ->
            val sortingOptionTitles = ChemicalElementSortingOption.values(context).map { sortingOption ->
                sortingOption.title
            }

            withFab {
                setImageResource(R.drawable.ic_round_filter_alt_24)
                setOnClickListener {
                    context.dialog {
                        title(R.string.MaterialDialog_title_sort)
                        listItemsSingleChoice(items = sortingOptionTitles, initialSelection = ChemicalElementSortingOption.getPreferredIndex(context)) { _, index, _ ->
                            val selectedSortingOption = ChemicalElementSortingOption.values(context)[index]
                            viewModel.setSortingOption(selectedSortingOption)
                            dismiss()
                        }
                    }
                }
            }
        }
    }

    private fun onElementClick(element: ChemicalElement) {
        (activity as? SearchActivity)?.onExitSearch()
        findNavController().navigate(ChemicalElementsFragmentDirections.toDetailsOf(element))
    }

    private fun showElements() {
        viewModel.getSortingOption().observe(viewLifecycleOwner) { sortingOption ->
            elementsView.adapter = ChemicalElementAdapter(sortingOption, ::onElementClick)
            elementsView.layoutManager = LinearLayoutManager(context)
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

    private fun configElementsSearch() {
        val elementAdapter = elementsView.adapter as? Filterable
        (activity as? SearchActivity)?.run {
            addOnQueryChangeListener { query ->
                elementAdapter?.filter?.filter(query)
            }
            addOnSearchEventListener(OnSearchEventListener { isSearching ->
                if (!isSearching)
                    elementAdapter?.filter?.clear()
            })
        }
    }

    override fun onResume() {
        super.onResume()
        configToolbar()
        configFab()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        super.onCreateView(inflater, container, savedInstanceState)?.also { view ->
            assignViews(view)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showElements()
        listenToSortingOption()
        freeUpSpaceForBoxOnSearchEvent()
        configElementsSearch()
    }
}