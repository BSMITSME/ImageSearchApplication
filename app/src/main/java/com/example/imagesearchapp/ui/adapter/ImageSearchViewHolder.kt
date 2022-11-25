package com.example.imagesearchapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.databinding.ItemImageBinding

class ImageSearchViewHolder (
    private val binding : ItemImageBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(document : Document) {
        itemView.apply {

            binding.imgItem.load(document.imageUrl)

        }
    }
}