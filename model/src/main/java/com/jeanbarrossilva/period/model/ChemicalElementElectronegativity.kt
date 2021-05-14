package com.jeanbarrossilva.period.model

data class ChemicalElementElectronegativity(val value: Float): Representable {
    override val representation = value.toString()
}