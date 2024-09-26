package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch


class HomepageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.textView2)
        val bottomNavbar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavbar.setOnItemSelectedListener{ item ->
            when (item.itemId){
                R.id.nav_home -> {
                    val intent = Intent(this, HomepageActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_schedule -> {
                    val intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> {
                    false
                }
            }


        }

        //val calendarBtn = findViewById<Button>(R.id.calendarBtn)

        /*
        calendarBtn.setOnClickListener(View.OnClickListener {
            intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        })





            when (item.itemId){
                R.id.nav_home -> {
                    intent = Intent(this, HomepageActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_schedule -> {
                    intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_profile -> {
                    intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
            }


        */
}}

