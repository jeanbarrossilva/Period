package com.jeanbarrossilva.period.data

import android.graphics.Color
import androidx.annotation.ColorInt

sealed class ChemicalElementKind(val name: String, @ColorInt val color: Int): Representable {
    override val representation = name

    object Nonmetal: ChemicalElementKind("Nonmetal", Color.parseColor("#B4DC96"))

    object AlkaliMetal: ChemicalElementKind("Alkali metal", Color.parseColor("#149B5F"))

    object AlkalineEarthMetal: ChemicalElementKind("Alkaline Earth metal", Color.parseColor("#0F69AF"))

    object TransitionMetal: ChemicalElementKind("Transition metal", Color.parseColor("#503291"))

    object Lanthanide: ChemicalElementKind("Lanthanide", Color.parseColor("#D73C96"))

    object Actinide: ChemicalElementKind("Actinide", Color.parseColor("#F7A3BC"))

    object Metalloid: ChemicalElementKind("Metalloid", Color.parseColor("#2DBECD"))

    object PostTransitionMetal: ChemicalElementKind("Post-transition metal", Color.parseColor("#FFC832"))

    object Halogen: ChemicalElementKind("Halogen", Color.parseColor("#ED77B3"))

    object NobleGas: ChemicalElementKind("Noble gas", Color.parseColor("#E61E50"))
}