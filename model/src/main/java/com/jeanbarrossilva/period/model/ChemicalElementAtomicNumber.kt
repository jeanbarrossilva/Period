package com.jeanbarrossilva.period.model

data class ChemicalElementAtomicNumber(val value: Int): Representable {
    override val representation = value.toString()
}