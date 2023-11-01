package com.example.tugasrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasrecyclerview.databinding.ActivityMainBinding

class PahlawanAdapter(private val listPahlawan: ArrayList<Pahlawan>):
    RecyclerView.Adapter<PahlawanAdapter.PahlawanViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class PahlawanViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        val gambarPahlawan: ImageView = itemView.findViewById(R.id.gambarPahlawan)
        val tvNamaPahlawan: TextView = itemView.findViewById(R.id.tvNamaPahlawan)
        val tvBioPahlawan: TextView = itemView.findViewById(R.id.tvBioPahlawan)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PahlawanViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_pahlawan, parent, false)

        return PahlawanViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return listPahlawan.size
    }

    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        val currentItem = listPahlawan[position]
        holder.gambarPahlawan.setImageResource(currentItem.gambarPahlawan)
        holder.tvNamaPahlawan.text = currentItem.namaPahlawan
        holder.tvBioPahlawan.text = currentItem.bioPahlawan

    }

}