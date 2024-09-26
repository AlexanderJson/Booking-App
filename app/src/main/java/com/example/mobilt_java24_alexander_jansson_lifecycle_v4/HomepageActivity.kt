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
import kotlinx.coroutines.launch

class HomepageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.textView2)

        //val calendarBtn = findViewById<Button>(R.id.calendarBtn)

        /*
        calendarBtn.setOnClickListener(View.OnClickListener {
            intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        })*/
}}

