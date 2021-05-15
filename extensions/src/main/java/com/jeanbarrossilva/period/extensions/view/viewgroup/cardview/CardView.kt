package com.jeanbarrossilva.period.extensions.view.viewgroup.cardview

import androidx.annotation.Px
import androidx.cardview.widget.CardView

fun CardView.setContentPadding(@Px padding: Int) {
    setContentPadding(padding, padding, padding, padding)
}