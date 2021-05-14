package com.jeanbarrossilva.period.model

import androidx.annotation.IntRange

sealed class ChemicalElementInteger(override val value: Int): ChemicalElementNumber(value) {
    data class AtomicNumber(override val value: Int): ChemicalElementInteger(value)

    data class Electrons(override val value: Int): ChemicalElementInteger(value)

    data class Group(@IntRange(from = 1, to = 18) override val value: Int): ChemicalElementInteger(value)

    data class Neutrons(override val value: Int): ChemicalElementInteger(value)

    data class Period(@IntRange(from = 1, to = 7) override val value: Int): ChemicalElementInteger(value)

    data class Protons(override val value: Int): ChemicalElementInteger(value)
}