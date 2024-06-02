package com.example.moptu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: LocationAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val locations = listOf(
            Location("Wieża Eiffla", "Symboliczna wieża Paryża"),
            Location("Statua Wolności", "Mały prezent od Francji dla Stanów Zjednoczonych."),
            Location("Koloseum", "Fajny amifteatr w Rzymie."),
        )

        viewManager = LinearLayoutManager(context)
        viewAdapter = LocationAdapter(locations) { location ->
            val bundle = Bundle().apply {
                putString("location_name", location.name)
                putString("location_description", location.description)
                putString("location_detailed_description", "coś")
            }
            val fragment = LocationDetail().apply {
                arguments = bundle
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return view
    }
}