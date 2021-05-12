package com.jeanbarrossilva.period.data

data class ChemicalElementElectronegativity(val value: Float): Representable {
    override val representation = value.toString()
}