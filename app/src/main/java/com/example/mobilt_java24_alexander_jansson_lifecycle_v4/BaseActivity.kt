package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

open class BaseActivity : AppCompatActivity() {
        fun setupBtmNavbar(){
            val bottomNavbar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            bottomNavbar.setOnItemSelectedListener{ item ->
                when (item.itemId){
                    R.id.nav_home -> {
                        val intent = Intent(this, HomepageActivity::class.java)
                        startActivity(intent)
                        finish()
                        true
                    }
                    R.id.nav_profile -> {
                        val intent = Intent(this, ProfileActivity::class.java)
                        startActivity(intent)
                        finish()
                        true
                    }
                    R.id.nav_schedule -> {
                        val intent = Intent(this, CalendarActivity::class.java)
                        startActivity(intent)
                        finish()
                        true
                    }
                    R.id.nav_logout -> {
                        val intent = Intent(this, LoginActivity::class.java)
                        // gör någon smart invalidation, kanske automatiskt på något sätt?
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        finish()
                        true
                    }
                    else -> {
                        false
                    }
                }


            }
        }

    }
