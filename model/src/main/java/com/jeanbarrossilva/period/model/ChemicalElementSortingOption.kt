package com.jeanbarrossilva.period.model

import android.content.Context
import android.util.Log
import androidx.annotation.StringRes
import androidx.core.content.edit
import com.jeanbarrossilva.data.R
import com.jeanbarrossilva.period.extensions.any.doIf
import com.jeanbarrossilva.period.extensions.context.preferences
import com.jeanbarrossilva.period.extensions.kclass.values
import java.io.Serializable

@Suppress("Unused", "LongLogTag")
sealed class ChemicalElementSortingOption<P: ChemicalElementProperty<*>>(val title: String, val equivalent: ChemicalElement.() -> P):
    Comparable<ChemicalElementSortingOption<*>>, Serializable {
    constructor(context: Context, representation: ChemicalElement.() -> P, @StringRes titleRes: Int):
        this(context.getString(titleRes), representation)

    data class AtomicNumber(private val context: Context): ChemicalElementSortingOption<ChemicalElementInteger.AtomicNumber>(
        context,
        {
            atomicNumber
        },
        R.string.ChemicalElementSortingOption_AtomicNumber
    )

    data class AtomicMass(private val context: Context): ChemicalElementSortingOption<ChemicalElementFloat.AtomicMass>(
        context,
        {
            atomicMass
        },
        R.string.ChemicalElementSortingOption_AtomicMass
    )

    data class Name(private val context: Context): ChemicalElementSortingOption<ChemicalElementName>(
        context,
        {
            name
        },
        R.string.ChemicalElementSortingOption_Name
    )

    data class Kind(private val context: Context): ChemicalElementSortingOption<ChemicalElementKind>(
        context,
        {
            kind
        },
        R.string.ChemicalElementSortingOption_Kind
    )

    data class ElectronConfiguration(private val context: Context): ChemicalElementSortingOption<com.jeanbarrossilva.period.model.ElectronConfiguration>(
        context,
        {
            electronConfiguration
        },
        R.string.ChemicalElementSortingOption_ElectronConfiguration
    )

    override fun compareTo(other: ChemicalElementSortingOption<*>): Int {
        return title.compareTo(other.title)
    }

    @Suppress("UNCHECKED_CAST")
    fun getElements(): List<ChemicalElement> {
        return ChemicalElement.values.sortedBy { element ->
            element.equivalent().value as Comparable<Any>
        }
    }

    companion object {
        private const val TAG = "ChemicalElementSortingOption"
        private const val PREF_KEY_PREFERRED_SORTING_OPTION = "preferred_sorting_option"

        private fun getDefault(context: Context) = AtomicMass(context)

        fun values(context: Context) = ChemicalElementSortingOption::class.values(context)

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
            val valueClasses = values(context).map {
                it::class
            }
            context.preferences.edit {
                putInt(PREF_KEY_PREFERRED_SORTING_OPTION, valueClasses.indexOf(sortingOption::class))
            }
        }
    }
}