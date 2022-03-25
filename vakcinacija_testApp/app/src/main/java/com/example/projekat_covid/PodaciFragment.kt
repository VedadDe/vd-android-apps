package com.example.projekat_covid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.projekat_covid.databinding.FragmentPodaciBinding


class PodaciFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPodaciBinding>(inflater,
                R.layout.fragment_podaci,container,false)
        binding.idButtonDalje.setOnClickListener{
            val ime=binding.idEditIme.text.toString()
            val prezime=binding.idEditPrezime.text.toString()
            val mjesto=binding.idEditGrad.text.toString()
            var kriticnaKategorija=false
            if(binding.idCheckBoxHronicniBolesnik.isChecked)
                kriticnaKategorija=true
            else if(binding.idCheckBoxZdravstveniRadnik.isChecked)
                kriticnaKategorija=true
            else if(binding.idCheckBoxStarackiDom.isChecked)
                kriticnaKategorija=true

            it.findNavController().navigate(PodaciFragmentDirections.actionPodaciFragmentToVakcineFragment(ime,prezime,mjesto,kriticnaKategorija))
        }
        return binding.root
    }


}