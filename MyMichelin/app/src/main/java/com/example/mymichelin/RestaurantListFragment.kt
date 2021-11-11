package com.example.mymichelin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymichelin.adapter.RestaurantAdapter
import com.example.mymichelin.data.Datasource
import com.example.mymichelin.databinding.FragmentRestaurantListBinding

class RestaurantListFragment: Fragment()  {
    private var _binding: FragmentRestaurantListBinding? = null
    private val binding get() = _binding!! /** d**/

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        val myDataset = Datasource().loadRestaurant()
        recyclerView.adapter = RestaurantAdapter(requireContext(),myDataset)
        recyclerView.setHasFixedSize(true)

        binding.floatingActionButton.setOnClickListener{
            val action = RestaurantListFragmentDirections.actionRestaurantListFragmentToRestaurantAddFragment()
            this.findNavController().navigate(action)
        }

    }
}