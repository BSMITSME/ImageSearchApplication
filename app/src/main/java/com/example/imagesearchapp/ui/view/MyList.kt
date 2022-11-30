package com.example.imagesearchapp.ui.view

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.databinding.FragmentMyListBinding
import com.example.imagesearchapp.ui.adapter.ImageSearchAdapter
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
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

        lifecycleScope.launch {
            imageSearchViewModel.favoriteImage.collectLatest {
                imageSearchAdapter.submitList(it)
            }
        }

    }

    private fun setRecyclerView(){
        imageSearchAdapter = ImageSearchAdapter()
        binding.rvSearchResult.apply {
            setHasFixedSize(false)
            layoutManager = GridLayoutManager(this.context, 2)
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            adapter = imageSearchAdapter
        }

        imageSearchAdapter.setOnItemClickListener {
            val action = HomeSearchDirections.searchToImageview(it)
            findNavController().navigate(action)        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
