package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupBtmNavbar()


        /*
        // ÅTERANVÄBD METODEN - frag eller annan klass ? kolla skillnad på arv och instans igen
        val editProfileBtn = findViewById<Button>(R.id.editProfileBtn)


        fun showRegisterDialog(){
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)
            val builder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(true)
            val dialog = builder.create()
            dialog.show()
        }

        //register
        editProfileBtn.setOnClickListener(){
            showRegisterDialog()
        }*/

    }}