package com.example.moptu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class LocationDetail : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_location_detail, container, false)
        val nameTextView: TextView = view.findViewById(R.id.textViewLocationName)
        val descriptionTextView: TextView = view.findViewById(R.id.textViewLocationDescription)
        val detailedDescriptionTextView: TextView = view.findViewById(R.id.textViewDetailedDescription)
        val imageView: ImageView = view.findViewById(R.id.imageViewLocation)



        arguments?.let {
            nameTextView.text = it.getString("location_name")
            descriptionTextView.text = it.getString("location_description")
            detailedDescriptionTextView.text = it.getString("location_detailed_description")
            val imageUrl = it.getString("location_image_url")
            Picasso.get().load(imageUrl).into(imageView)
        }

        return view
    }
}