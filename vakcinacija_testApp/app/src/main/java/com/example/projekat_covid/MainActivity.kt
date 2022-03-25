package com.example.projekat_covid

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.projekat_covid.databinding.ActivityMainBinding

const val KEY_TIMER_SECONDS = "timer_seconds_key"


class MainActivity : AppCompatActivity() {

    private lateinit var Timer : Timer
    var brojac =0


    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        val navController=this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
        Log.i("MainActivity","onCreateCalled")

        Timer = Timer(this.lifecycle)
        if (savedInstanceState != null) {
            Timer.secondsCount =
                    savedInstanceState.getInt(KEY_TIMER_SECONDS, 0)

        }

    }
    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
                .setText("Vakcinisem se! #VakcinisiSeIti #Imunizacija #StopPandemiji #SayNoToCoVid19")
                .setType("text/plain")
                .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, "Vakcinisem se! #VakcinisiSeIti #Imunizacija #StopPandemiji #SayNoToCoVid19",
                    Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareMenuButton -> onShare()
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("onSaveInstanceState","Onsavecalled")

        outState.putInt(KEY_TIMER_SECONDS, Timer.secondsCount)
    }

    @SuppressLint("LongLogTag")
    override fun onStart() {
        brojac++

        super.onStart()
        Log.i("MainActivity","onStartCalled")
        Log.i("MainActivity - brojac posjeta:", brojac.toString())


    }
    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","onResumeCalled")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","onPauseCalled")
    }

    @SuppressLint("LongLogTag")
    override fun onStop() {

        super.onStop()
        Log.i("MainActivity","onStopCalled")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","onDestroyCalled")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity","onRestartCalled")
    }

}