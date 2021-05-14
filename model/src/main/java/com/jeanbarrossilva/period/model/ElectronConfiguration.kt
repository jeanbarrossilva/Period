package com.jeanbarrossilva.period.model

class ElectronConfiguration(vararg distributions: ElectronDistribution): ChemicalElementProperty<String>(distributions.joinToString(" ") { distribution ->
    distribution.value
}) {
    private val limit = ElectronDistribution::class.sealedSubclasses.size

    init {
        if (distributions.size > limit)
            error("Exceeded the size limit of $limit distributions!")
    }
}