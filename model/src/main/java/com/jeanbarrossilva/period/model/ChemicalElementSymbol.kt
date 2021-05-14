package com.jeanbarrossilva.period.model

data class ChemicalElementSymbol(val value: String): Representable {
    override val representation = value
}