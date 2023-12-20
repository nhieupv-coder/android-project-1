package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel


class ShoeDetailFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailBinding
    private val shoesViewModel: ShoeViewModel by activityViewModels()
    private val shoeData = Shoe("", 0.0, "", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        binding.btnCancel.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToListShoeFragment())
        }
        binding.btnCreate.setOnClickListener { v: View ->
            run {
                createNewShoe()
                v.findNavController()
                    .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToListShoeFragment())
            }
        }
        binding.shoeData = shoeData
        binding.lifecycleOwner = this
        return binding.root
    }

    private fun createNewShoe() {
        val shoe = Shoe(
            binding.inpName.text.toString(),
            binding.inpSize.text.toString().toDouble(),
            binding.inpCompany.text.toString(),
            binding.inpDescription.text.toString()
        )
        shoesViewModel.addNewShow(shoe)
    }

}