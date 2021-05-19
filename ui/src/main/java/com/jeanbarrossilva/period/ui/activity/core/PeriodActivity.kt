package com.jeanbarrossilva.period.ui.activity.core

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.jeanbarrossilva.period.extensions.activity.navController
import com.jeanbarrossilva.period.extensions.activity.toolbar
import com.jeanbarrossilva.period.ui.R

open class PeriodActivity: AppCompatActivity() {
    private fun stealToolbarItemClicks() {
        toolbar?.setOnMenuItemClickListener { item ->
            onOptionsItemSelected(item)
            true
        }
    }

    private fun showToolbarBackButtonOnNavigation() {
        navController?.addOnDestinationChangedListener { controller, destination, _ ->
            val canNavigateUp = destination.id != controller.graph.startDestination
            if (canNavigateUp) {
                toolbar?.setNavigationIcon(R.drawable.ic_round_arrow_back_ios_24)
                toolbar?.setNavigationOnClickListener {
                    onBackPressed()
                }
            } else {
                toolbar?.navigationIcon = null
                toolbar?.setNavigationOnClickListener {
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        stealToolbarItemClicks()
        showToolbarBackButtonOnNavigation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item).also {
            if (item.itemId == android.R.id.home)
                onBackPressed()
        }
    }
}