package com.jeanbarrossilva.period.data

class ElectronConfiguration(vararg distributions: ElectronDistribution): Representable {
    private val limit = ElectronDistribution::class.sealedSubclasses.size

    override val representation = distributions.joinToString(" ") { it.representation }

    init {
        if (distributions.size > limit)
            error("Exceeded the size limit of $limit distributions!")
    }
}