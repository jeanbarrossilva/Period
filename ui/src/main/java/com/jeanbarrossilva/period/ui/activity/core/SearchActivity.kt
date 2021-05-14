package com.jeanbarrossilva.period.ui.activity.core

import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.jeanbarrossilva.period.extensions.activity.view
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener
import com.jeanbarrossilva.period.ui.view.SearchBox
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

open class SearchActivity: AppCompatActivity(), OnSearchEventListener, SearchBox.OnQueryChangeListener {
    private var onSearchEventListeners = mutableListOf<OnSearchEventListener>()
    private var onQueryChangeListeners = mutableListOf<SearchBox.OnQueryChangeListener>()
    private var shouldExitSearchOnBackPressed = false
    private var isListeningToKeyboardVisibility = false

    private lateinit var navController: NavController
    private lateinit var searchBox: SearchBox

    private fun checkIfParentViewIsAppropriate() {
        if (view !is CoordinatorLayout)
            error("The root View of a SearchActivity must be a CoordinatorLayout!")
    }

    private fun assignViews() {
        navController = findNavController(R.id.container)
        searchBox = SearchBox(this).apply {
            isVisible = false
            layoutParams = CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 20.dp(context)
                leftMargin = 20.dp(context)
                rightMargin = 20.dp(context)
            }
        }
    }

    private fun exitSearchOnKeyboardClosed() {
        KeyboardVisibilityEvent.registerEventListener(this) { isOpen ->
            isListeningToKeyboardVisibility = true
            if (!isOpen)
                onExitSearch()
        }.also { listener ->
            if (isListeningToKeyboardVisibility) {
                listener.unregister()
                isListeningToKeyboardVisibility = false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        checkIfParentViewIsAppropriate()
        assignViews()
        onAddSearchBox()
        addOnSearchEventListener(OnSearchEventListener { isSearching ->
            onPrimarySearchEventListening(isSearching)
        })
        addOnQueryChangeListener { query ->
            onQueryChange(query)
        }
    }

    override fun onBackPressed() {
        if (shouldExitSearchOnBackPressed) onExitSearch() else super.onBackPressed()
    }

    override fun onStartSearch() {
        onSearchEventListeners.forEach { listener ->
            listener.onStartSearch()
        }
    }

    override fun onExitSearch() {
        onSearchEventListeners.forEach { listener ->
            listener.onExitSearch()
        }
    }

    override fun onQueryChange(query: String) {
        onQueryChangeListeners.forEach { listener ->
            listener.onQueryChange(query)
        }
    }

    open fun onAddSearchBox() {
        (view as CoordinatorLayout).addView(searchBox)
    }

    open fun onPrimarySearchEventListening(isSearching: Boolean) {
        shouldExitSearchOnBackPressed = isSearching
        searchBox.isVisible = isSearching
        exitSearchOnKeyboardClosed()
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