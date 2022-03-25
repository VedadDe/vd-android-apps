package com.example.projekat_covid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.projekat_covid.databinding.FragmentOAplikacijiBinding
import com.example.projekat_covid.databinding.FragmentPodaciBinding

class OAplikacijiFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentOAplikacijiBinding>(inflater,
            R.layout.fragment_o_aplikaciji,container,false)
        return binding.root
    }


}