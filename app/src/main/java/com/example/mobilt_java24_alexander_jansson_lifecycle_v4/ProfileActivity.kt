package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val text = findViewById<TextView>(R.id.textView2)

    }}