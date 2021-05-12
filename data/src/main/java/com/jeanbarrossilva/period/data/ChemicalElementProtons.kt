package com.jeanbarrossilva.period.data

data class ChemicalElementProtons(val value: Int): Representable {
    override val representation = value.toString()
}