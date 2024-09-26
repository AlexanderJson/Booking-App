package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker

class CalendarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        setupBtmNavbar()

        val setAvailableBtn = findViewById<Button>(R.id.setAvailableBtn)
        // lägg till floating button för lägga till

        //metod
        setAvailableBtn.setOnClickListener(View.OnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager, "DATE_PICKER")
            datePicker.addOnPositiveButtonClickListener {
                }
            }
        )
    }
}