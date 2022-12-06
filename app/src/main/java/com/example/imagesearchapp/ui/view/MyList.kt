package com.example.imagesearchapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentMyListBinding
import com.example.imagesearchapp.ui.adapter.ImageSearchAdapter
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MyList : Fragment(){
    private var _binding : FragmentMyListBinding ?= null
    private val binding get()= _binding!!
    private lateinit var imageSearchAdapter : ImageSearchAdapter
    private lateinit var imageSearchViewModel: ImageSearchViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        imageSearchViewModel = (activity as MainActivity).imageSearchViewModel
        setupTouchHelper(view)
        lifecycleScope.launch {
            imageSearchViewModel.favoriteImage.collectLatest {
               imageSearchAdapter.submitList(it)
            }
        }
    }
    private fun setRecyclerView(){
        imageSearchAdapter = ImageSearchAdapter(false)
        binding.rvSearchResult.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this.context)
            adapter = imageSearchAdapter
        }
        imageSearchAdapter.setOnItemClickListener {
            val action = MyListDirections.actionMyListToListSelected(it)
            findNavController().navigate(action)
        }
    }
    private fun setupTouchHelper(view : View) {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val image = imageSearchAdapter.currentList[position]
                imageSearchViewModel.deleteImage(image)
                Snackbar.make(view, "Book has deleted", Snackbar.LENGTH_SHORT).apply {
                    setAction("Undo") {
                        imageSearchViewModel.saveImage(image)
                    }
                }.show()
            }
        }
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rvSearchResult)
        }
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
