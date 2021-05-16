package com.jeanbarrossilva.period.model

class ElectronConfiguration(private vararg val distributions: ElectronDistribution):
    ChemicalElementProperty<String>(distributions.joinToString(" ") { distribution ->
        distribution.value
    }),
    Comparable<ElectronConfiguration> {
    private val limit = ElectronDistribution::class.sealedSubclasses.size

    init {
        if (distributions.size > limit)
            error("Exceeded the size limit of $limit distributions!")
    }

    override fun compareTo(other: ElectronConfiguration): Int {
        val electronCount = distributions.map { distribution ->
            distribution.subshell.electronCount
        }.sum()
        val otherElectronCount = other.distributions.map { distribution ->
            distribution.subshell.electronCount
        }.sum()

        return electronCount.compareTo(otherElectronCount)
    }
}