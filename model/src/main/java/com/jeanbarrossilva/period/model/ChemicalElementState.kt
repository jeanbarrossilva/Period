package com.jeanbarrossilva.period.model

sealed class ChemicalElementState(val name: String): ChemicalElementProperty<String>(name) {
    object Solid: ChemicalElementState("Solid")

    object Liquid: ChemicalElementState("Liquid")

    object Gas: ChemicalElementState("Gas")
}