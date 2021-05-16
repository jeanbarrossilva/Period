package com.jeanbarrossilva.period.ui.view

import android.content.Context
import android.util.AttributeSet

class CompactChemicalElementSymbolView: ChemicalElementSymbolView {
    constructor(context: Context): super(context) {
        config()
    }

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        config()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        config()
    }

    private fun config() {
        isCompact = true
    }
}