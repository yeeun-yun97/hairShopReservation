package com.github.yeeun_yun97.toy.hairreservation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.yeeun_yun97.toy.hairreservation.R

class ReservationRecyclerAdapter : RecyclerView.Adapter<ReservationViewHolder>() {
    private var list = listOf<Pair<String, String>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_reservation, parent, false)
        return ReservationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        holder.setItem(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: List<Pair<String, String>>) {
        this.list = list
        this.notifyDataSetChanged()
    }


}

class ReservationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView = itemView.findViewById<TextView>(R.id.reservationNameTextView)
    private val contentTextView = itemView.findViewById<TextView>(R.id.reservationContentTextView)

    fun setItem(pair: Pair<String, String>) {
        nameTextView.setText(pair.first)
        contentTextView.setText(pair.second)
    }


}