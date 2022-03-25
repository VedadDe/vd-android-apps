package com.example.projekat_covid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.projekat_covid.databinding.FragmentProvjeraBinding


class ProvjeraFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentProvjeraBinding>(inflater,
            R.layout.fragment_provjera,container,false)
        binding.idButtonProvjeraDalje.setOnClickListener{
            it.findNavController().navigate(R.id.action_provjeraFragment_to_podaciFragment)
        }

        binding.idButtonProvjeraKraj.setOnClickListener{
            it.findNavController().navigate(R.id.action_provjeraFragment_to_krajFragment)
        }
        return binding.root
    }


}