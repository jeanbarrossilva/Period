package com.jeanbarrossilva.period.ui.viewmodel

import android.animation.ValueAnimator
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.jeanbarrossilva.period.data.ChemicalElementSortingOption
import com.jeanbarrossilva.period.extensions.addUpdateListener
import com.jeanbarrossilva.period.extensions.animator.doOnEnd
import com.jeanbarrossilva.period.extensions.dialog
import com.jeanbarrossilva.period.extensions.filter.clear
import com.jeanbarrossilva.period.extensions.fragment.withFab
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.extensions.view.updatePadding
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.activity.MainActivity
import com.jeanbarrossilva.period.ui.adapter.ChemicalElementAdapter
import com.jeanbarrossilva.period.ui.fragment.ChemicalElementsFragment
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener

class ChemicalElementsViewModel(fragment: ChemicalElementsFragment): ViewModel() {
    private val sortingOption = MutableLiveData(ChemicalElementSortingOption.getPreferred(fragment.requireContext()))
    private val elementAdapter = MutableLiveData<ChemicalElementAdapter>()

    fun configFab(fragment: ChemicalElementsFragment) {
        val sortingOptionTitles = ChemicalElementSortingOption.values(fragment.requireContext()).map { sortingOption ->
            sortingOption.title
        }

        fragment.withFab {
            setImageResource(R.drawable.ic_round_filter_alt_24)
            setOnClickListener {
                context.dialog {
                    title(R.string.MaterialDialog_title_sort)
                    listItemsSingleChoice(items = sortingOptionTitles, initialSelection = ChemicalElementSortingOption.getPreferredIndex(context)) { _, index, _ ->
                        sortingOption.value = ChemicalElementSortingOption.values(context)[index]
                        dismiss()
                    }
                }
            }
        }
    }

    fun showElements(fragment: ChemicalElementsFragment) {
        elementAdapter.observe(fragment) { elementAdapter ->
            fragment.elementsView.adapter = elementAdapter
        }
        fragment.elementsView.layoutManager = LinearLayoutManager(fragment.context)
    }

    fun listenToSortingOption(fragment: ChemicalElementsFragment) = sortingOption.observe(fragment) { sortingOption ->
        ChemicalElementSortingOption.prefer(fragment.requireContext(), sortingOption)
        elementAdapter.value = ChemicalElementAdapter(sortingOption) {
        }
    }

    @Suppress("Recycle")
    fun freeUpSpaceForBoxOnSearchEvent(fragment: ChemicalElementsFragment) {
        (fragment.activity as? MainActivity)?.addOnSearchEventListener(OnSearchEventListener { isSearching ->
            val finalPaddingTop = if (isSearching) 100.dp(fragment.context) else 0
            ValueAnimator
                .ofInt(fragment.elementsView.paddingTop, finalPaddingTop)
                .addUpdateListener<Int> {
                    fragment.elementsView.updatePadding(top = it)
                }
                .doOnEnd {
                    if (isSearching && fragment.elementsView.computeVerticalScrollOffset() <= 3000)
                        fragment.elementsView.smoothScrollToPosition(0)
                }
                .start()
        })
    }

    fun configElementsSearch(fragment: ChemicalElementsFragment) {
        (fragment.activity as? MainActivity)?.run {
            addOnQueryChangeListener { query ->
                elementAdapter.value?.filter?.filter(query)
            }
            addOnSearchEventListener(OnSearchEventListener { isSearching ->
                if (!isSearching)
                    elementAdapter.value?.filter?.clear()
            })
        }
    }
}