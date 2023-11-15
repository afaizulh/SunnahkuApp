package com.faizul.sunnahku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faizul.sunnahku.databinding.ItemView1Binding
import com.faizul.sunnahku.model.SunnahkuModel

class SunnahkuAdapter(private val listSunnahku: ArrayList<SunnahkuModel>):
    RecyclerView.Adapter<SunnahkuAdapter.MyViewHolder>() {
    class MyViewHolder(val binding : ItemView1Binding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val bindingSunnahku = ItemView1Binding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(bindingSunnahku)
    }

    override fun getItemCount(): Int = listSunnahku.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataDzikirDoa = listSunnahku[position]

        holder.binding.apply {
            tvDesc.text = dataDzikirDoa.desc
            tvLafaz.text = dataDzikirDoa.lafaz
            tvTerjemah.text = dataDzikirDoa.terjemah
        }
    }
}