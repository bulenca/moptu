package com.example.moptu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LocationAdapter(
    private val locations: List<Location>,
    private val onItemClick: (Location) -> Unit
) : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    class LocationViewHolder(view: View, val onItemClick: (Location) -> Unit) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.locationName)
        val descriptionTextView: TextView = view.findViewById(R.id.locationDescription)

        private var currentLocation: Location? = null

        init {
            view.setOnClickListener {
                currentLocation?.let {
                    onItemClick(it)
                }
            }
        }

        fun bind(location: Location) {
            currentLocation = location
            nameTextView.text = location.name
            descriptionTextView.text = location.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_location, parent, false)
        return LocationViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(locations[position])
    }

    override fun getItemCount() = locations.size
}