package com.jeanbarrossilva.period.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.listener.OnSearchEventListener
import com.jeanbarrossilva.period.ui.view.SearchBox
import com.jeanbarrossilva.period.ui.viewmodel.MainViewModel

class MainActivity: AppCompatActivity(), OnSearchEventListener, SearchBox.OnQueryChangeListener {
	private val viewModel by viewModels<MainViewModel>()
	private var onSearchEventListeners = mutableListOf<OnSearchEventListener>()
	private var onQueryChangeListeners = mutableListOf<SearchBox.OnQueryChangeListener>()

	lateinit var toolbar: BottomAppBar
		private set
	lateinit var searchBox: SearchBox
		private set

	private fun assignViews() {
		toolbar = findViewById(R.id.toolbar)
		searchBox = findViewById(R.id.search_box)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		assignViews()
		viewModel.run {
			configOnBackPressed(this@MainActivity)
			configSearchItem(this@MainActivity)
			listenToSearchEvents(this@MainActivity)
			listenToQueryChange(this@MainActivity)
		}
	}

	override fun onOptionsItemSelected(item: MenuItem) = true.also {
		if (item.itemId == R.id.menu_item_search)
			viewModel.configSearchItem(this)
	}

	override fun onStartSearch() = onSearchEventListeners.forEach {
		it.onStartSearch()
	}

	override fun onExitSearch() = onSearchEventListeners.forEach {
		it.onExitSearch()
	}

	override fun onQueryChange(query: String) = onQueryChangeListeners.forEach {
		it.onQueryChange(query)
	}

	fun addOnSearchEventListener(listener: OnSearchEventListener) {
		onSearchEventListeners.add(listener)
	}

	fun addOnQueryChangeListener(listener: SearchBox.OnQueryChangeListener) {
		onQueryChangeListeners.add(listener)
	}
}