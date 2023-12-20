package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InstructorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructorFragment : Fragment() {
    lateinit var binding: FragmentInstructorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructorBinding.inflate(layoutInflater)
        binding.btnGtls.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(InstructorFragmentDirections.actionInstructorFragmentToListShoeFragment())
        }
        return binding.root
    }

}