package com.jeanbarrossilva.period.extensions.fragment

import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.period.extensions.activity.view
import com.jeanbarrossilva.period.extensions.view.searchFor

fun Fragment.withFab(block: FloatingActionButton.() -> Unit) {
    activity?.view?.searchFor<FloatingActionButton>()?.block()
}