package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {

    private val db = Firebase.firestore
        suspend fun getUsers() {
            return withContext(Dispatchers.IO){
                val usersCollection = db.collection("users")
                // testing
                usersCollection.get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            val username = document.getString("username")
                            val password = document.getString("password")

                            Log.d("Firestore working with coroutines!!!!", "Username: $username, Password: $password")
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.w("Firestore", "Error getting documents: ", exception)
                    }
            }

    }

}