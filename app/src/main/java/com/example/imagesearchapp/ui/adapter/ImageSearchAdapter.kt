package com.example.imagesearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.databinding.ItemImageBinding
import com.example.imagesearchapp.databinding.ItemImageLikedBinding

class ImageSearchAdapter(var type : Boolean) : ListAdapter<Document, RecyclerView.ViewHolder>(ImageDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(type){
            ImageSearchViewHolder(
                ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            )
        }else{
            ImageMyListViewHolder(
                ItemImageLikedBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val image = currentList[position]
        if(type){
            (holder as ImageSearchViewHolder).bind(image)
            (holder as ImageSearchViewHolder).itemView.setOnClickListener {
                onItemClickListener?.let { it(image) }
            }
        }else{
            (holder as ImageMyListViewHolder).bind(image)
        }
    }

    private var onItemClickListener : ((Document) -> Unit)? = null
    fun setOnItemClickListener(listener : (Document) -> Unit){
        onItemClickListener = listener
    }

    inner class ImageSearchViewHolder (
        private val binding : ItemImageBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(document : Document) {
            itemView.apply {
                binding.imgItem.load(document.imageUrl)
            }
        }
    }
    inner class ImageMyListViewHolder(
        private val binding : ItemImageLikedBinding
    ) :RecyclerView.ViewHolder(binding.root){
        fun bind(document: Document){
            itemView.apply {
                binding.imgItem.load(document.imageUrl)
            }
        }
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
