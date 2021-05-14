package com.jeanbarrossilva.period.model

sealed class ChemicalElementState(val name: String): Representable {
    override val representation = name

    object Solid: ChemicalElementState("Solid")

    object Liquid: ChemicalElementState("Liquid")

    object Gas: ChemicalElementState("Gas")
}