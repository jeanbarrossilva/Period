package com.jeanbarrossilva.period.data

import android.content.Context
import android.util.Log
import androidx.annotation.StringRes
import androidx.core.content.edit
import com.jeanbarrossilva.data.R
import com.jeanbarrossilva.period.extensions.any.doIf
import com.jeanbarrossilva.period.extensions.context.preferences
import com.jeanbarrossilva.period.extensions.kclass.values

@Suppress("Unused", "LongLogTag")
sealed class ChemicalElementSortingOption<R: Representable>(
    val title: String,
    val equivalent: (ChemicalElement) -> R,
    private val elements: List<ChemicalElement>.() -> List<ChemicalElement>
) {
    constructor(context: Context, representation: (ChemicalElement) -> R, @StringRes titleRes: Int, elements: List<ChemicalElement>.() -> List<ChemicalElement>):
        this(context.getString(titleRes), representation, elements)

    data class AtomicNumber(private val context: Context): ChemicalElementSortingOption<ChemicalElementAtomicNumber>(
        context,
        {
            it.atomicNumber
        },
        R.string.ChemicalElementSortingOption_AtomicNumber,
        {
        sortedBy {
            it.atomicNumber.value
        }
    })

    data class AtomicMass(private val context: Context): ChemicalElementSortingOption<ChemicalElementAtomicMass>(
        context,
        {
            it.atomicMass
        },
        R.string.ChemicalElementSortingOption_AtomicMass,
        {
            sortedBy {
                it.atomicMass.value
            }
        }
    )

    data class Name(private val context: Context): ChemicalElementSortingOption<ChemicalElementName>(
        context,
        {
            it.name
        },
        R.string.ChemicalElementSortingOption_Name,
        {
            sortedBy {
                it.name.value
            }
        }
    )

    data class Kind(private val context: Context): ChemicalElementSortingOption<ChemicalElementKind>(
        context,
        {
            it.kind
        },
        R.string.ChemicalElementSortingOption_Kind,
        {
            sortedBy {
                it.kind.name
            }
        }
    )

    fun getElements() = elements(ChemicalElement.values)

    companion object {
        private const val TAG = "ChemicalElementSortingOption"
        private const val PREF_KEY_PREFERRED_SORTING_OPTION = "preferred_sorting_option"

        fun values(context: Context) = ChemicalElementSortingOption::class.values(context)

        fun getDefault(context: Context) = AtomicMass(context)

        fun getPreferred(context: Context): ChemicalElementSortingOption<*> {
            val values = values(context)
            val valueClasses = values.map { it::class }
            val index = context.preferences.getInt(PREF_KEY_PREFERRED_SORTING_OPTION, -1).doIf({ this == -1 }) {
                valueClasses.indexOf(getDefault(context)::class)
            }
            return values[index].also {
                Log.d(TAG, "preferred: $it")
            }
        }

        fun getPreferredIndex(context: Context): Int {
            val valueClasses = values(context).map { sortingOption ->
                sortingOption::class
            }
            return valueClasses.indexOf(getPreferred(context)::class)
        }

        fun prefer(context: Context, sortingOption: ChemicalElementSortingOption<*>) {
            val valueClasses = values(context).map { sortinngOption ->
                sortinngOption::class
            }
            context.preferences.edit {
                putInt(PREF_KEY_PREFERRED_SORTING_OPTION, valueClasses.indexOf(sortingOption::class))
            }
        }
    }
}