package com.example.moptu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class LocationDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_location_detail, container, false)
        val nameTextView: TextView = view.findViewById(R.id.textViewLocationName)
        val descriptionTextView: TextView = view.findViewById(R.id.textViewLocationDescription)

        arguments?.let {
            nameTextView.text = it.getString("location_name")
            descriptionTextView.text = it.getString("location_description")
        }

        return view
    }
}
