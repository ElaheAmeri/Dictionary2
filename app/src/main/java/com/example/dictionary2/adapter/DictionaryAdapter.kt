package com.example.dictionary2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary2.R
import com.example.dictionary2.dataBase.Word

class DictionaryAdapter(var dataSet: List<String>) :RecyclerView.Adapter<DictionaryAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var textView: TextView
        init {

            textView = view.findViewById(R.id.rvShowWord)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_show_word, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position]
    }
    override fun getItemCount() = dataSet.size

}