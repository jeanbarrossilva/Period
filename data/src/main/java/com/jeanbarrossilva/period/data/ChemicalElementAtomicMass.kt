package com.jeanbarrossilva.period.data

data class ChemicalElementAtomicMass(val value: Float): Representable {
    override val representation = "$value u"
}