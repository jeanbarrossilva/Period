package com.jeanbarrossilva.period.data

data class ChemicalElementSymbol(val value: String): Representable {
    override val representation = value
}