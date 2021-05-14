package com.jeanbarrossilva.period.model

data class ChemicalElementNeutrons(val value: Int): Representable {
    override val representation = value.toString()
}