package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentListShoeBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel


class ListShoeFragment : Fragment() {
    lateinit var binding: FragmentListShoeBinding
    private val shoesViewModel: ShoeViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_shoe,
            container,
            false
        )
        binding.fab.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ListShoeFragmentDirections.actionListShoeFragmentToShoeDetailFragment())
        }
        shoesViewModel.shoeList.observe(viewLifecycleOwner) { data ->
            addToLayout(data)
        }
        binding.lifecycleOwner = requireActivity()
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        findNavController()
                            .navigate(ListShoeFragmentDirections.actionListShoeFragmentToLoginFragment())
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }

    fun addToLayout(shoes: List<Shoe>) {
        binding.list.removeAllViews()
        for (e in shoes) {
            val shoeItemBinding = ShoeItemBinding.inflate(layoutInflater)
            shoeItemBinding.shoeItem = e
            shoeItemBinding.size.text = e.getSize()
            binding.list.addView(shoeItemBinding.root)
        }
    }
}