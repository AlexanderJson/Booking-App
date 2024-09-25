package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //TODO("Databind, läs mer?")
        val userRepository = UserRepository()
        val loginViewModel = LoginViewModel(userRepository)
        val usernameField = findViewById<EditText>(R.id.username_input)
        val passwordField = findViewById<EditText>(R.id.password_input)
        val loginBtn = findViewById<Button>(R.id.login_button)


        loginBtn.setOnClickListener(){
                val usernameInput = usernameField.text.toString()
                val passwordInput = passwordField.text.toString()
                val intent = Intent(this, HomepageActivity::class.java)

            lifecycleScope.launch {
                    val user = loginViewModel.checkAuth(usernameInput,passwordInput)
                    if (user.isNotEmpty()){
                        Log.e("WOW", "Found$user")
                        startActivity(intent)
                    } else {
                        Log.e("WOW", "Could not find")
                        //skakande reg knapp
                    }

                }
            }
        }



    }




/*
*      lifecycleScope.launch {
            val allUsers = homepageViewModel.getUsers()

            Log.d("LoginActivity", "Total users: ${allUsers.size}")
            for (user in allUsers) {
                Log.d("LoginActivity", "Username: ${user.username}, Password: ${user.password}")
            }
        }

        loginBtn.setOnClickListener(){
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()
            lifecycleScope.launch {
                homepageViewModel.checkAuth(username,password)
            }
        }
        lifecycleScope.launch {
            userRepository.getUsers()
            homepageViewModel.getUsers()
            val usernameValue = usernameField.text.toString()
            Log.d("LoginActivity", "Login button clicked")
        }

* */