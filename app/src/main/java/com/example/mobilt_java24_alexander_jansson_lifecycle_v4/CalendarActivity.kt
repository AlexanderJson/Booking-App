package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker

class CalendarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val text = findViewById<TextView>(R.id.testview)
        val changeAvailableBtn = findViewById<Button>(R.id.changeAvailableBtn)
        val setAvailableBtn = findViewById<Button>(R.id.setAvailableBtn)

        setAvailableBtn.setOnClickListener(View.OnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager, "DATE_PICKER")
            datePicker.addOnPositiveButtonClickListener {
                text.text = datePicker.headerText
                }
            }
        )
    }
}