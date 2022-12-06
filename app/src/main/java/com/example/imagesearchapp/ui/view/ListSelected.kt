package com.example.imagesearchapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentListSelectedBinding
import com.example.imagesearchapp.databinding.FragmentMyListBinding
import com.example.imagesearchapp.ui.adapter.ImageSearchAdapter
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import okhttp3.internal.wait
import java.lang.Thread.sleep

class ListSelected : Fragment(){
    private var _binding : FragmentListSelectedBinding? = null
    private val binding get() = _binding!!

    private lateinit var imageSearchViewModel: ImageSearchViewModel
    private lateinit var imageSearchAdapter: ImageSearchAdapter
    private val args by navArgs<ListSelectedArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListSelectedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSearchViewModel = (activity as MainActivity).imageSearchViewModel
        imageSearchAdapter = ImageSearchAdapter(false)
        binding.imageView.load(args.image.imageUrl)

        binding.floatingDelete.setOnClickListener {
            imageSearchViewModel.deleteImage(args.image)
            Snackbar.make(view,"Delete Completed",Snackbar.LENGTH_SHORT).show()
            sleep(500)
            findNavController().navigate(R.id.myList)
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
