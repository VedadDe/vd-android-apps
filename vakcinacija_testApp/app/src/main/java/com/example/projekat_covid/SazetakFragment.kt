package com.example.projekat_covid

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.projekat_covid.databinding.FragmentSazetakBinding
import java.text.SimpleDateFormat
import java.util.*


class SazetakFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args=SazetakFragmentArgs.fromBundle(requireArguments())
        val binding = DataBindingUtil.inflate<FragmentSazetakBinding>(inflater,
            R.layout.fragment_sazetak,container,false)
        val ime_prezime=args.ime +" "+ args.prezime
        val kriticnaKategorija=args.kriticnaKategorija
        binding.idEditImeIPrezime.setText(ime_prezime)
        binding.idEditMjestoVakcinisanja.setText(args.mjesto)
        binding.idEditVakcina.setText(args.vakcina)
        var datum=napraviDatum(kriticnaKategorija)
        binding.idEditDatum.setText(datum)

        return binding.root
    }

    private fun napraviDatum(kriticnaSkupina : Boolean): String {

        var slucajniBroj = (10..30).random()
        if(kriticnaSkupina)
            slucajniBroj=(1..10).random()
        var dan = SimpleDateFormat("d")
        var trenutniDan = dan.format(Date())
        var mjesec = SimpleDateFormat("MM")
        var trenutniMjesec = mjesec.format(Date())
        var godina = SimpleDateFormat("YYYY")
        var trenutniGodina = godina.format(Date())
        var noviDan=trenutniDan.toInt()+slucajniBroj
        var noviMjesec=noviDan.div(30) + trenutniMjesec.toInt()
        noviDan=noviDan.rem(30)
        var novaGodina=trenutniGodina.toInt()+noviMjesec.div(12)
        var vrati="$noviDan/$noviMjesec/$novaGodina"

        return  vrati

    }


    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, "#VAKCINISAOSE #VAKSINISALASE #VakcinisiSeIti")
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
    }
    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}