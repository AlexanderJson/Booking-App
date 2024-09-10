package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usersCollection = db.collection("users")
        // testing
        usersCollection.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val username = document.getString("username")
                    val password = document.getString("password")

                    Log.d("Firestore", "Username: $username, Password: $password")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Firestore", "Error getting documents: ", exception)
            }
    }
}