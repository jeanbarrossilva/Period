package com.jeanbarrossilva.period.extensions.view.viewgroup.constraintlayout

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.children
import com.jeanbarrossilva.period.extensions.view.viewgroup.identifyUnidentifiedChildren

fun ConstraintLayout.constrain(target: View, constraint: ConstraintSet.(id: Int) -> Unit) {
    if (target in children) {
        identifyUnidentifiedChildren()
        ConstraintSet().apply {
            clone(this@constrain)
            constraint(target.id)
            applyTo(this@constrain)
        }
    }
}