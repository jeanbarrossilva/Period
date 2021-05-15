package com.jeanbarrossilva.period.model

import androidx.annotation.IntRange
import com.jeanbarrossilva.period.extensions.kclass.values
import com.jeanbarrossilva.period.model.ChemicalElementFloat.AtomicMass
import com.jeanbarrossilva.period.model.ChemicalElementFloat.Electronegativity
import com.jeanbarrossilva.period.model.ChemicalElementInteger.*
import com.jeanbarrossilva.period.model.ChemicalElementKind.*
import com.jeanbarrossilva.period.model.ChemicalElementState.*
import com.jeanbarrossilva.period.model.ElectronDistribution.*
import java.io.Serializable

@Suppress("Unused")
sealed class ChemicalElement(
    val name: ChemicalElementName,
    val symbol: ChemicalElementProperty<String>,
    val atomicNumber: AtomicNumber,
    val atomicMass: AtomicMass,
    val kind: ChemicalElementKind,
    val state: ChemicalElementState,
    val period: Period?,
    val group: Group?,
    val electronegativity: Electronegativity?,
    val electronConfiguration: ElectronConfiguration
): Serializable {
    val color = kind.color
    val protons = Protons(atomicNumber.value)
    val electrons = Electrons(protons.value)
    val neutrons = atomicMass - atomicNumber

    object Hydrogen:
        ChemicalElement(
            ChemicalElementName("Hydrogen"),
            ChemicalElementProperty("H"),
            AtomicNumber(1),
            AtomicMass(1.008f),
            kind = Nonmetal,
            state = Gas,
            Period(1),
            Group(1),
            Electronegativity(2.2f),
            ElectronConfiguration(OneS(1))
        )

    object Helium:
        ChemicalElement(
            ChemicalElementName("Helium"),
            ChemicalElementProperty("He"),
            AtomicNumber(2),
            AtomicMass(4.002f),
            kind = NobleGas,
            state = Gas,
            Period(1),
            Group(18),
            electronegativity = null,
            ElectronConfiguration(OneS(2))
        )

    object Lithium:
        ChemicalElement(
            ChemicalElementName("Lithium"),
            ChemicalElementProperty("Li"),
            AtomicNumber(3),
            AtomicMass(6.941f),
            kind = AlkaliMetal,
            state = Solid,
            Period(2),
            Group(1),
            Electronegativity(0.98f),
            ElectronConfiguration(TwoS(1))
        )

    object Beryllium:
        ChemicalElement(
            ChemicalElementName("Beryllium"),
            ChemicalElementProperty("Be"),
            AtomicNumber(4),
            AtomicMass(9.012f),
            kind = AlkalineEarthMetal,
            state = Solid,
            Period(2),
            Group(2),
            Electronegativity(1.57f),
            ElectronConfiguration(TwoS(2))
        )

    object Boron:
        ChemicalElement(
            ChemicalElementName("Boron"),
            ChemicalElementProperty("B"),
            AtomicNumber(5),
            AtomicMass(10.811f),
            kind = Metalloid,
            state = Solid,
            Period(2),
            Group(13),
            Electronegativity(2.04f),
            ElectronConfiguration(TwoS(2), TwoP(1))
        )

    object Carbon:
        ChemicalElement(
            ChemicalElementName("Carbon"),
            ChemicalElementProperty("C"),
            AtomicNumber(6),
            AtomicMass(12.011f),
            kind = Nonmetal,
            state = Solid,
            Period(2),
            Group(14),
            Electronegativity(2.55f),
            ElectronConfiguration(TwoS(2), TwoP(2))
        )

    object Nitrogen:
        ChemicalElement(
            ChemicalElementName("Nitrogen"),
            ChemicalElementProperty("N"),
            AtomicNumber(7),
            AtomicMass(14.007f),
            kind = Nonmetal,
            state = Gas,
            Period(2),
            Group(15),
            Electronegativity(3.04f),
            ElectronConfiguration(TwoS(2), TwoP(3))
        )

    object Oxygen:
        ChemicalElement(
            ChemicalElementName("Oxygen"),
            ChemicalElementProperty("O"),
            AtomicNumber(8),
            AtomicMass(15.999f),
            kind = Nonmetal,
            state = Gas,
            Period(2),
            Group(16),
            Electronegativity(3.44f),
            ElectronConfiguration(TwoS(2), TwoP(4))
        )

    object Fluorine:
        ChemicalElement(
            ChemicalElementName("Fluorine"),
            ChemicalElementProperty("F"),
            AtomicNumber(9),
            AtomicMass(18.998f),
            kind = Halogen,
            state = Gas,
            Period(2),
            Group(17),
            Electronegativity(3.98f),
            ElectronConfiguration(TwoS(2), TwoP(5))
        )

    object Neon:
        ChemicalElement(
            ChemicalElementName("Neon"),
            ChemicalElementProperty("Ne"),
            AtomicNumber(10),
            AtomicMass(20.18f),
            kind = NobleGas,
            state = Gas,
            Period(2),
            Group(18),
            electronegativity = null,
            ElectronConfiguration(TwoS(2), TwoP(6))
        )

    object Sodium:
        ChemicalElement(
            ChemicalElementName("Sodium"),
            ChemicalElementProperty("Na"),
            AtomicNumber(11),
            AtomicMass(22.99f),
            kind = AlkaliMetal,
            state = Solid,
            Period(3),
            Group(1),
            Electronegativity(0.93f),
            ElectronConfiguration(ThreeS(1))
        )

    object Magnesium:
        ChemicalElement(
            ChemicalElementName("Magnesium"),
            ChemicalElementProperty("Mg"),
            AtomicNumber(12),
            AtomicMass(24.305f),
            kind = AlkalineEarthMetal,
            state = Solid,
            Period(3),
            Group(2),
            Electronegativity(1.31f),
            ElectronConfiguration(ThreeS(2))
        )

    object Aluminum:
        ChemicalElement(
            ChemicalElementName("Aluminum"),
            ChemicalElementProperty("Al"),
            AtomicNumber(13),
            AtomicMass(26.982f),
            kind = PostTransitionMetal,
            state = Solid,
            Period(3),
            Group(13),
            Electronegativity(1.61f),
            ElectronConfiguration(ThreeS(2), ThreeP(1))
        )

    object Silicon:
        ChemicalElement(
            ChemicalElementName("Silicon"),
            ChemicalElementProperty("Si"),
            AtomicNumber(14),
            AtomicMass(28.086f),
            kind = Metalloid,
            state = Solid,
            Period(3),
            Group(14),
            Electronegativity(1.9f),
            ElectronConfiguration(ThreeS(2), ThreeP(2))
        )

    object Phosphorus:
        ChemicalElement(
            ChemicalElementName("Phosphorus"),
            ChemicalElementProperty("P"),
            AtomicNumber(15),
            AtomicMass(30.974f),
            kind = Nonmetal,
            state = Solid,
            Period(3),
            Group(15),
            Electronegativity(2.19f),
            ElectronConfiguration(ThreeS(2), ThreeP(3))
        )

    object Sulfur:
        ChemicalElement(
            ChemicalElementName("Sulfur"),
            ChemicalElementProperty("S"),
            AtomicNumber(16),
            AtomicMass(32.065f),
            kind = Nonmetal,
            state = Solid,
            Period(3),
            Group(16),
            Electronegativity(2.58f),
            ElectronConfiguration(ThreeS(2), ThreeP(4))
        )

    object Chlorine:
        ChemicalElement(
            ChemicalElementName("Chlorine"),
            ChemicalElementProperty("Cl"),
            AtomicNumber(17),
            AtomicMass(35.453f),
            kind = Halogen,
            state = Gas,
            Period(1),
            Group(17),
            Electronegativity(3.16f),
            ElectronConfiguration(ThreeS(2), ThreeP(5))
        )

    object Argon:
        ChemicalElement(
            ChemicalElementName("Argon"),
            ChemicalElementProperty("Ar"),
            AtomicNumber(18),
            AtomicMass(39.948f),
            kind = NobleGas,
            state = Gas,
            Period(3),
            Group(18),
            electronegativity = null,
            ElectronConfiguration(ThreeS(2), ThreeP(6))
        )

    object Potassium:
        ChemicalElement(
            ChemicalElementName("Potassium"),
            ChemicalElementProperty("K"),
            AtomicNumber(19),
            AtomicMass(39.098f),
            kind = AlkaliMetal,
            state = Solid,
            Period(4),
            Group(1),
            Electronegativity(0.82f),
            ElectronConfiguration(FourS(1))
        )

    object Calcium:
        ChemicalElement(
            ChemicalElementName("Calcium"),
            ChemicalElementProperty("Ca"),
            AtomicNumber(20),
            AtomicMass(40.078f),
            kind = AlkalineEarthMetal,
            state = Solid,
            Period(4),
            Group(2),
            Electronegativity(1f),
            ElectronConfiguration(FourS(2))
        )

    object Scandium:
        ChemicalElement(
            ChemicalElementName("Scandium"),
            ChemicalElementProperty("Sc"),
            AtomicNumber(21),
            AtomicMass(44.956f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(3),
            Electronegativity(1.36f),
            ElectronConfiguration(ThreeD(1), FourS(2))
        )

    object Titanium:
        ChemicalElement(
            ChemicalElementName("Titanium"),
            ChemicalElementProperty("Ti"),
            AtomicNumber(22),
            AtomicMass(47.867f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(4),
            Electronegativity(1.54f),
            ElectronConfiguration(ThreeD(2), FourS(2))
        )

    object Vanadium:
        ChemicalElement(
            ChemicalElementName("Vanadium"),
            ChemicalElementProperty("V"),
            AtomicNumber(23),
            AtomicMass(50.942f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(5),
            Electronegativity(1.63f),
            ElectronConfiguration(ThreeD(3), FourS(2))
        )

    object Chromium:
        ChemicalElement(
            ChemicalElementName("Chromium"),
            ChemicalElementProperty("Cr"),
            AtomicNumber(24),
            AtomicMass(51.996f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(6),
            Electronegativity(1.66f),
            ElectronConfiguration(ThreeD(5), FourS(1))
        )

    object Manganese:
        ChemicalElement(
            ChemicalElementName("Manganese"),
            ChemicalElementProperty("Mn"),
            AtomicNumber(25),
            AtomicMass(54.938f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(7),
            Electronegativity(1.55f),
            ElectronConfiguration(ThreeD(5), FourS(2))
        )

    object Iron:
        ChemicalElement(
            ChemicalElementName("Iron"),
            ChemicalElementProperty("Fe"),
            AtomicNumber(26),
            AtomicMass(55.845f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(8),
            Electronegativity(1.83f),
            ElectronConfiguration(ThreeD(6), FourS(2))
        )

    object Cobalt:
        ChemicalElement(
            ChemicalElementName("Cobalt"),
            ChemicalElementProperty("Co"),
            AtomicNumber(27),
            AtomicMass(58.933f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(9),
            Electronegativity(1.88f),
            ElectronConfiguration(ThreeD(7), FourS(2))
        )

    object Nickel:
        ChemicalElement(
            ChemicalElementName("Nickel"),
            ChemicalElementProperty("Ni"),
            AtomicNumber(28),
            AtomicMass(58.693f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(10),
            Electronegativity(1.91f),
            ElectronConfiguration(ThreeD(8), FourS(2))
        )

    object Copper:
        ChemicalElement(
            ChemicalElementName("Copper"),
            ChemicalElementProperty("Cu"),
            AtomicNumber(29),
            AtomicMass(63.546f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(11),
            Electronegativity(1.9f),
            ElectronConfiguration(ThreeD(10), FourS(1))
        )

    object Zinc:
        ChemicalElement(
            ChemicalElementName("Zinc"),
            ChemicalElementProperty("Zn"),
            AtomicNumber(30),
            AtomicMass(65.38f),
            kind = TransitionMetal,
            state = Solid,
            Period(4),
            Group(12),
            Electronegativity(1.65f),
            ElectronConfiguration(ThreeD(10), FourS(2))
        )

    object Gallium:
        ChemicalElement(
            ChemicalElementName("Gallium"),
            ChemicalElementProperty("Ga"),
            AtomicNumber(31),
            AtomicMass(69.723f),
            kind = PostTransitionMetal,
            state = Solid,
            Period(4),
            Group(13),
            Electronegativity(1.81f),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(1))
        )

    object Germanium:
        ChemicalElement(
            ChemicalElementName("Germanium"),
            ChemicalElementProperty("Ge"),
            AtomicNumber(32),
            AtomicMass(72.64f),
            kind = Metalloid,
            state = Solid,
            Period(4),
            Group(14),
            Electronegativity(2.01f),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(2))
        )

    object Arsenic:
        ChemicalElement(
            ChemicalElementName("Arsenic"),
            ChemicalElementProperty("As"),
            AtomicNumber(33),
            AtomicMass(74.922f),
            kind = Metalloid,
            state = Solid,
            Period(4),
            Group(15),
            Electronegativity(2.18f),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(3))
        )

    object Selenium:
        ChemicalElement(
            ChemicalElementName("Selenium"),
            ChemicalElementProperty("Se"),
            AtomicNumber(34),
            AtomicMass(78.96f),
            kind = Nonmetal,
            state = Solid,
            Period(4),
            Group(16),
            Electronegativity(2.55f),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(4))
        )

    object Bromine:
        ChemicalElement(
            ChemicalElementName("Bromine"),
            ChemicalElementProperty("Br"),
            AtomicNumber(35),
            AtomicMass(79.904f),
            kind = Halogen,
            state = Liquid,
            Period(4),
            Group(17),
            Electronegativity(2.96f),
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(5))
        )

    object Krypton:
        ChemicalElement(
            ChemicalElementName("Krypton"),
            ChemicalElementProperty("Kr"),
            AtomicNumber(36),
            AtomicMass(83.798f),
            kind = NobleGas,
            state = Gas,
            Period(4),
            Group(18),
            electronegativity = null,
            ElectronConfiguration(ThreeD(10), FourS(2), FourP(6))
        )

    object Rubidium:
        ChemicalElement(
            ChemicalElementName("Rubidium"),
            ChemicalElementProperty("Rb"),
            AtomicNumber(37),
            AtomicMass(85.468f),
            kind = AlkaliMetal,
            state = Solid,
            Period(5),
            Group(1),
            Electronegativity(0.82f),
            ElectronConfiguration(FiveS(1))
        )

    object Strontium:
        ChemicalElement(
            ChemicalElementName("Strontium"),
            ChemicalElementProperty("Sr"),
            AtomicNumber(38),
            AtomicMass(87.62f),
            kind = AlkalineEarthMetal,
            state = Solid,
            Period(5),
            Group(2),
            Electronegativity(0.95f),
            ElectronConfiguration(FiveS(2))
        )

    object Yttrium:
        ChemicalElement(
            ChemicalElementName("Yttrium"),
            ChemicalElementProperty("Y"),
            AtomicNumber(39),
            AtomicMass(88.906f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(3),
            Electronegativity(1.22f),
            ElectronConfiguration(FourD(1), FiveS(2))
        )

    object Zirconium:
        ChemicalElement(
            ChemicalElementName("Zirconium"),
            ChemicalElementProperty("Zr"),
            AtomicNumber(40),
            AtomicMass(91.224f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(4),
            Electronegativity(1.33f),
            ElectronConfiguration(FourD(2), FiveS(2))
        )

    object Niobium:
        ChemicalElement(
            ChemicalElementName("Niobium"),
            ChemicalElementProperty("Nb"),
            AtomicNumber(41),
            AtomicMass(98.906f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(5),
            Electronegativity(1.6f),
            ElectronConfiguration(FourD(4), FiveS(1))
        )

    object Molybdenum:
        ChemicalElement(
            ChemicalElementName("Molybdenum"),
            ChemicalElementProperty("Mo"),
            AtomicNumber(42),
            AtomicMass(95.96f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(6),
            Electronegativity(2.16f),
            ElectronConfiguration(FourD(5), FiveS(1))
        )

    object Technetium:
        ChemicalElement(
            ChemicalElementName("Technetium"),
            ChemicalElementProperty("Tc"),
            AtomicNumber(43),
            AtomicMass(98f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(7),
            Electronegativity(1.9f),
            ElectronConfiguration(FourD(5), FiveS(2))
        )

    object Ruthenium:
        ChemicalElement(
            ChemicalElementName("Ruthenium"),
            ChemicalElementProperty("Ru"),
            AtomicNumber(44),
            AtomicMass(101.107f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(8),
            Electronegativity(2.2f),
            ElectronConfiguration(FourD(7), FiveS(1))
        )

    object Rhodium:
        ChemicalElement(
            ChemicalElementName("Rhodium"),
            ChemicalElementProperty("Rh"),
            AtomicNumber(45),
            AtomicMass(102.906f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(9),
            Electronegativity(2.28f),
            ElectronConfiguration(FourD(8), FiveS(1))
        )

    object Palladium:
        ChemicalElement(
            ChemicalElementName("Palladium"),
            ChemicalElementProperty("Pd"),
            AtomicNumber(46),
            AtomicMass(106.42f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(10),
            Electronegativity(2.2f),
            ElectronConfiguration(FourD(10))
        )

    object Silver:
        ChemicalElement(
            ChemicalElementName("Silver"),
            ChemicalElementProperty("Ag"),
            AtomicNumber(47),
            AtomicMass(07.869f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(11),
            Electronegativity(1.93f),
            ElectronConfiguration(FourD(10), FiveS(1))
        )

    object Cadmium:
        ChemicalElement(
            ChemicalElementName("Cadmium"),
            ChemicalElementProperty("Cd"),
            AtomicNumber(48),
            AtomicMass(112.411f),
            kind = TransitionMetal,
            state = Solid,
            Period(5),
            Group(12),
            Electronegativity(1.69f),
            ElectronConfiguration(FourD(10), FiveS(2))
        )

    object Indium:
        ChemicalElement(
            ChemicalElementName("Indium"),
            ChemicalElementProperty("In"),
            AtomicNumber(49),
            AtomicMass(114.818f),
            kind = PostTransitionMetal,
            state = Solid,
            Period(5),
            Group(13),
            Electronegativity(1.78f),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(1))
        )

    object Tin:
        ChemicalElement(
            ChemicalElementName("Tin"),
            ChemicalElementProperty("Sn"),
            AtomicNumber(50),
            AtomicMass(118.71f),
            kind = PostTransitionMetal,
            state = Solid,
            Period(1),
            Group(14),
            Electronegativity(1.96f),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(2))
        )

    object Antimony:
        ChemicalElement(
            ChemicalElementName("Antimony"),
            ChemicalElementProperty("Sb"),
            AtomicNumber(51),
            AtomicMass(121.76f),
            kind = Metalloid,
            state = Solid,
            Period(5),
            Group(15),
            Electronegativity(2.05f),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(3))
        )

    object Tellurium:
        ChemicalElement(
            ChemicalElementName("Tellurium"),
            ChemicalElementProperty("Te"),
            AtomicNumber(52),
            AtomicMass(127.6f),
            kind = Metalloid,
            state = Solid,
            Period(5),
            Group(16),
            Electronegativity(2.1f),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(4))
        )

    object Iodine:
        ChemicalElement(
            ChemicalElementName("Iodine"),
            ChemicalElementProperty("I"),
            AtomicNumber(53),
            AtomicMass(126.904f),
            kind = Halogen,
            state = Solid,
            Period(5),
            Group(17),
            Electronegativity(2.66f),
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(5))
        )

    object Xenon:
        ChemicalElement(
            ChemicalElementName("Xenon"),
            ChemicalElementProperty("Xe"),
            AtomicNumber(54),
            AtomicMass(131.293f),
            kind = NobleGas,
            state = Gas,
            Period(5),
            Group(18),
            electronegativity = null,
            ElectronConfiguration(FourD(10), FiveS(2), FiveP(6))
        )

    object Caesium:
        ChemicalElement(
            ChemicalElementName("Caesium"),
            ChemicalElementProperty("Cs"),
            AtomicNumber(55),
            AtomicMass(132.905f),
            kind = AlkaliMetal,
            state = Solid,
            Period(6),
            Group(1),
            Electronegativity(0.79f),
            ElectronConfiguration(SixS(1))
        )

    object Barium:
        ChemicalElement(
            ChemicalElementName("Barium"),
            ChemicalElementProperty("Ba"),
            AtomicNumber(56),
            AtomicMass(137.327f),
            kind = AlkalineEarthMetal,
            state = Solid,
            Period(6),
            Group(2),
            Electronegativity(0.89f),
            ElectronConfiguration(SixS(2))
        )

    object Lanthanum:
        ChemicalElement(
            ChemicalElementName("Lanthanum"),
            ChemicalElementProperty("La"),
            AtomicNumber(57),
            AtomicMass(138.905f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.1f),
            ElectronConfiguration(FiveD(1), SixS(2))
        )

    object Cerium:
        ChemicalElement(
            ChemicalElementName("Cerium"),
            ChemicalElementProperty("Ce"),
            AtomicNumber(58),
            AtomicMass(140.116f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.12f),
            ElectronConfiguration(FourF(1), FiveD(1), SixS(2))
        )

    object Praseodymium:
        ChemicalElement(
            ChemicalElementName("Praseodymium"),
            ChemicalElementProperty("Pr"),
            AtomicNumber(59),
            AtomicMass(140.908f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.13f),
            ElectronConfiguration(FourF(3), SixS(2))
        )

    object Neodymium:
        ChemicalElement(
            ChemicalElementName("Neodymium"),
            ChemicalElementProperty("Nd"),
            AtomicNumber(60),
            AtomicMass(144.242f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.14f),
            ElectronConfiguration(FourF(4), SixS(2))
        )

    object Promethium:
        ChemicalElement(
            ChemicalElementName("Promethium"),
            ChemicalElementProperty("Pm"),
            AtomicNumber(61),
            AtomicMass(145f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.13f),
            ElectronConfiguration(FourF(5), SixS(2))
        )

    object Samarium:
        ChemicalElement(
            ChemicalElementName("Samarium"),
            ChemicalElementProperty("Sm"),
            AtomicNumber(62),
            AtomicMass(150.36f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.17f),
            ElectronConfiguration(FourF(6), SixS(2))
        )

    object Europium:
        ChemicalElement(
            ChemicalElementName("Europium"),
            ChemicalElementProperty("Eu"),
            AtomicNumber(63),
            AtomicMass(151.964f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.2f),
            ElectronConfiguration(FourF(7), SixS(2))
        )

    object Gadolinium:
        ChemicalElement(
            ChemicalElementName("Gadolinium"),
            ChemicalElementProperty("Gd"),
            AtomicNumber(64),
            AtomicMass(157.25f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.2f),
            ElectronConfiguration(FourF(7), FiveD(1), SixS(2))
        )

    object Terbium:
        ChemicalElement(
            ChemicalElementName("Terbium"),
            ChemicalElementProperty("Tb"),
            AtomicNumber(65),
            AtomicMass(158.925f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.2f),
            ElectronConfiguration(FourF(9), SixS(2))
        )

    object Dysprosium:
        ChemicalElement(
            ChemicalElementName("Dysprosium"),
            ChemicalElementProperty("Dy"),
            AtomicNumber(66),
            AtomicMass(162.5f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.22f),
            ElectronConfiguration(FourF(10), SixS(2))
        )

    object Holmium:
        ChemicalElement(
            ChemicalElementName("Holmium"),
            ChemicalElementProperty("Ho"),
            AtomicNumber(67),
            AtomicMass(164.93f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.23f),
            ElectronConfiguration(FourF(11), SixS(2))
        )

    object Erbium:
        ChemicalElement(
            ChemicalElementName("Erbium"),
            ChemicalElementProperty("Er"),
            AtomicNumber(68),
            AtomicMass(167.259f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.24f),
            ElectronConfiguration(FourF(12), SixS(2))
        )

    object Thulium:
        ChemicalElement(
            ChemicalElementName("Thulium"),
            ChemicalElementProperty("Tm"),
            AtomicNumber(69),
            AtomicMass(168.934f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.25f),
            ElectronConfiguration(FourF(13), SixS(2))
        )

    object Ytterbium:
        ChemicalElement(
            ChemicalElementName("Ytterbium"),
            ChemicalElementProperty("Yb"),
            AtomicNumber(70),
            AtomicMass(173.054f),
            kind = Lanthanide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.1f),
            ElectronConfiguration(FourF(14), SixS(2))
        )

    object Lutetium:
        ChemicalElement(
            ChemicalElementName("Lutetium"),
            ChemicalElementProperty("Lu"),
            AtomicNumber(71),
            AtomicMass(174.967f),
            kind = Lanthanide,
            state = Solid,
            Period(6),
            Group(18),
            Electronegativity(1.27f),
            ElectronConfiguration(FourF(14), FiveD(1), SixS(2))
        )

    object Hafnium:
        ChemicalElement(
            ChemicalElementName("Hafnium"),
            ChemicalElementProperty("Hf"),
            AtomicNumber(72),
            AtomicMass(178.49f),
            kind = TransitionMetal,
            state = Solid,
            Period(6),
            Group(4),
            Electronegativity(1.3f),
            ElectronConfiguration(FourF(14), FiveD(2), SixS(2))
        )

    object Tantalum:
        ChemicalElement(
            ChemicalElementName("Tantalum"),
            ChemicalElementProperty("Ta"),
            AtomicNumber(73),
            AtomicMass(180.948f),
            kind = TransitionMetal,
            state = Solid,
            Period(6),
            Group(5),
            Electronegativity(1.5f),
            ElectronConfiguration(FourF(14), FiveD(3), SixS(2))
        )

    object Tungsten:
        ChemicalElement(
            ChemicalElementName("Tungsten"),
            ChemicalElementProperty("W"),
            AtomicNumber(74),
            AtomicMass(183.84f),
            kind = TransitionMetal,
            state = Solid,
            Period(6),
            Group(6),
            Electronegativity(2.36f),
            ElectronConfiguration(FourF(14), FiveD(4), SixS(2))
        )

    object Rhenium:
        ChemicalElement(
            ChemicalElementName("Rhenium"),
            ChemicalElementProperty("Re"),
            AtomicNumber(75),
            AtomicMass(186.207f),
            kind = TransitionMetal,
            state = Solid,
            Period(6),
            Group(7),
            Electronegativity(1.9f),
            ElectronConfiguration(FourF(14), FiveD(5), SixS(2))
        )

    object Osmium:
        ChemicalElement(
            ChemicalElementName("Osmium"),
            ChemicalElementProperty("Os"),
            AtomicNumber(76),
            AtomicMass(190.23f),
            kind = TransitionMetal,
            state = Solid,
            Period(6),
            Group(8),
            Electronegativity(2.2f),
            ElectronConfiguration(FourF(14), FiveD(6), SixS(2))
        )

    object Iridium:
        ChemicalElement(
            ChemicalElementName("Iridium"),
            ChemicalElementProperty("Ir"),
            AtomicNumber(77),
            AtomicMass(192.217f),
            kind = TransitionMetal,
            state = Solid,
            Period(6),
            Group(9),
            Electronegativity(2.2f),
            ElectronConfiguration(FourF(14), FiveD(7), SixS(2))
        )

    object Platinum:
        ChemicalElement(
            ChemicalElementName("Platinum"),
            ChemicalElementProperty("Pt"),
            AtomicNumber(78),
            AtomicMass(195.084f),
            kind = TransitionMetal,
            state = Solid,
            Period(6),
            Group(10),
            Electronegativity(2.28f),
            ElectronConfiguration(FourF(14), FiveD(9), SixS(1))
        )

    object Gold:
        ChemicalElement(
            ChemicalElementName("Gold"),
            ChemicalElementProperty("Au"),
            AtomicNumber(79),
            AtomicMass(196.967f),
            kind = TransitionMetal,
            state = Solid,
            Period(6),
            Group(11),
            Electronegativity(2.54f),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(1))
        )

    object Mercury:
        ChemicalElement(
            ChemicalElementName("Mercury"),
            ChemicalElementProperty("Hg"),
            AtomicNumber(80),
            AtomicMass(200.59f),
            kind = TransitionMetal,
            state = Liquid,
            Period(6),
            Group(12),
            Electronegativity(2f),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2))
        )

    object Thallium:
        ChemicalElement(
            ChemicalElementName("Thallium"),
            ChemicalElementProperty("Tl"),
            AtomicNumber(81),
            AtomicMass(204.383f),
            kind = Actinide,
            state = Solid,
            Period(6),
            Group(13),
            Electronegativity(2.04f),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(1))
        )

    object Lead:
        ChemicalElement(
            ChemicalElementName("Lead"),
            ChemicalElementProperty("Pb"),
            AtomicNumber(82),
            AtomicMass(207.2f),
            kind = Actinide,
            state = Solid,
            Period(6),
            Group(14),
            Electronegativity(2.33f),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(2))
        )

    object Bismuth:
        ChemicalElement(
            ChemicalElementName("Bismuth"),
            ChemicalElementProperty("Bi"),
            AtomicNumber(83),
            AtomicMass(208.98f),
            kind = Actinide,
            state = Solid,
            Period(6),
            Group(15),
            Electronegativity(2.02f),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(3))
        )

    object Polonium:
        ChemicalElement(
            ChemicalElementName("Polonium"),
            ChemicalElementProperty("Po"),
            AtomicNumber(84),
            AtomicMass(210f),
            kind = Actinide,
            state = Solid,
            Period(6),
            Group(16),
            Electronegativity(2f),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(4))
        )

    object Astatine:
        ChemicalElement(
            ChemicalElementName("Astatine"),
            ChemicalElementProperty("At"),
            AtomicNumber(85),
            AtomicMass(210f),
            kind = Halogen,
            state = Solid,
            Period(6),
            Group(17),
            Electronegativity(2.2f),
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(5))
        )

    object Radon:
        ChemicalElement(
            ChemicalElementName("Radon"),
            ChemicalElementProperty("Rn"),
            AtomicNumber(86),
            AtomicMass(222f),
            kind = NobleGas,
            state = Gas,
            Period(6),
            Group(18),
            electronegativity = null,
            ElectronConfiguration(FourF(14), FiveD(10), SixS(2), SixP(6))
        )

    object Francium:
        ChemicalElement(
            ChemicalElementName("Francium"),
            ChemicalElementProperty("Fr"),
            AtomicNumber(87),
            AtomicMass(223f),
            kind = AlkaliMetal,
            state = Solid,
            Period(7),
            Group(1),
            Electronegativity(0.7f),
            ElectronConfiguration(SevenS(1))
        )

    object Radium:
        ChemicalElement(
            ChemicalElementName("Radium"),
            ChemicalElementProperty("Ra"),
            AtomicNumber(88),
            AtomicMass(226f),
            kind = AlkalineEarthMetal,
            state = Solid,
            Period(7),
            Group(2),
            Electronegativity(0.9f),
            ElectronConfiguration(SevenS(2))
        )

    object Actinium:
        ChemicalElement(
            ChemicalElementName("Actinium"),
            ChemicalElementProperty("Ac"),
            AtomicNumber(89),
            AtomicMass(227f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.1f),
            ElectronConfiguration(SixD(1), SevenS(2))
        )

    object Thorium:
        ChemicalElement(
            ChemicalElementName("Thorium"),
            ChemicalElementProperty("Th"),
            AtomicNumber(90),
            AtomicMass(232.038f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(SixD(2), SevenS(2))
        )

    object Protactinium:
        ChemicalElement(
            ChemicalElementName("Protactinium"),
            ChemicalElementProperty("Pa"),
            AtomicNumber(91),
            AtomicMass(231.036f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.5f),
            ElectronConfiguration(FiveF(2), SixD(1), SevenS(2))
        )

    object Uranium:
        ChemicalElement(
            ChemicalElementName("Uranium"),
            ChemicalElementProperty("U"),
            AtomicNumber(92),
            AtomicMass(238.029f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.38f),
            ElectronConfiguration(FiveF(3), SixD(1), SevenS(2))
        )

    object Neptunium:
        ChemicalElement(
            ChemicalElementName("Neptunium"),
            ChemicalElementProperty("Np"),
            AtomicNumber(93),
            AtomicMass(237f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.36f),
            ElectronConfiguration(FiveF(4), SixD(1), SevenS(2))
        )

    object Plutonium:
        ChemicalElement(
            ChemicalElementName("Plutonium"),
            ChemicalElementProperty("Pu"),
            AtomicNumber(94),
            AtomicMass(244f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.28f),
            ElectronConfiguration(FiveF(6), SevenS(2))
        )

    object Americium:
        ChemicalElement(
            ChemicalElementName("Americium"),
            ChemicalElementProperty("Am"),
            AtomicNumber(95),
            AtomicMass(243f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(FiveF(7), SevenS(2))
        )

    object Curium:
        ChemicalElement(
            ChemicalElementName("Curium"),
            ChemicalElementProperty("Cm"),
            AtomicNumber(96),
            AtomicMass(247f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(FiveF(7), SixD(1), SevenS(2))
        )

    object Berkelium:
        ChemicalElement(
            ChemicalElementName("Berkelium"),
            ChemicalElementProperty("Bk"),
            AtomicNumber(97),
            AtomicMass(247f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(FiveF(9), SevenS(2))
        )

    object Californium:
        ChemicalElement(
            ChemicalElementName("Californium"),
            ChemicalElementProperty("Cf"),
            AtomicNumber(98),
            AtomicMass(251f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(FiveF(10), SevenS(2))
        )

    object Einsteinium:
        ChemicalElement(
            ChemicalElementName("Einsteinium"),
            ChemicalElementProperty("Es"),
            AtomicNumber(99),
            AtomicMass(252f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(FiveF(11), SevenS(2))
        )

    object Fermium:
        ChemicalElement(
            ChemicalElementName("Fermium"),
            ChemicalElementProperty("Fm"),
            AtomicNumber(100),
            AtomicMass(257f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(FiveF(12), SevenS(2))
        )

    object Mendelevium:
        ChemicalElement(
            ChemicalElementName("Mendelevium"),
            ChemicalElementProperty("Md"),
            AtomicNumber(101),
            AtomicMass(258f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(FiveF(13), SevenS(2))
        )

    object Nobelium:
        ChemicalElement(
            ChemicalElementName("Nobelium"),
            ChemicalElementProperty("No"),
            AtomicNumber(102),
            AtomicMass(259f),
            kind = Actinide,
            state = Solid,
            period = null,
            group = null,
            Electronegativity(1.3f),
            ElectronConfiguration(FiveF(14), SevenS(2))
        )

    object Lawrencium:
        ChemicalElement(
            ChemicalElementName("Lawrencium"),
            ChemicalElementProperty("Lr"),
            AtomicNumber(103),
            AtomicMass(262f),
            kind = Actinide,
            state = Solid,
            Period(7),
            Group(18),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SevenS(2), SevenP(1))
        )

    object Rutherfordium:
        ChemicalElement(
            ChemicalElementName("Rutherfordium"),
            ChemicalElementProperty("Rf"),
            AtomicNumber(104),
            AtomicMass(261f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(4),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(2), SevenS(2))
        )

    object Dubnium:
        ChemicalElement(
            ChemicalElementName("Dubnium"),
            ChemicalElementProperty("Db"),
            AtomicNumber(105),
            AtomicMass(262f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(5),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(3), SevenS(2))
        )

    object Seaborgium:
        ChemicalElement(
            ChemicalElementName("Seaborgium"),
            ChemicalElementProperty("Sg"),
            AtomicNumber(106),
            AtomicMass(266f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(6),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(4), SevenS(2))
        )

    object Bohrium:
        ChemicalElement(
            ChemicalElementName("Bohrium"),
            ChemicalElementProperty("Bh"),
            AtomicNumber(107),
            AtomicMass(264f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(7),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(5), SevenS(2))
        )

    object Hassium:
        ChemicalElement(
            ChemicalElementName("Hassium"),
            ChemicalElementProperty("Hs"),
            AtomicNumber(108),
            AtomicMass(267f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(8),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(6), SevenS(2))
        )

    object Meitnerium:
        ChemicalElement(
            ChemicalElementName("Meitnerium"),
            ChemicalElementProperty("Mt"),
            AtomicNumber(109),
            AtomicMass(268f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(9),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(7), SevenS(2))
        )

    object Darmstadtium:
        ChemicalElement(
            ChemicalElementName("Darmstadtium"),
            ChemicalElementProperty("Ds"),
            AtomicNumber(110),
            AtomicMass(271f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(10),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(9), SevenS(1))
        )

    object Roentgenium:
        ChemicalElement(
            ChemicalElementName("Roentgenium"),
            ChemicalElementProperty("Rg"),
            AtomicNumber(111),
            AtomicMass(272f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(11),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(1))
        )

    object Copernicium:
        ChemicalElement(
            ChemicalElementName("Copernicium"),
            ChemicalElementProperty("Cn"),
            AtomicNumber(112),
            AtomicMass(285f),
            kind = TransitionMetal,
            state = Solid,
            Period(7),
            Group(12),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2))
        )

    object Nihonium:
        ChemicalElement(
            ChemicalElementName("Nihonium"),
            ChemicalElementProperty("Nh"),
            AtomicNumber(113),
            AtomicMass(284f),
            kind = PostTransitionMetal,
            state = Solid,
            Period(7),
            Group(13),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(1))
        )

    object Flerovium:
        ChemicalElement(
            ChemicalElementName("Flerovium"),
            ChemicalElementProperty("Fl"),
            AtomicNumber(114),
            AtomicMass(289f),
            kind = PostTransitionMetal,
            state = Solid,
            Period(7),
            Group(14),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(2))
        )

    object Moscovium:
        ChemicalElement(
            ChemicalElementName("Moscovium"),
            ChemicalElementProperty("Mc"),
            AtomicNumber(115),
            AtomicMass(288f),
            kind = PostTransitionMetal,
            state = Solid,
            Period(7),
            Group(15),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(3))
        )

    object Livermorium:
        ChemicalElement(
            ChemicalElementName("Livermorium"),
            ChemicalElementProperty("Lv"),
            AtomicNumber(116),
            AtomicMass(292f),
            kind = PostTransitionMetal,
            state = Solid,
            Period(7),
            Group(16),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(4))
        )

    object Tennessine:
        ChemicalElement(
            ChemicalElementName("Tennessine"),
            ChemicalElementProperty("Ts"),
            AtomicNumber(117),
            AtomicMass(295f),
            kind = Halogen,
            state = Solid,
            Period(7),
            Group(17),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(5))
        )

    object Oganesson:
        ChemicalElement(
            ChemicalElementName("Oganesson"),
            ChemicalElementProperty("Og"),
            AtomicNumber(118),
            AtomicMass(294f),
            kind = NobleGas,
            state = Gas,
            Period(7),
            Group(18),
            electronegativity = null,
            ElectronConfiguration(FiveF(14), SixD(10), SevenS(2), SevenP(6))
        )

    override fun toString(): String {
        return "ChemicalElement(name=$name, symbol=$symbol, atomicNumber=$atomicNumber, atomicMass=$atomicMass, kind=$kind, state=$state, period=$period, " +
            "group=$group, electronegativity=$electronegativity, electronConfiguration=$electronConfiguration)"
    }

    companion object {
        val values = ChemicalElement::class.values()
        val default = Oganesson

        infix fun of(@IntRange(from = 1, to = 118) atomicNumber: Int) = values.find { it.atomicNumber.value == atomicNumber }!!
    }
}