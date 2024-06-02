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
            Location("Wieża Eiffla", "Symboliczna wieża Paryża", "Ikoniczna stalowa konstrukcja w Paryżu, zaprojektowana przez Gustave'a Eiffla i ukończona w 1889 roku. Ma 324 metry wysokości, jest symbolem Francji i przyciąga miliony turystów rocznie. Początkowo budziła kontrowersje, teraz jest uznawana za arcydzieło inżynierii.", "https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            Location("Statua Wolności", "Mały prezent od Francji dla Stanów Zjednoczonych.", "Dar Francji dla USA, zainaugurowana w 1886 roku na wyspie Liberty w Nowym Jorku. Reprezentuje wolność i demokrację. Stworzona przez Bartholdiego i Eiffla, ma 93 metry wysokości z cokołem. To jedno z najbardziej rozpoznawalnych symboli Stanów Zjednoczonych.", "https://images.unsplash.com/photo-1494449880320-18d3dae5d16e?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            Location("Koloseum", "Fajny amifteatr w Rzymie.", "Starożytny amfiteatr w Rzymie, ukończony w 80 roku n.e. przez cesarza Wespazjana. Mieścił około 50,000 widzów, organizowano w nim walki gladiatorów i inne widowiska. Jest symbolem potęgi Cesarstwa Rzymskiego i jednym z najlepiej zachowanych zabytków starożytności.", "https://images.unsplash.com/photo-1511163262182-1b04e5fa4caa?q=80&w=1973&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
        )

        viewManager = LinearLayoutManager(context)
        viewAdapter = LocationAdapter(locations) { location ->
            val bundle = Bundle().apply {
                putString("location_name", location.name)
                putString("location_description", location.description)
                putString("location_detailed_description", location.detailedDescription)
                putString("location_image_url", location.imageUrl)

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