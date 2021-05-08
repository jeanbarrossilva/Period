package com.jeanbarrossilva.period.ui.viewmodel

import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.activity.MainActivity
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

class MainViewModel: ViewModel() {
    private val MainActivity.searchMenuItem
        get() = toolbar.menu.findItem(R.id.menu_item_search)
    private val MainActivity.exitSearchMenuItem
        get() = toolbar.menu.findItem(R.id.menu_item_exit_search)

    private var isSearching = false

    private fun configSearchMenuItems(activity: MainActivity) {
        activity.searchMenuItem.isVisible = !isSearching
        activity.exitSearchMenuItem.isVisible = isSearching
        activity.exitSearchMenuItem.setOnMenuItemClickListener {
            activity.onExitSearch()
            true
        }
    }

    private fun exitSearchOnKeyboardClosed(activity: MainActivity) = KeyboardVisibilityEvent.setEventListener(activity) { isOpen ->
        if (!isOpen)
            activity.onExitSearch()
    }

    fun configOnBackPressed(activity: MainActivity) {
        activity.onBackPressedDispatcher.addCallback(activity) {
            if (isSearching) activity.onExitSearch() else activity.finishAffinity()
        }
    }

    fun listenToSearchEvents(activity: MainActivity) {
        exitSearchOnKeyboardClosed(activity)
        activity.addOnSearchEventListener(OnSearchEventListener { isSearching ->
            this.isSearching = isSearching
            activity.searchBox.isVisible = isSearching
            configSearchMenuItems(activity)
        })
    }

    fun listenToQueryChange(activity: MainActivity) = activity.searchBox.addOnQueryChangeListener {
        activity.onQueryChange(it)
    }

    fun configSearchItem(activity: MainActivity) {
        activity.searchMenuItem.setOnMenuItemClickListener {
            activity.onStartSearch()
            true
        }
    }
}