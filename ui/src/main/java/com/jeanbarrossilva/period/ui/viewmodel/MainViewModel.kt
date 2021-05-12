package com.jeanbarrossilva.period.ui.viewmodel

import android.widget.EditText
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.jeanbarrossilva.period.extensions.activity.appcompatactivity.currentFragment
import com.jeanbarrossilva.period.extensions.view.edittext.toggleKeyboard
import com.jeanbarrossilva.period.extensions.view.viewgroup.searchFor
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.activity.MainActivity
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

class MainViewModel: ViewModel() {
    private val MainActivity.searchMenuItem
        get() = toolbar.menu.findItem(R.id.menu_item_search)
    private val MainActivity.exitSearchMenuItem
        get() = toolbar.menu.findItem(R.id.menu_item_exit_search)

    private var isListeningToKeyboardVisibility = false

    private fun configOnBackPressed(activity: MainActivity, isSearching: Boolean) {
        val shouldAddCallback = !activity.onBackPressedDispatcher.hasEnabledCallbacks()
        if (shouldAddCallback)
            activity.onBackPressedDispatcher.addCallback(activity) {
                if (isSearching) activity.onExitSearch() else activity.currentFragment?.findNavController()?.popBackStack()
            }
    }

    private fun configSearchMenuItems(activity: MainActivity, isSearching: Boolean) {
        activity.searchMenuItem.isVisible = !isSearching
        activity.exitSearchMenuItem.isVisible = isSearching
    }

    private fun exitSearchOnKeyboardClosed(activity: MainActivity) {
        KeyboardVisibilityEvent.registerEventListener(activity) { isOpen ->
            isListeningToKeyboardVisibility = true
            if (!isOpen)
                activity.onExitSearch()
        }.also {
            if (isListeningToKeyboardVisibility) {
                it.unregister()
                isListeningToKeyboardVisibility = false
            }
        }
    }

    fun listenToSearchEvents(activity: MainActivity) {
        activity.addOnSearchEventListener(OnSearchEventListener { isSearching ->
            activity.searchBox.isVisible = isSearching
            activity.searchBox.searchFor<EditText>()?.toggleKeyboard(shouldOpen = isSearching)
            configOnBackPressed(activity, isSearching)
            exitSearchOnKeyboardClosed(activity)
            configSearchMenuItems(activity, isSearching)
        })
    }

    fun listenToQueryChange(activity: MainActivity) = activity.searchBox.addOnQueryChangeListener {
        activity.onQueryChange(it)
    }

    fun configSearchItems(activity: MainActivity) {
        activity.searchMenuItem.setOnMenuItemClickListener {
            activity.onStartSearch()
            true
        }
        activity.exitSearchMenuItem.setOnMenuItemClickListener {
            activity.onExitSearch()
            true
        }
    }
}