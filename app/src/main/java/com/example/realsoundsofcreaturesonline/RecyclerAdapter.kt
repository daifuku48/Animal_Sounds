package com.example.realsoundsofcreaturesonline

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var dataset: ArrayList<Animal>, val context1: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var mListener : setOnItemClickListener

    interface setOnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: setOnItemClickListener){
        mListener = listener
    }

    class ViewHolder(itemView: View, listener: setOnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val image: ImageView
        init {
            // Define click listener for the ViewHolder's View
            name = itemView.findViewById(R.id.animalNameTextView)
            image = itemView.findViewById(R.id.imageAnimalView)
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)

        return ViewHolder(view, mListener)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = dataset[position].name
        holder.image.setImageResource(dataset[position].image)
    }
}