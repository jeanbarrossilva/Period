package com.jeanbarrossilva.period.model

import androidx.annotation.IntRange
import com.jeanbarrossilva.period.model.ElectronicSubshell.*
import com.jeanbarrossilva.period.model.ElectronicSubshell.Companion.D_CAPACITY
import com.jeanbarrossilva.period.model.ElectronicSubshell.Companion.F_CAPACITY
import com.jeanbarrossilva.period.model.ElectronicSubshell.Companion.P_CAPACITY
import com.jeanbarrossilva.period.model.ElectronicSubshell.Companion.S_CAPACITY

sealed class ElectronDistribution(@IntRange(from = 1, to = 7) val shell: Int, val subshell: ElectronicSubshell):
    ChemicalElementProperty<String>("${shell}${subshell.name}") {
    class OneS(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronDistribution(1, S(electronCount))

    class TwoS(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronDistribution(2, S(electronCount))

    class TwoP(@IntRange(from = 1, to = P_CAPACITY) electronCount: Int):
        ElectronDistribution(2, P(electronCount))

    class ThreeS(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronDistribution(3, S(electronCount))

    class ThreeP(@IntRange(from = 1, to = P_CAPACITY) electronCount: Int):
        ElectronDistribution(3, P(electronCount))

    class ThreeD(@IntRange(from = 1, to = D_CAPACITY) electronCount: Int):
        ElectronDistribution(3, D(electronCount))

    class FourS(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronDistribution(4, S(electronCount))

    class FourP(@IntRange(from = 1, to = P_CAPACITY) electronCount: Int):
        ElectronDistribution(4, P(electronCount))

    class FourD(@IntRange(from = 1, to = D_CAPACITY) electronCount: Int):
        ElectronDistribution(4, D(electronCount))

    class FourF(@IntRange(from = 1, to = F_CAPACITY) electronCount: Int):
        ElectronDistribution(4, F(electronCount))

    class FiveS(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronDistribution(5, S(electronCount))

    class FiveP(@IntRange(from = 1, to = P_CAPACITY) electronCount: Int):
        ElectronDistribution(5, P(electronCount))

    class FiveD(@IntRange(from = 1, to = D_CAPACITY) electronCount: Int):
        ElectronDistribution(5, D(electronCount))

    class FiveF(@IntRange(from = 1, to = F_CAPACITY) electronCount: Int):
        ElectronDistribution(5, F(electronCount))

    class SixS(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronDistribution(6, S(electronCount))

    class SixP(@IntRange(from = 1, to = P_CAPACITY) electronCount: Int):
        ElectronDistribution(6, P(electronCount))

    class SixD(@IntRange(from = 1, to = D_CAPACITY) electronCount: Int):
        ElectronDistribution(6, D(electronCount))

    class SevenS(@IntRange(from = 1, to = S_CAPACITY) electronCount: Int):
        ElectronDistribution(7, S(electronCount))

    class SevenP(@IntRange(from = 1, to = P_CAPACITY) electronCount: Int):
        ElectronDistribution(7, P(electronCount))
}