package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentWellcomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [WellcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WellcomeFragment : Fragment() {
    lateinit var binding: FragmentWellcomeBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWellcomeBinding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener { v ->
            v.findNavController()
                .navigate(WellcomeFragmentDirections.actionWellcomeFragmentToInstructorFragment())
        }
        return binding.root
    }

}