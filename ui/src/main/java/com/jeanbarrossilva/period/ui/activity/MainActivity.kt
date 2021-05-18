package com.jeanbarrossilva.period.ui.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.jeanbarrossilva.period.extensions.activity.toolbar
import com.jeanbarrossilva.period.ui.R
import com.jeanbarrossilva.period.ui.activity.core.SearchActivity

class MainActivity: SearchActivity() {
	private val Toolbar.searchItem
		get() = menu.findItem(R.id.menu_item_search)

	private fun configToolbar() {
		setSupportActionBar(toolbar)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		configToolbar()
	}

	override fun onPrimarySearchEventListening(isSearching: Boolean) {
		super.onPrimarySearchEventListening(isSearching)
		toolbar?.searchItem?.isVisible = !isSearching
	}
}