package com.example.projekat_covid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.projekat_covid.databinding.FragmentVakcineBinding


class VakcineFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args=VakcineFragmentArgs.fromBundle(requireArguments())
        val ime=args.ime
        val prezime=args.prezime
        val mjesto=args.mjesto
        val kriticnaKategorija=args.kriticnaKategorija
        //Toast.makeText(context,"Ime ${args.ime}, prezime ${args.prezime}",Toast.LENGTH_LONG).show()
        val binding = DataBindingUtil.inflate<FragmentVakcineBinding>(inflater,
            R.layout.fragment_vakcine,container,false)
        var vakcina=""
        binding.idButtonVakcineDalje.setOnClickListener{
            if(binding.idRadioAstraZeneca.isChecked) {
                vakcina=binding.idRadioAstraZeneca.text.toString()
                Log.i("MainActivity", "AstraZenece checked")
            }
            else if(binding.idRadioPfizer.isChecked){
                vakcina=binding.idRadioPfizer.text.toString()

            }
            else if(binding.idRadioJansen.isChecked){
                vakcina=binding.idRadioJansen.text.toString()

            }
            else if(binding.idRadioModerna.isChecked){
                vakcina=binding.idRadioModerna.text.toString()

            }
            else if(binding.idRadioSinopharm.isChecked){
                vakcina=binding.idRadioSinopharm.text.toString()

            }

            it.findNavController().navigate(VakcineFragmentDirections.actionVakcineFragmentToSazetakFragment(ime,prezime,mjesto,vakcina,kriticnaKategorija))
        }


        return binding.root
    }


}