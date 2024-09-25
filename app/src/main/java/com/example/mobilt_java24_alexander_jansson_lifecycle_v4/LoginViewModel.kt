package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import androidx.lifecycle.ViewModel

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {


    suspend fun getUsers(): List<Users> {
        return userRepository.getUsers()
    }

    suspend fun checkAuth(username: String, password: String): MutableList<Users> {

        // hämta userinput från homepage
        val user = userRepository.getUser(username, password)
        return user
    }
}