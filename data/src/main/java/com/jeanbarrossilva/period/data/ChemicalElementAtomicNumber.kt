package com.jeanbarrossilva.period.data

data class ChemicalElementAtomicNumber(val value: Int): Representable {
    override val representation = value.toString()
}