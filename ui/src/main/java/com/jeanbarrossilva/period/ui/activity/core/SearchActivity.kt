package com.jeanbarrossilva.period.ui.activity.core

import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import com.jeanbarrossilva.period.extensions.activity.view
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener
import com.jeanbarrossilva.period.ui.view.SearchBox
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

open class SearchActivity: PeriodActivity(), OnSearchEventListener, SearchBox.OnQueryChangeListener {
    private var onSearchEventListeners = mutableListOf<OnSearchEventListener>()
    private var onQueryChangeListeners = mutableListOf<SearchBox.OnQueryChangeListener>()
    private var shouldExitSearchOnBackPressed = false
    private var shouldExitSearchOnCloseKeyboard = false

    private lateinit var searchBox: SearchBox

    private fun checkIfParentViewIsAppropriate() {
        if (view !is CoordinatorLayout)
            error("The root View of a SearchActivity must be a CoordinatorLayout!")
    }

    private fun assignViews() {
        searchBox = SearchBox(this).apply {
            isVisible = false
            layoutParams = CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 20.dp(context)
                leftMargin = 20.dp(context)
                rightMargin = 20.dp(context)
            }
            addOnQueryChangeListener { query ->
                onQueryChange(query)
            }
        }
    }

    private fun exitSearchOnKeyboardClosed() {
        KeyboardVisibilityEvent.registerEventListener(this) { isOpen ->
            if (shouldExitSearchOnCloseKeyboard && !isOpen)
                onSearchEvent(isSearching = false)
        }
    }

    override fun onStart() {
        super.onStart()
        checkIfParentViewIsAppropriate()
        assignViews()
        onAddSearchBox()
        exitSearchOnKeyboardClosed()
        addOnSearchEventListener { isSearching ->
            onPrimarySearchEventListening(isSearching)
        }
    }

    override fun onBackPressed() {
        if (shouldExitSearchOnBackPressed) onSearchEvent(isSearching = false) else super.onBackPressed()
    }

    override fun onSearchEvent(isSearching: Boolean) {
        onSearchEventListeners.forEach { listener ->
            listener.onSearchEvent(isSearching)
        }
    }

    override fun onQueryChange(query: String) {
        Log.d(TAG, "onQueryChange: searching for \"$query\"...")
        onQueryChangeListeners.forEach { listener ->
            listener.onQueryChange(query)
        }
    }

    open fun onAddSearchBox() {
        (view as CoordinatorLayout).addView(searchBox)
    }

    open fun onPrimarySearchEventListening(isSearching: Boolean) {
        shouldExitSearchOnBackPressed = isSearching
        shouldExitSearchOnCloseKeyboard = isSearching
        searchBox.isVisible = isSearching
        Log.d(TAG, "isSearching: $isSearching")
    }

    fun addOnSearchEventListener(listener: OnSearchEventListener) {
        onSearchEventListeners.add(listener)
    }

    fun addOnQueryChangeListener(listener: SearchBox.OnQueryChangeListener) {
        onQueryChangeListeners.add(listener)
    }

    companion object {
        private const val TAG = "SearchActivity"
    }
}