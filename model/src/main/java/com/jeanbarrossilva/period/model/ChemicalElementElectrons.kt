package com.jeanbarrossilva.period.model

data class ChemicalElementElectrons(val value: Int): Representable {
    override val representation = value.toString()
}