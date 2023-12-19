package com.example.taandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MateriAdapter(val dataMateri: List<DataItem?>?) : RecyclerView.Adapter<MateriAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val isi = view.findViewById<TextView>(R.id.isi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.isi, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataMateri != null){
            return dataMateri.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.isi.text = dataMateri?.get(position)?.isi

        holder.itemView.setOnClickListener{
            val nama = dataMateri?.get(position)?.isi
            Toast.makeText(holder.itemView.context, "${nama}", Toast.LENGTH_SHORT).show()
        }
    }
}