package com.example.projekat_covid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.projekat_covid.databinding.FragmentKrajBinding



class KrajFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentKrajBinding>(inflater,
            R.layout.fragment_kraj,container,false)
        binding.idButtonNazad.setOnClickListener{
             it.findNavController().navigate(KrajFragmentDirections.actionKrajFragmentToProvjeraFragment())
        }
        return binding.root
    }


}