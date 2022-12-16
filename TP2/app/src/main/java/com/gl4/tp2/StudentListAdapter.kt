package com.gl4.tp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class StudentListAdapter(private val data: ArrayList<Etudiant>) :
    RecyclerView.Adapter<StudentListAdapter.ViewHolder>(), Filterable {

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val textView: TextView
            val imageView: ImageView
            val checkBox: CheckBox
            init {
                textView = itemView.findViewById(R.id.textView)
                imageView = itemView.findViewById(R.id.imageView)
                checkBox = itemView.findViewById(R.id.checkBox)
            }


        }
    override fun  onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentListAdapter.ViewHolder, position: Int) {
        var item = data[position]
        holder.textView.text =  "${item.nom} ${item.prenom}"

        if (item.genre == Genre.MALE)
           holder.imageView.setImageResource(R.drawable.man)
        else
            holder.imageView.setImageResource(R.drawable.woman)

        holder.checkBox.isChecked = item.present

        holder.checkBox.setOnCheckedChangeListener {_, isChecked ->
            if (item.present != isChecked) {
                item.present = isChecked
            }
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }


    var dataFilterList = ArrayList<Etudiant>()
    init {
        // associer le tableau des données initiales
        dataFilterList = data
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    dataFilterList = data
                } else {
                    val resultList = ArrayList<Etudiant>()
                    for (student in data) {
                        if (student.nom?.lowercase(Locale.ROOT)
                                ?.contains(charSearch.lowercase(Locale.ROOT)) == true
                        ) {
                            resultList.add(student)
                        }
                    }
                    dataFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = dataFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                dataFilterList = results?.values as ArrayList<Etudiant>
                notifyDataSetChanged()
            }

        }
    }



}
