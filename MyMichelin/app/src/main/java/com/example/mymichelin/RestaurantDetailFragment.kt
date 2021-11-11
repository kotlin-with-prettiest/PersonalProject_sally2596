package com.example.mymichelin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.mymichelin.databinding.FragmentRestaurantDetailBinding

class RestaurantDetailFragment : Fragment() {
    private var _binding: FragmentRestaurantDetailBinding? = null
    private val binding get() = _binding!!

    private val navigationArgs: RestaurantDetailFragmentArgs by navArgs()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.restName.text = navigationArgs.restaurantname

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}