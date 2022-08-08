package com.github.yeeun_yun97.toy.hairreservation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.yeeun_yun97.toy.hairreservation.R

class PriceRecyclerAdapter : RecyclerView.Adapter<PriceViewHolder>() {
    private var list = listOf<Pair<String, String>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_selected_service, parent, false)
        return PriceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PriceViewHolder, position: Int) =
        holder.setItem(list[position])

    override fun getItemCount(): Int = list.size

    fun setList(list: List<Pair<String, String>>) {
        this.list = list
        this.notifyDataSetChanged()
    }


}

class PriceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setItem(pair: Pair<String, String>) {
        val nameTextView = itemView.findViewById<TextView>(R.id.serviceNameTextView)
        val contentTextView = itemView.findViewById<TextView>(R.id.servicePriceTextView)
        nameTextView.setText(pair.first)
        contentTextView.setText(pair.second)
    }
}