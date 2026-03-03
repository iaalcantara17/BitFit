package com.example.bitfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HealthAdapter(private val entries: MutableList<HealthEntry>) :
    RecyclerView.Adapter<HealthAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        val notesTextView: TextView = view.findViewById(R.id.notesTextView)
        val sleepValueTextView: TextView = view.findViewById(R.id.sleepValueTextView)
        val feelingValueTextView: TextView = view.findViewById(R.id.feelingValueTextView)
        val itemPhoto: ImageView = view.findViewById(R.id.itemPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_health, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = entries[position]
        holder.dateTextView.text = entry.date
        holder.notesTextView.text = entry.notes
        holder.sleepValueTextView.text = "Slept ${entry.sleepHours} hours"
        holder.feelingValueTextView.text = "Feeling ${entry.feeling}/10"

        if (entry.photoPath != null) {
            holder.itemPhoto.visibility = View.VISIBLE
            Glide.with(holder.itemView.context)
                .load(entry.photoPath)
                .into(holder.itemPhoto)
        } else {
            holder.itemPhoto.visibility = View.GONE
        }
    }

    override fun getItemCount() = entries.size

    fun updateEntries(newEntries: List<HealthEntry>) {
        entries.clear()
        entries.addAll(newEntries)
        notifyDataSetChanged()
    }
}
