package com.example.imagesearchapp.ui.view

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.databinding.FragmentHomeSearchBinding
import com.example.imagesearchapp.ui.adapter.ImageSearchAdapter
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel


class HomeSearch : Fragment(){
    private var _binding : FragmentHomeSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var imageSearchViewModel: ImageSearchViewModel
    private lateinit var imageSearchAdapter: ImageSearchAdapter
    private lateinit var mainActivity: MainActivity
    private lateinit var setOnClear : ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeSearchBinding.inflate(inflater, container, false)
        setOnClear = binding.searchBoxContainer.clearSearchQuery
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = activity as MainActivity
        imageSearchViewModel = (activity as MainActivity).imageSearchViewModel
        setRecyclerView()
        searchBooks()

        imageSearchViewModel.searchResult.observe(viewLifecycleOwner){
            val images = it.documents
            imageSearchAdapter.submitList(images)
        }
        showHide(setOnClear)
        mainActivity.hideBottomNavigation(true)

    }
    private fun setRecyclerView(){
        imageSearchAdapter = ImageSearchAdapter(true)
        binding.rvSearchResult.apply {
            setHasFixedSize(false)
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = imageSearchAdapter
        }
        imageSearchAdapter.setOnItemClickListener {
            val action = HomeSearchDirections.searchToImageview(it)
            findNavController().navigate(action)
        }
    }

    private fun searchBooks(){
        var startTime = System.currentTimeMillis()
        var endTime : Long

        binding.searchBoxContainer.searchEditText.addTextChangedListener {
            text : Editable? ->
            endTime = System.currentTimeMillis()
            if(endTime - startTime >= 100L){
                text?.let {
                    val query = it.toString().trim()
                    if(query.isNotEmpty()){
                        imageSearchViewModel.searchImage(query)
                    }
                }
            }
            startTime = endTime
        }

    }
    fun showHide(view:View) {
        view.visibility = if (view.visibility == View.VISIBLE){
            View.INVISIBLE
        } else{
            View.VISIBLE
        }
    }
    override fun onDestroy() {
        _binding =null
        mainActivity.hideBottomNavigation(false)
        super.onDestroy()
    }
}