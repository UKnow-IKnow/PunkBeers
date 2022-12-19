package com.example.punkbeers.ui.BeerDiscover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.punkbeers.Adapter.BeerDiscoverAdapter
import com.example.punkbeers.R
import com.example.punkbeers.databinding.FragmentDiscoverBinding

class BeerDiscoverFragment : Fragment() {

    private var binding: FragmentDiscoverBinding? = null
    private lateinit var viewModel: BeerDiscoverViewModel
    private lateinit var beerAdapter: BeerDiscoverAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(BeerDiscoverViewModel::class.java)
        beerAdapter = BeerDiscoverAdapter { openBeerDetails(it) }

        binding = FragmentDiscoverBinding.inflate(inflater, container, false)
        binding?.rvDiscover?.layoutManager = LinearLayoutManager(context)
        binding?.rvDiscover?.adapter = beerAdapter

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title =
            resources.getString(R.string.app_name)


        viewModel.makeAPICall()

        viewModel.discoverBeer.observe({ lifecycle }) {
            beerAdapter.submitList(it)
        }

    }

    fun openBeerDetails(beerId: Int) {
        findNavController().navigate(
            R.id.action_discoverBeerFragment_to_beerDetailsFragment,
            bundleOf(
                resources.getString(R.string.arg_beer_id) to beerId
            )

        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}