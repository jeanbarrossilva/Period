package com.jeanbarrossilva.period.ui.activity.core

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.jeanbarrossilva.period.extensions.activity.navController

open class PeriodActivity: AppCompatActivity() {
    private fun showToolbarBackButtonOnNavigation() {
        navController?.addOnDestinationChangedListener { controller, destination, _ ->
            val canNavigateUp = destination.id != controller.graph.startDestination
            supportActionBar?.setDisplayHomeAsUpEnabled(canNavigateUp)
        }
    }

    override fun onStart() {
        super.onStart()
        showToolbarBackButtonOnNavigation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item).also {
            if (item.itemId == android.R.id.home)
                onBackPressed()
        }
    }
}