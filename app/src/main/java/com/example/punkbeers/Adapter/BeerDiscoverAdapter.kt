package com.example.punkbeers.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.punkbeers.R
import com.example.punkbeers.api.models.Beer
import com.example.punkbeers.databinding.ListItemBinding


class BeerDiscoverAdapter(val onBeerClicked: (id: Int) -> Unit) :
    ListAdapter<Beer, BeerDiscoverAdapter.BeerViewHolder>(
        object : DiffUtil.ItemCallback<Beer>() {
            override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
                return oldItem.toString() == newItem.toString()
            }
        }
    ) {

    inner class BeerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {

        return BeerViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        ListItemBinding.bind(holder.itemView).apply {
            val beer = getItem(position)
            beerName.text = beer.name
            beerAbv.text = "ABV: ${beer.abv.toString()}"
            Glide.with(holder.itemView).load(beer.imageUrl).into(ivBeer)

            root.setOnClickListener { onBeerClicked(beer.id) }

        }
    }

}