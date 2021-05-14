package com.jeanbarrossilva.period.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.activity.core.SearchActivity
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener
import com.jeanbarrossilva.period.ui.view.SearchBox

class MainActivity: SearchActivity(), OnSearchEventListener, SearchBox.OnQueryChangeListener {
	private lateinit var navController: NavController
	private lateinit var toolbar: BottomAppBar

	private val searchMenuItem: MenuItem by lazy {
		toolbar.menu.findItem(R.id.menu_item_search)
	}

	private fun assignViews() {
		navController = findNavController(R.id.container)
		toolbar = findViewById(R.id.toolbar)
	}

	private fun configToolbar() {
		navController.addOnDestinationChangedListener { _, destination, _ ->
			when (destination.id) {
				R.id.chemicalElementsFragment -> toolbar.inflateMenu(R.menu.menu_main_toolbar)
				R.id.chemicalElementDetailsFragment -> toolbar.menu?.clear()
			}
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		assignViews()
		configToolbar()
	}

	override fun onPrimarySearchEventListening(isSearching: Boolean) {
		super.onPrimarySearchEventListening(isSearching)
		searchMenuItem.isVisible = !isSearching
	}
}