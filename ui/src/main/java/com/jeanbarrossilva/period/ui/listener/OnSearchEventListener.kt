package com.jeanbarrossilva.period.ui.listener

interface OnSearchEventListener {
    fun onStartSearch()

    fun onExitSearch()

    companion object {
        operator fun invoke(block: (isSearching: Boolean) -> Unit) = object: OnSearchEventListener {
            override fun onStartSearch() = block(true)

            override fun onExitSearch() = block(false)
        }
    }
}