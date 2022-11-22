package com.example.imagesearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.databinding.ItemImageBinding

class ImageSearchAdapter : ListAdapter<Document, ImageSearchViewHolder>(ImageDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchViewHolder {
        return ImageSearchViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        val image = currentList[position]
        holder.bind(image)
    }

    companion object {
        private val ImageDiffCallback = object : DiffUtil.ItemCallback<Document>(){
            override fun areItemsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem.docUrl == newItem.docUrl
            }

            override fun areContentsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem == newItem
            }

        }
    }
}