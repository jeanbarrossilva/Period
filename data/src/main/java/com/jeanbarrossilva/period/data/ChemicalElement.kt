package com.jeanbarrossilva.period.data

import androidx.annotation.IntRange
import com.jeanbarrossilva.period.data.ChemicalElementKind.*
import com.jeanbarrossilva.period.data.ChemicalElementState.*
import com.jeanbarrossilva.period.data.ElectronDistribution.*
import com.jeanbarrossilva.period.extensions.kclass.values

@Suppress("Unused")
sealed class ChemicalElement(
    val name: ChemicalElementName,
    val symbol: ChemicalElementSymbol,
    val atomicNumber: ChemicalElementAtomicNumber,
    val atomicMass: ChemicalElementAtomicMass,
    val kind: ChemicalElementKind,
    val state: ChemicalElementState,
    val period: ChemicalElementPeriod?,
    val group: ChemicalElementGroup?,
    val electronConfiguration: ElectronConfiguration
) {
    val color = kind.color

    object Hydrogen:
        ChemicalElement(
            ChemicalElementName("Hydrogen"),
            ChemicalElementSymbol("H"),
            ChemicalElementAtomicNumber(1),
            ChemicalElementAtomicMass(1.008f),
            kind = Nonmetal,
            state = Gas,
            ChemicalElementPeriod(1),
            ChemicalElementGroup(1),
            ElectronConfiguration(OneS(1))
        )

    object Helium:
        ChemicalElement(
            ChemicalElementName("Helium"),
            ChemicalElementSymbol("He"),
            ChemicalElementAtomicNumber(2),
            ChemicalElementAtomicMass(4.002f),
            kind = NobleGas,
            state = Gas,
            ChemicalElementPeriod(1),
            ChemicalElementGroup(18),
            ElectronConfiguration(OneS(2))
        )

    object Lithium:
        ChemicalElement(
            ChemicalElementName("Lithium"),
            ChemicalElementSymbol("Li"),
            ChemicalElementAtomicNumber(3),
            ChemicalElementAtomicMass(6.941f),
            kind = AlkaliMetal,
            state = Solid,
            ChemicalElementPeriod(2),
            ChemicalElementGroup(1),
            ElectronConfiguration(TwoS(1))
        )

    object Beryllium:
        ChemicalElement(
            ChemicalElementName("Beryllium"),
            ChemicalElementSymbol("Be"),
            ChemicalElementAtomicNumber(4),
            ChemicalElementAtomicMass(9.012f),
            kind = AlkalineEarthMetal,
            state = Solid,
            ChemicalElementPeriod(2),
            ChemicalElementGroup(2),
            ElectronConfiguration(TwoS(2))
        )

    object Boron:
        ChemicalElement(
            ChemicalElementName("Boron"),
            ChemicalElementSymbol("B"),
            ChemicalElementAtomicNumber(5),
            ChemicalElementAtomicMass(10.811f),
            kind = Metalloid,
            state = Solid,
            ChemicalElementPeriod(2),
            ChemicalElementGroup(13),
            ElectronConfiguration(TwoS(2), TwoP(1))
        )

    object Carbon:
        ChemicalElement(
            ChemicalElementName("Carbon"),
            ChemicalElementSymbol("C"),
            ChemicalElementAtomicNumber(6),
            ChemicalElementAtomicMass(12.011f),
            kind = Nonmetal,
            state = Solid,
            ChemicalElementPeriod(2),
            ChemicalElementGroup(14),
            ElectronConfiguration(TwoS(2), TwoP(2))
        )

    object Nitrogen:
        ChemicalElement(
            ChemicalElementName("Nitrogen"),
            ChemicalElementSymbol("N"),
            ChemicalElementAtomicNumber(7),
            ChemicalElementAtomicMass(14.007f),
            kind = Nonmetal,
            state = Gas,
            ChemicalElementPeriod(2),
            ChemicalElementGroup(15),
            ElectronConfiguration(TwoS(2), TwoP(3))
        )

    object Oxygen:
        ChemicalElement(
            ChemicalElementName("Oxygen"),
            ChemicalElementSymbol("O"),
            ChemicalElementAtomicNumber(8),
            ChemicalElementAtomicMass(15.999f),
            kind = Nonmetal,
            state = Gas,
            ChemicalElementPeriod(2),
            ChemicalElementGroup(16),
            ElectronConfiguration(TwoS(2), TwoP(4))
        )

    object Fluorine:
        ChemicalElement(
            ChemicalElementName("Fluorine"),
            ChemicalElementSymbol("F"),
            ChemicalElementAtomicNumber(9),
            ChemicalElementAtomicMass(18.998f),
            kind = Halogen,
            state = Gas,
            ChemicalElementPeriod(2),
            ChemicalElementGroup(17),
            ElectronConfiguration(TwoS(2), TwoP(5))
        )

    object Neon:
        ChemicalElement(
            ChemicalElementName("Neon"),
            ChemicalElementSymbol("Ne"),
            ChemicalElementAtomicNumber(10),
            ChemicalElementAtomicMass(20.18f),
            kind = NobleGas,
            state = Gas,
            ChemicalElementPeriod(2),
            ChemicalElementGroup(18),
            ElectronConfiguration(TwoS(2), TwoP(6))
        )

    object Sodium:
        ChemicalElement(
            ChemicalElementName("Sodium"),
            ChemicalElementSymbol("Na"),
            ChemicalElementAtomicNumber(11),
            ChemicalElementAtomicMass(22.99f),
            kind = AlkaliMetal,
            state = Solid,
            ChemicalElementPeriod(3),
            ChemicalElementGroup(1),
            ElectronConfiguration(ThreeS(1))
        )

    object Magnesium:
        ChemicalElement(
            ChemicalElementName("Magnesium"),
            ChemicalElementSymbol("Mg"),
            ChemicalElementAtomicNumber(12),
            ChemicalElementAtomicMass(24.305f),
            kind = AlkalineEarthMetal,
            state = Solid,
            ChemicalElementPeriod(3),
            ChemicalElementGroup(2),
            ElectronConfiguration(ThreeS(2))
        )

    object Aluminum:
        ChemicalElement(
            ChemicalElementName("Aluminum"),
            ChemicalElementSymbol("Al"),
            ChemicalElementAtomicNumber(13),
            ChemicalElementAtomicMass(26.982f),
            kind = PostTransitionMetal,
            state = Solid,
            ChemicalElementPeriod(3),
            ChemicalElementGroup(13),
            ElectronConfiguration(ThreeS(2), ThreeP(1))
        )

    object Silicon:
        ChemicalElement(
            ChemicalElementName("Silicon"),
            ChemicalElementSymbol("Si"),
            ChemicalElementAtomicNumber(14),
            ChemicalElementAtomicMass(28.086f),
            kind = Metalloid,
            state = Solid,
            ChemicalElementPeriod(3),
            ChemicalElementGroup(14),
            ElectronConfiguration(ThreeS(2), ThreeP(2))
        )

    object Phosphorus:
        ChemicalElement(
            ChemicalElementName("Phosphorus"),
            ChemicalElementSymbol("P"),
            ChemicalElementAtomicNumber(15),
            ChemicalElementAtomicMass(30.974f),
            kind = Nonmetal,
            state = Solid,
            ChemicalElementPeriod(3),
            ChemicalElementGroup(15),
            ElectronConfiguration(ThreeS(2), ThreeP(3))
        )

    object Sulfur:
        ChemicalElement(
            ChemicalElementName("Sulfur"),
            ChemicalElementSymbol("S"),
            ChemicalElementAtomicNumber(16),
            ChemicalElementAtomicMass(32.065f),
            kind = Nonmetal,
            state = Solid,
            ChemicalElementPeriod(3),
            ChemicalElementGroup(16),
            ElectronConfiguration(ThreeS(2), ThreeP(4))
        )

    object Chlorine:
        ChemicalElement(
            ChemicalElementName("Chlorine"),
            ChemicalElementSymbol("Cl"),
            ChemicalElementAtomicNumber(17),
            ChemicalElementAtomicMass(35.453f),
            kind = Halogen,
            state = Gas,
            ChemicalElementPeriod(1),
            ChemicalElementGroup(17),
            ElectronConfiguration(ThreeS(2), ThreeP(5))
        )

    object Argon:
        ChemicalElement(
            ChemicalElementName("Argon"),
            ChemicalElementSymbol("Ar"),
            ChemicalElementAtomicNumber(18),
            ChemicalElementAtomicMass(39.948f),
            kind = NobleGas,
            state = Gas,
            ChemicalElementPeriod(3),
            ChemicalElementGroup(18),
            ElectronConfiguration(ThreeS(2), ThreeP(6))
        )

    object Potassium:
        ChemicalElement(
            ChemicalElementName("Potassium"),
            ChemicalElementSymbol("K"),
            ChemicalElementAtomicNumber(19),
            ChemicalElementAtomicMass(39.098f),
            kind = AlkaliMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(1),
            ElectronConfiguration(FourS(1))
        )

    object Calcium:
        ChemicalElement(
            ChemicalElementName("Calcium"),
            ChemicalElementSymbol("Ca"),
            ChemicalElementAtomicNumber(20),
            ChemicalElementAtomicMass(40.078f),
            kind = AlkalineEarthMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(2),
            ElectronConfiguration(FourS(2))
        )

    object Scandium:
        ChemicalElement(
            ChemicalElementName("Scandium"),
            ChemicalElementSymbol("Sc"),
            ChemicalElementAtomicNumber(21),
            ChemicalElementAtomicMass(44.956f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(3),
            ElectronConfiguration(ThreeD(1), FourS(2))
        )

    object Titanium:
        ChemicalElement(
            ChemicalElementName("Titanium"),
            ChemicalElementSymbol("Ti"),
            ChemicalElementAtomicNumber(22),
            ChemicalElementAtomicMass(47.867f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(4),
            ElectronConfiguration(ThreeD(2), FourS(2))
        )

    object Vanadium:
        ChemicalElement(
            ChemicalElementName("Vanadium"),
            ChemicalElementSymbol("V"),
            ChemicalElementAtomicNumber(23),
            ChemicalElementAtomicMass(50.942f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(5),
            ElectronConfiguration(ThreeD(3), FourS(2))
        )

    object Chromium:
        ChemicalElement(
            ChemicalElementName("Chromium"),
            ChemicalElementSymbol("Cr"),
            ChemicalElementAtomicNumber(24),
            ChemicalElementAtomicMass(51.996f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(6),
            ElectronConfiguration(ThreeD(5), FourS(1))
        )

    object Manganese:
        ChemicalElement(
            ChemicalElementName("Manganese"),
            ChemicalElementSymbol("Mn"),
            ChemicalElementAtomicNumber(25),
            ChemicalElementAtomicMass(54.938f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(7),
            ElectronConfiguration(ThreeD(5), FourS(2))
        )

    object Iron:
        ChemicalElement(
            ChemicalElementName("Iron"),
            ChemicalElementSymbol("Fe"),
            ChemicalElementAtomicNumber(26),
            ChemicalElementAtomicMass(55.845f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(8),
            ElectronConfiguration(ThreeD(6), FourS(2))
        )

    object Cobalt:
        ChemicalElement(
            ChemicalElementName("Cobalt"),
            ChemicalElementSymbol("Co"),
            ChemicalElementAtomicNumber(27),
            ChemicalElementAtomicMass(58.933f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(9),
            ElectronConfiguration(ThreeD(7), FourS(2))
        )

    object Nickel:
        ChemicalElement(
            ChemicalElementName("Nickel"),
            ChemicalElementSymbol("Ni"),
            ChemicalElementAtomicNumber(28),
            ChemicalElementAtomicMass(58.693f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(10),
            ElectronConfiguration(ThreeD(8), FourS(2))
        )

    object Copper:
        ChemicalElement(
            ChemicalElementName("Copper"),
            ChemicalElementSymbol("Cu"),
            ChemicalElementAtomicNumber(29),
            ChemicalElementAtomicMass(63.546f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(11),
            ElectronConfiguration(ThreeD(10), FourS(1))
        )

    object Zinc:
        ChemicalElement(
            ChemicalElementName("Zinc"),
            ChemicalElementSymbol("Zn"),
            ChemicalElementAtomicNumber(30),
            ChemicalElementAtomicMass(65.38f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(12),
            ElectronConfiguration(ThreeD(10), FourS(2))
        )

    object Gallium:
        ChemicalElement(
            ChemicalElementName("Gallium"),
            ChemicalElementSymbol("Ga"),
            ChemicalElementAtomicNumber(31),
            ChemicalElementAtomicMass(69.723f),
            kind = PostTransitionMetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(13),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(1))
        )

    object Germanium:
        ChemicalElement(
            ChemicalElementName("Germanium"),
            ChemicalElementSymbol("Ge"),
            ChemicalElementAtomicNumber(32),
            ChemicalElementAtomicMass(72.64f),
            kind = Metalloid,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(14),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(2))
        )

    object Arsenic:
        ChemicalElement(
            ChemicalElementName("Arsenic"),
            ChemicalElementSymbol("As"),
            ChemicalElementAtomicNumber(33),
            ChemicalElementAtomicMass(74.922f),
            kind = Metalloid,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(15),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(3))
        )

    object Selenium:
        ChemicalElement(
            ChemicalElementName("Selenium"),
            ChemicalElementSymbol("Se"),
            ChemicalElementAtomicNumber(34),
            ChemicalElementAtomicMass(78.96f),
            kind = Nonmetal,
            state = Solid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(16),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(4))
        )

    object Bromine:
        ChemicalElement(
            ChemicalElementName("Bromine"),
            ChemicalElementSymbol("Br"),
            ChemicalElementAtomicNumber(35),
            ChemicalElementAtomicMass(79.904f),
            kind = Halogen,
            state = Liquid,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(17),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(5))
        )

    object Krypton:
        ChemicalElement(
            ChemicalElementName("Krypton"),
            ChemicalElementSymbol("Kr"),
            ChemicalElementAtomicNumber(36),
            ChemicalElementAtomicMass(83.798f),
            kind = NobleGas,
            state = Gas,
            ChemicalElementPeriod(4),
            ChemicalElementGroup(18),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(6))
        )

    object Rubidium:
        ChemicalElement(
            ChemicalElementName("Rubidium"),
            ChemicalElementSymbol("Rb"),
            ChemicalElementAtomicNumber(37),
            ChemicalElementAtomicMass(85.468f),
            kind = AlkaliMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(1),
            ElectronConfiguration(FiveS(1))
        )

    object Strontium:
        ChemicalElement(
            ChemicalElementName("Strontium"),
            ChemicalElementSymbol("Sr"),
            ChemicalElementAtomicNumber(38),
            ChemicalElementAtomicMass(87.62f),
            kind = AlkalineEarthMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(2),
            ElectronConfiguration(FiveS(2))
        )

    object Yttrium:
        ChemicalElement(
            ChemicalElementName("Yttrium"),
            ChemicalElementSymbol("Y"),
            ChemicalElementAtomicNumber(39),
            ChemicalElementAtomicMass(88.906f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(3),
            ElectronConfiguration(FourD(1), FiveS(2))
        )

    object Zirconium:
        ChemicalElement(
            ChemicalElementName("Zirconium"),
            ChemicalElementSymbol("Zr"),
            ChemicalElementAtomicNumber(40),
            ChemicalElementAtomicMass(91.224f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(4),
            ElectronConfiguration(FourD(2), FiveS(2))
        )

    object Niobium:
        ChemicalElement(
            ChemicalElementName("Niobium"),
            ChemicalElementSymbol("Nb"),
            ChemicalElementAtomicNumber(41),
            ChemicalElementAtomicMass(98.906f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(5),
            ElectronConfiguration(FourD(4), FiveS(1))
        )

    object Molybdenum:
        ChemicalElement(
            ChemicalElementName("Molybdenum"),
            ChemicalElementSymbol("Mo"),
            ChemicalElementAtomicNumber(42),
            ChemicalElementAtomicMass(95.96f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(6),
            ElectronConfiguration(FourD(5), FiveS(1))
        )

    object Technetium:
        ChemicalElement(
            ChemicalElementName("Technetium"),
            ChemicalElementSymbol("Tc"),
            ChemicalElementAtomicNumber(43),
            ChemicalElementAtomicMass(98f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(7),
            ElectronConfiguration(FourD(5), FiveS(2))
        )

    object Ruthenium:
        ChemicalElement(
            ChemicalElementName("Ruthenium"),
            ChemicalElementSymbol("Ru"),
            ChemicalElementAtomicNumber(44),
            ChemicalElementAtomicMass(101.107f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(8),
            ElectronConfiguration(FourD(7), FiveS(1))
        )

    object Rhodium:
        ChemicalElement(
            ChemicalElementName("Rhodium"),
            ChemicalElementSymbol("Rh"),
            ChemicalElementAtomicNumber(45),
            ChemicalElementAtomicMass(102.906f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(9),
            ElectronConfiguration(FourD(8), FiveS(1))
        )

    object Palladium:
        ChemicalElement(
            ChemicalElementName("Palladium"),
            ChemicalElementSymbol("Pd"),
            ChemicalElementAtomicNumber(46),
            ChemicalElementAtomicMass(106.42f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(10),
            ElectronConfiguration(FourD(10))
        )

    object Silver:
        ChemicalElement(
            ChemicalElementName("Silver"),
            ChemicalElementSymbol("Ag"),
            ChemicalElementAtomicNumber(47),
            ChemicalElementAtomicMass(07.869f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(11),
            ElectronConfiguration(FourD(10), FiveS(1))
        )

    object Cadmium:
        ChemicalElement(
            ChemicalElementName("Cadmium"),
            ChemicalElementSymbol("Cd"),
            ChemicalElementAtomicNumber(48),
            ChemicalElementAtomicMass(112.411f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(12),
            ElectronConfiguration(FourD(10), FiveS(2))
        )

    object Indium:
        ChemicalElement(
            ChemicalElementName("Indium"),
            ChemicalElementSymbol("In"),
            ChemicalElementAtomicNumber(49),
            ChemicalElementAtomicMass(114.818f),
            kind = PostTransitionMetal,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(13),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(1))
        )

    object Tin:
        ChemicalElement(
            ChemicalElementName("Tin"),
            ChemicalElementSymbol("Sn"),
            ChemicalElementAtomicNumber(50),
            ChemicalElementAtomicMass(118.71f),
            kind = PostTransitionMetal,
            state = Solid,
            ChemicalElementPeriod(1),
            ChemicalElementGroup(14),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(2))
        )

    object Antimony:
        ChemicalElement(
            ChemicalElementName("Antimony"),
            ChemicalElementSymbol("Sb"),
            ChemicalElementAtomicNumber(51),
            ChemicalElementAtomicMass(121.76f),
            kind = Metalloid,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(15),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(3))
        )

    object Tellurium:
        ChemicalElement(
            ChemicalElementName("Tellurium"),
            ChemicalElementSymbol("Te"),
            ChemicalElementAtomicNumber(52),
            ChemicalElementAtomicMass(127.6f),
            kind = Metalloid,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(16),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(4))
        )

    object Iodine:
        ChemicalElement(
            ChemicalElementName("Iodine"),
            ChemicalElementSymbol("I"),
            ChemicalElementAtomicNumber(53),
            ChemicalElementAtomicMass(126.904f),
            kind = Halogen,
            state = Solid,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(17),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(5))
        )

    object Xenon:
        ChemicalElement(
            ChemicalElementName("Xenon"),
            ChemicalElementSymbol("Xe"),
            ChemicalElementAtomicNumber(54),
            ChemicalElementAtomicMass(131.293f),
            kind = NobleGas,
            state = Gas,
            ChemicalElementPeriod(5),
            ChemicalElementGroup(18),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(6))
        )

    object Caesium:
        ChemicalElement(
            ChemicalElementName("Caesium"),
            ChemicalElementSymbol("Cs"),
            ChemicalElementAtomicNumber(55),
            ChemicalElementAtomicMass(132.905f),
            kind = AlkaliMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(1),
            ElectronConfiguration(SixS(1))
        )

    object Barium:
        ChemicalElement(
            ChemicalElementName("Barium"),
            ChemicalElementSymbol("Ba"),
            ChemicalElementAtomicNumber(56),
            ChemicalElementAtomicMass(137.327f),
            kind = AlkalineEarthMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(2),
            ElectronConfiguration(SixS(2))
        )

    object Lanthanum:
        ChemicalElement(
            ChemicalElementName("Lanthanum"),
            ChemicalElementSymbol("La"),
            ChemicalElementAtomicNumber(57),
            ChemicalElementAtomicMass(138.905f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveD(1), SixS(2))
        )

    object Cerium:
        ChemicalElement(
            ChemicalElementName("Cerium"),
            ChemicalElementSymbol("Ce"),
            ChemicalElementAtomicNumber(58),
            ChemicalElementAtomicMass(140.116f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(1), FiveD(1), SixS(2))
        )

    object Praseodymium:
        ChemicalElement(
            ChemicalElementName("Praseodymium"),
            ChemicalElementSymbol("Pr"),
            ChemicalElementAtomicNumber(59),
            ChemicalElementAtomicMass(140.908f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(3), SixS(2))
        )

    object Neodymium:
        ChemicalElement(
            ChemicalElementName("Neodymium"),
            ChemicalElementSymbol("Nd"),
            ChemicalElementAtomicNumber(60),
            ChemicalElementAtomicMass(144.242f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(4), SixS(2))
        )

    object Promethium:
        ChemicalElement(
            ChemicalElementName("Promethium"),
            ChemicalElementSymbol("Pm"),
            ChemicalElementAtomicNumber(61),
            ChemicalElementAtomicMass(145f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(5), SixS(2))
        )

    object Samarium:
        ChemicalElement(
            ChemicalElementName("Samarium"),
            ChemicalElementSymbol("Sm"),
            ChemicalElementAtomicNumber(62),
            ChemicalElementAtomicMass(150.36f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(6), SixS(2))
        )

    object Europium:
        ChemicalElement(
            ChemicalElementName("Europium"),
            ChemicalElementSymbol("Eu"),
            ChemicalElementAtomicNumber(63),
            ChemicalElementAtomicMass(151.964f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(7), SixS(2))
        )

    object Gadolinium:
        ChemicalElement(
            ChemicalElementName("Gadolinium"),
            ChemicalElementSymbol("Gd"),
            ChemicalElementAtomicNumber(64),
            ChemicalElementAtomicMass(157.25f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(7), FiveD(1), SixS(2))
        )

    object Terbium:
        ChemicalElement(
            ChemicalElementName("Terbium"),
            ChemicalElementSymbol("Tb"),
            ChemicalElementAtomicNumber(65),
            ChemicalElementAtomicMass(158.925f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(9), SixS(2))
        )

    object Dysprosium:
        ChemicalElement(
            ChemicalElementName("Dysprosium"),
            ChemicalElementSymbol("Dy"),
            ChemicalElementAtomicNumber(66),
            ChemicalElementAtomicMass(162.5f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(10), SixS(2))
        )

    object Holmium:
        ChemicalElement(
            ChemicalElementName("Holmium"),
            ChemicalElementSymbol("Ho"),
            ChemicalElementAtomicNumber(67),
            ChemicalElementAtomicMass(164.93f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(11), SixS(2))
        )

    object Erbium:
        ChemicalElement(
            ChemicalElementName("Erbium"),
            ChemicalElementSymbol("Er"),
            ChemicalElementAtomicNumber(68),
            ChemicalElementAtomicMass(167.259f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(12), SixS(2))
        )

    object Thulium:
        ChemicalElement(
            ChemicalElementName("Thulium"),
            ChemicalElementSymbol("Tm"),
            ChemicalElementAtomicNumber(69),
            ChemicalElementAtomicMass(168.934f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(13), SixS(2))
        )

    object Ytterbium:
        ChemicalElement(
            ChemicalElementName("Ytterbium"),
            ChemicalElementSymbol("Yb"),
            ChemicalElementAtomicNumber(70),
            ChemicalElementAtomicMass(173.054f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FourF(14), SixS(2))
        )

    object Lutetium:
        ChemicalElement(
            ChemicalElementName("Lutetium"),
            ChemicalElementSymbol("Lu"),
            ChemicalElementAtomicNumber(71),
            ChemicalElementAtomicMass(174.967f),
            kind = Lanthanide,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(18),
            ElectronConfiguration(FourF(14), FiveD(1), SixS(2))
        )

    object Hafnium:
        ChemicalElement(
            ChemicalElementName("Hafnium"),
            ChemicalElementSymbol("Hf"),
            ChemicalElementAtomicNumber(72),
            ChemicalElementAtomicMass(178.49f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(4),
            ElectronConfiguration(FourF(14), FiveD(2), SixS(2))
        )

    object Tantalum:
        ChemicalElement(
            ChemicalElementName("Tantalum"),
            ChemicalElementSymbol("Ta"),
            ChemicalElementAtomicNumber(73),
            ChemicalElementAtomicMass(180.948f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(5),
            ElectronConfiguration(FourF(14), FiveD(3), SixS(2))
        )

    object Tungsten:
        ChemicalElement(
            ChemicalElementName("Tungsten"),
            ChemicalElementSymbol("W"),
            ChemicalElementAtomicNumber(74),
            ChemicalElementAtomicMass(183.84f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(6),
            ElectronConfiguration(FourF(14), FiveD(4), SixS(2))
        )

    object Rhenium:
        ChemicalElement(
            ChemicalElementName("Rhenium"),
            ChemicalElementSymbol("Re"),
            ChemicalElementAtomicNumber(75),
            ChemicalElementAtomicMass(186.207f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(7),
            ElectronConfiguration(FourF(14), FiveD(5), SixS(2))
        )

    object Osmium:
        ChemicalElement(
            ChemicalElementName("Osmium"),
            ChemicalElementSymbol("Os"),
            ChemicalElementAtomicNumber(76),
            ChemicalElementAtomicMass(190.23f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(8),
            ElectronConfiguration(FourF(14), FiveD(6), SixS(2))
        )

    object Iridium:
        ChemicalElement(
            ChemicalElementName("Iridium"),
            ChemicalElementSymbol("Ir"),
            ChemicalElementAtomicNumber(77),
            ChemicalElementAtomicMass(192.217f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(9),
            ElectronConfiguration(FourF(14), FiveD(7), SixS(2))
        )

    object Platinum:
        ChemicalElement(
            ChemicalElementName("Platinum"),
            ChemicalElementSymbol("Pt"),
            ChemicalElementAtomicNumber(78),
            ChemicalElementAtomicMass(195.084f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(10),
            ElectronConfiguration(FourF(14), FiveD(9), SixS(1))
        )

    object Gold:
        ChemicalElement(
            ChemicalElementName("Gold"),
            ChemicalElementSymbol("Au"),
            ChemicalElementAtomicNumber(79),
            ChemicalElementAtomicMass(196.967f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(11),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(1))
        )

    object Mercury:
        ChemicalElement(
            ChemicalElementName("Mercury"),
            ChemicalElementSymbol("Hg"),
            ChemicalElementAtomicNumber(80),
            ChemicalElementAtomicMass(200.59f),
            kind = TransitionMetal,
            state = Liquid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(12),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2))
        )

    object Thallium:
        ChemicalElement(
            ChemicalElementName("Thallium"),
            ChemicalElementSymbol("Tl"),
            ChemicalElementAtomicNumber(81),
            ChemicalElementAtomicMass(204.383f),
            kind = Actinide,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(13),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(1))
        )

    object Lead:
        ChemicalElement(
            ChemicalElementName("Lead"),
            ChemicalElementSymbol("Pb"),
            ChemicalElementAtomicNumber(82),
            ChemicalElementAtomicMass(207.2f),
            kind = Actinide,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(14),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(2))
        )

    object Bismuth:
        ChemicalElement(
            ChemicalElementName("Bismuth"),
            ChemicalElementSymbol("Bi"),
            ChemicalElementAtomicNumber(83),
            ChemicalElementAtomicMass(208.98f),
            kind = Actinide,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(15),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(3))
        )

    object Polonium:
        ChemicalElement(
            ChemicalElementName("Polonium"),
            ChemicalElementSymbol("Po"),
            ChemicalElementAtomicNumber(84),
            ChemicalElementAtomicMass(210f),
            kind = Actinide,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(16),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(4))
        )

    object Astatine:
        ChemicalElement(
            ChemicalElementName("Astatine"),
            ChemicalElementSymbol("At"),
            ChemicalElementAtomicNumber(85),
            ChemicalElementAtomicMass(210f),
            kind = Halogen,
            state = Solid,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(17),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(5))
        )

    object Radon:
        ChemicalElement(
            ChemicalElementName("Radon"),
            ChemicalElementSymbol("Rn"),
            ChemicalElementAtomicNumber(86),
            ChemicalElementAtomicMass(222f),
            kind = NobleGas,
            state = Gas,
            ChemicalElementPeriod(6),
            ChemicalElementGroup(18),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(6))
        )

    object Francium:
        ChemicalElement(
            ChemicalElementName("Francium"),
            ChemicalElementSymbol("Fr"),
            ChemicalElementAtomicNumber(87),
            ChemicalElementAtomicMass(223f),
            kind = AlkaliMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(1),
            ElectronConfiguration(SevenS(1))
        )

    object Radium:
        ChemicalElement(
            ChemicalElementName("Radium"),
            ChemicalElementSymbol("Ra"),
            ChemicalElementAtomicNumber(88),
            ChemicalElementAtomicMass(226f),
            kind = AlkalineEarthMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(2),
            ElectronConfiguration(SevenS(2))
        )

    object Actinium:
        ChemicalElement(
            ChemicalElementName("Actinium"),
            ChemicalElementSymbol("Ac"),
            ChemicalElementAtomicNumber(89),
            ChemicalElementAtomicMass(227f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(SixD(1), SevenS(2))
        )

    object Thorium:
        ChemicalElement(
            ChemicalElementName("Thorium"),
            ChemicalElementSymbol("Th"),
            ChemicalElementAtomicNumber(90),
            ChemicalElementAtomicMass(232.038f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(SixD(2), SevenS(2))
        )

    object Protactinium:
        ChemicalElement(
            ChemicalElementName("Protactinium"),
            ChemicalElementSymbol("Pa"),
            ChemicalElementAtomicNumber(91),
            ChemicalElementAtomicMass(231.036f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(2), SixD(1), SevenS(2))
        )

    object Uranium:
        ChemicalElement(
            ChemicalElementName("Uranium"),
            ChemicalElementSymbol("U"),
            ChemicalElementAtomicNumber(92),
            ChemicalElementAtomicMass(238.029f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(3), SixD(1), SevenS(2))
        )

    object Neptunium:
        ChemicalElement(
            ChemicalElementName("Neptunium"),
            ChemicalElementSymbol("Np"),
            ChemicalElementAtomicNumber(93),
            ChemicalElementAtomicMass(237f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(4), SixD(1), SevenS(2))
        )

    object Plutonium:
        ChemicalElement(
            ChemicalElementName("Plutonium"),
            ChemicalElementSymbol("Pu"),
            ChemicalElementAtomicNumber(94),
            ChemicalElementAtomicMass(244f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(6), SevenS(2))
        )

    object Americium:
        ChemicalElement(
            ChemicalElementName("Americium"),
            ChemicalElementSymbol("Am"),
            ChemicalElementAtomicNumber(95),
            ChemicalElementAtomicMass(243f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(7), SevenS(2))
        )

    object Curium:
        ChemicalElement(
            ChemicalElementName("Curium"),
            ChemicalElementSymbol("Cm"),
            ChemicalElementAtomicNumber(96),
            ChemicalElementAtomicMass(247f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(7), SixD(1), SevenS(2))
        )

    object Berkelium:
        ChemicalElement(
            ChemicalElementName("Berkelium"),
            ChemicalElementSymbol("Bk"),
            ChemicalElementAtomicNumber(97),
            ChemicalElementAtomicMass(247f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(9), SevenS(2))
        )

    object Californium:
        ChemicalElement(
            ChemicalElementName("Californium"),
            ChemicalElementSymbol("Cf"),
            ChemicalElementAtomicNumber(98),
            ChemicalElementAtomicMass(251f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(10), SevenS(2))
        )

    object Einsteinium:
        ChemicalElement(
            ChemicalElementName("Einsteinium"),
            ChemicalElementSymbol("Es"),
            ChemicalElementAtomicNumber(99),
            ChemicalElementAtomicMass(252f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(11), SevenS(2))
        )

    object Fermium:
        ChemicalElement(
            ChemicalElementName("Fermium"),
            ChemicalElementSymbol("Fm"),
            ChemicalElementAtomicNumber(100),
            ChemicalElementAtomicMass(257f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(12), SevenS(2))
        )

    object Mendelevium:
        ChemicalElement(
            ChemicalElementName("Mendelevium"),
            ChemicalElementSymbol("Md"),
            ChemicalElementAtomicNumber(101),
            ChemicalElementAtomicMass(258f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(13), SevenS(2))
        )

    object Nobelium:
        ChemicalElement(
            ChemicalElementName("Nobelium"),
            ChemicalElementSymbol("No"),
            ChemicalElementAtomicNumber(102),
            ChemicalElementAtomicMass(259f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            ElectronConfiguration(FiveF(14), SevenS(2))
        )

    object Lawrencium:
        ChemicalElement(
            ChemicalElementName("Lawrencium"),
            ChemicalElementSymbol("Lr"),
            ChemicalElementAtomicNumber(103),
            ChemicalElementAtomicMass(262f),
            kind = Actinide,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(18),
            ElectronConfiguration(FiveF(14), SevenS(2), SevenP(1))
        )

    object Rutherfordium:
        ChemicalElement(
            ChemicalElementName("Rutherfordium"),
            ChemicalElementSymbol("Rf"),
            ChemicalElementAtomicNumber(104),
            ChemicalElementAtomicMass(261f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(4),
            ElectronConfiguration(FiveF(14), SixD(2), SevenS(2))
        )

    object Dubnium:
        ChemicalElement(
            ChemicalElementName("Dubnium"),
            ChemicalElementSymbol("Db"),
            ChemicalElementAtomicNumber(105),
            ChemicalElementAtomicMass(262f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(5),
            ElectronConfiguration(FiveF(14), SixD(3), SevenS(2))
        )

    object Seaborgium:
        ChemicalElement(
            ChemicalElementName("Seaborgium"),
            ChemicalElementSymbol("Sg"),
            ChemicalElementAtomicNumber(106),
            ChemicalElementAtomicMass(266f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(6),
            ElectronConfiguration(FiveF(14), SixD(4), SevenS(2))
        )

    object Bohrium:
        ChemicalElement(
            ChemicalElementName("Bohrium"),
            ChemicalElementSymbol("Bh"),
            ChemicalElementAtomicNumber(107),
            ChemicalElementAtomicMass(264f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(7),
            ElectronConfiguration(FiveF(14), SixD(5), SevenS(2))
        )

    object Hassium:
        ChemicalElement(
            ChemicalElementName("Hassium"),
            ChemicalElementSymbol("Hs"),
            ChemicalElementAtomicNumber(108),
            ChemicalElementAtomicMass(267f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(8),
            ElectronConfiguration(FiveF(14), SixD(6), SevenS(2))
        )

    object Meitnerium:
        ChemicalElement(
            ChemicalElementName("Meitnerium"),
            ChemicalElementSymbol("Mt"),
            ChemicalElementAtomicNumber(109),
            ChemicalElementAtomicMass(268f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(9),
            ElectronConfiguration(FiveF(14), SixD(7), SevenS(2))
        )

    object Darmstadtium:
        ChemicalElement(
            ChemicalElementName("Darmstadtium"),
            ChemicalElementSymbol("Ds"),
            ChemicalElementAtomicNumber(110),
            ChemicalElementAtomicMass(271f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(10),
            ElectronConfiguration(FiveF(14), SixD(9), SevenS(1))
        )

    object Roentgenium:
        ChemicalElement(
            ChemicalElementName("Roentgenium"),
            ChemicalElementSymbol("Rg"),
            ChemicalElementAtomicNumber(111),
            ChemicalElementAtomicMass(272f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(11),
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(1))
        )

    object Copernicium:
        ChemicalElement(
            ChemicalElementName("Copernicium"),
            ChemicalElementSymbol("Cn"),
            ChemicalElementAtomicNumber(112),
            ChemicalElementAtomicMass(285f),
            kind = TransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(12),
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2))
        )

    object Nihonium:
        ChemicalElement(
            ChemicalElementName("Nihonium"),
            ChemicalElementSymbol("Nh"),
            ChemicalElementAtomicNumber(113),
            ChemicalElementAtomicMass(284f),
            kind = PostTransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(13),
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(1))
        )

    object Flerovium:
        ChemicalElement(
            ChemicalElementName("Flerovium"),
            ChemicalElementSymbol("Fl"),
            ChemicalElementAtomicNumber(114),
            ChemicalElementAtomicMass(289f),
            kind = PostTransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(14),
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(2))
        )

    object Moscovium:
        ChemicalElement(
            ChemicalElementName("Moscovium"),
            ChemicalElementSymbol("Mc"),
            ChemicalElementAtomicNumber(115),
            ChemicalElementAtomicMass(288f),
            kind = PostTransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(15),
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(3))
        )

    object Livermorium:
        ChemicalElement(
            ChemicalElementName("Livermorium"),
            ChemicalElementSymbol("Lv"),
            ChemicalElementAtomicNumber(116),
            ChemicalElementAtomicMass(292f),
            kind = PostTransitionMetal,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(16),
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(4))
        )

    object Tennessine:
        ChemicalElement(
            ChemicalElementName("Tennessine"),
            ChemicalElementSymbol("Ts"),
            ChemicalElementAtomicNumber(117),
            ChemicalElementAtomicMass(295f),
            kind = Halogen,
            state = Solid,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(17),
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(5))
        )

    object Oganesson:
        ChemicalElement(
            ChemicalElementName("Oganesson"),
            ChemicalElementSymbol("Og"),
            ChemicalElementAtomicNumber(118),
            ChemicalElementAtomicMass(294f),
            kind = NobleGas,
            state = Gas,
            ChemicalElementPeriod(7),
            ChemicalElementGroup(18),
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(6))
        )

    companion object {
        val values = ChemicalElement::class.values()

        infix fun of(@IntRange(from = 1, to = 118) atomicNumber: Int) = values.find { it.atomicNumber.value == atomicNumber }!!
    }
}