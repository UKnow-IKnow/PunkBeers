package com.example.punkbeers.ui.BeerDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.punkbeers.R
import com.example.punkbeers.databinding.FragmentBeerDetailsBinding
import com.example.punkbeers.extensions.loadImage

class BeerDetailsFragment : Fragment() {

    private var binding: FragmentBeerDetailsBinding? = null
    lateinit var detailsViewModel: BeerDetailsViewModel

    private var beerId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailsViewModel = ViewModelProvider(this).get(BeerDetailsViewModel::class.java)

        binding = FragmentBeerDetailsBinding.inflate(inflater, container, false)

        arguments?.let {
            beerId = it.getInt(resources.getString(R.string.arg_beer_id))
        }

        beerId?.let {
            detailsViewModel.fetchBeerDetails(it)
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsViewModel.beer.observe({ lifecycle }) {
            binding?.apply {
                (activity as AppCompatActivity).supportActionBar?.title = "${it.name}"

                beerImage.loadImage(it.imageUrl)
                beerName.text = it.name
                beerAbv.text = " ABV: ${it.abv.toString()}"
                beerDescp.text = it.description


                val foodPairings = it.foodPairing.joinToString {
                    it
                }

                beerFoodPairing.text = foodPairings


            }
        }
    }
}