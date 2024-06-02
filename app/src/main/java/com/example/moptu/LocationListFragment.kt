package com.example.moptu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class LocationListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_location_list, container, false)
        val button: Button = view.findViewById(R.id.buttonShowDetail)
        button.setOnClickListener {
            val bundle = Bundle().apply {
                putString("location_name", "Example Location")
                putString("location_description", "This is an example location description.")
            }
            val fragment = LocationDetailFragment().apply {
                arguments = bundle
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
        return view
    }
}