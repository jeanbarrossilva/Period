package com.jeanbarrossilva.period.data

data class ChemicalElementElectrons(val value: Int): Representable {
    override val representation = value.toString()
}