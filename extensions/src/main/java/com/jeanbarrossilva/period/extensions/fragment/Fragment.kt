package com.jeanbarrossilva.period.extensions.fragment

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.period.extensions.view
import com.jeanbarrossilva.period.extensions.viewgroup.searchFor

fun Fragment.withFab(block: FloatingActionButton.() -> Unit) {
    (activity?.view as? ViewGroup)?.searchFor<FloatingActionButton>()?.block()
}