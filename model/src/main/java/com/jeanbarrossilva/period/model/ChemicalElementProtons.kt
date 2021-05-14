package com.jeanbarrossilva.period.model

data class ChemicalElementProtons(val value: Int): Representable {
    override val representation = value.toString()
}