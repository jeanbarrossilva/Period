package com.jeanbarrossilva.period.data

data class ChemicalElementNeutrons(val value: Int): Representable {
    override val representation = value.toString()
}