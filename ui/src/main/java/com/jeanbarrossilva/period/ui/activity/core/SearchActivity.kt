package com.jeanbarrossilva.period.ui.activity.core

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.jeanbarrossilva.period.extensions.activity.appcompatactivity.currentFragment
import com.jeanbarrossilva.period.extensions.activity.view
import com.jeanbarrossilva.period.extensions.number.dp
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener
import com.jeanbarrossilva.period.ui.view.SearchBox
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

open class SearchActivity: AppCompatActivity(), OnSearchEventListener, SearchBox.OnQueryChangeListener {
    private var onSearchEventListeners = mutableListOf<OnSearchEventListener>()
    private var onQueryChangeListeners = mutableListOf<SearchBox.OnQueryChangeListener>()
    private var isListeningToKeyboardVisibility = false

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
        }
    }

    private fun configOnBackPressed(isSearching: Boolean) {
        if (!onBackPressedDispatcher.hasEnabledCallbacks())
            onBackPressedDispatcher.addCallback(this) {
                if (isSearching) onExitSearch() else currentFragment?.findNavController()?.popBackStack()
            }
    }

    private fun exitSearchOnKeyboardClosed() {
        KeyboardVisibilityEvent.registerEventListener(this) { isOpen ->
            isListeningToKeyboardVisibility = true
            if (!isOpen)
                onExitSearch()
        }.also {
            if (isListeningToKeyboardVisibility) {
                it.unregister()
                isListeningToKeyboardVisibility = false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assignViews()
        addOnSearchEventListener(OnSearchEventListener { isSearching ->
            onPrimarySearchEventListening(isSearching)
        })
        addOnQueryChangeListener { query ->
            onQueryChange(query)
        }
    }

    override fun onStart() {
        super.onStart()
        checkIfParentViewIsAppropriate()
        onAddSearchBox()
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
        searchBox.isVisible = isSearching
        configOnBackPressed(isSearching)
        exitSearchOnKeyboardClosed()
    }

    fun addOnSearchEventListener(listener: OnSearchEventListener) {
        onSearchEventListeners.add(listener)
    }

    fun addOnQueryChangeListener(listener: SearchBox.OnQueryChangeListener) {
        onQueryChangeListeners.add(listener)
    }
}