package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {

    object initFirebase{
        val firestoreInstance: FirebaseFirestore by lazy {
            FirebaseFirestore.getInstance()
        }
    }

        suspend fun getUsers(): MutableList<Users> {
            return withContext(Dispatchers.IO){
                val db = initFirebase.firestoreInstance
                val usersCollection = db.collection("users")
                val users = mutableListOf<Users>()
                // testing
                usersCollection.get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            val username = document.getString("username") ?: "Guest"
                            val password = document.getString("password") ?: ""
                            val user = Users(username, password)
                            users.add(user)
                            Log.d("FIREBASEdsdskkjlsdZ", "Username: $username, Password: $password")
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.w("Firestore", "Error getting documents: ", exception)
                    }
                users
            }

    }

}