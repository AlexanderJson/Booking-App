package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomepageViewModel(private val userRepository: UserRepository) : ViewModel(){


    private fun getUsers(){
        viewModelScope.launch {
            val users = userRepository.getUsers()
        }
    }

    fun checkUser(username: String, password: String){
        viewModelScope.launch {
            val user = getUsers()


        }
    }
}
