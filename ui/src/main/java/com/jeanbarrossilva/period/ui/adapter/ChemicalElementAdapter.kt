package com.jeanbarrossilva.period.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.period.model.ChemicalElement
import com.jeanbarrossilva.period.model.ChemicalElementAtomicNumber
import com.jeanbarrossilva.period.model.ChemicalElementName
import com.jeanbarrossilva.period.model.ChemicalElementSortingOption
import com.jeanbarrossilva.period.extensions.any.doIf
import com.jeanbarrossilva.period.extensions.any.instanceof
import com.jeanbarrossilva.period.ui.R

class ChemicalElementAdapter(private val sortingOption: ChemicalElementSortingOption<*>, private val onClick: (ChemicalElement) -> Unit):
    RecyclerView.Adapter<ChemicalElementAdapter.ChemicalElementViewHolder>(), Filterable {
    private var elements = sortingOption.getElements()

    inner class ChemicalElementViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val atomicNumberView = view.findViewById<TextView>(R.id.atomic_number_view)
        private val symbolView = view.findViewById<TextView>(R.id.symbol_view)
        private val nameView = view.findViewById<TextView>(R.id.name_view)
        private val additionalInfoView = view.findViewById<TextView>(R.id.additional_info_view)

        fun bind(element: ChemicalElement) {
            itemView.setOnClickListener {
                onClick(element)
            }
            atomicNumberView.text = "${element.atomicNumber.value}"
            symbolView.text = element.symbol.value
            nameView.text = element.name.value
            additionalInfoView.isVisible = !sortingOption.equivalent(element).instanceof(ChemicalElementName::class, ChemicalElementAtomicNumber::class)
            additionalInfoView.text = sortingOption.equivalent(element).representation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChemicalElementViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_chemical_element, parent, false)
        return ChemicalElementViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChemicalElementViewHolder, position: Int) = holder.bind(elements[position])

    override fun getItemCount() = elements.size

    override fun getFilter() = object: Filter() {
        override fun performFiltering(constraint: CharSequence?) = FilterResults().apply {
            constraint?.let {
                values = sortingOption.getElements().doIf(it.isNotBlank()) {
                    filterIndexed { _, element ->
                        it in element.name || it in element.symbol
                    }
                }
            }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            elements = (results?.values as? List<*>).orEmpty() as List<ChemicalElement>
            notifyDataSetChanged()
        }
    }
}