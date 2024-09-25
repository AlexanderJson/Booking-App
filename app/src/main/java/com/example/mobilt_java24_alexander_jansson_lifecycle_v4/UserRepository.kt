package com.example.mobilt_java24_alexander_jansson_lifecycle_v4

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class UserRepository {

    private val firestoreInstance: FirebaseFirestore = FirebaseFirestore.getInstance()

    suspend fun getUsers(): MutableList<Users> = withContext(Dispatchers.IO) {
        val usersCollection = firestoreInstance.collection("users")
        val users = mutableListOf<Users>()

        try {
            val result = usersCollection.get().await()
            for (document in result) {
                val username = document.getString("username") ?: ""
                val password = document.getString("password") ?: ""
                val user = Users(username, password)
                Log.w("Firestore", "Usernames: $username   Password: $password")
                users.add(user)
            }
        } catch (exception: Exception) {
            Log.w("Firestore", "Error fetching users", exception)
        }

        users
    }

    // Use this to fetch a single user, for login, etc.
    suspend fun getUser(username: String, password: String): MutableList<Users> = withContext(Dispatchers.IO) {
        val oneUserList = mutableListOf<Users>()
        val usersCollection = firestoreInstance.collection("users")
            .whereEqualTo("username", username)
            .whereEqualTo("password", password)

        try {
            val result = usersCollection.get().await()
            for (document in result.documents) {
                val retrievedUsername = document.getString("username") ?: "Guest"
                val retrievedPassword = document.getString("password") ?: ""
                val user = Users(retrievedUsername, retrievedPassword)
                oneUserList.add(user)
                Log.d("UserRepository", "Username: $retrievedUsername")
            }
        } catch (exception: Exception) {
            Log.e("getUser", "Could not fetch user", exception)
        }
        oneUserList
    }

    // Use this for updating a user
    suspend fun updateUser(userId: String, updatedData: Map<String, Any>) = withContext(Dispatchers.IO) {
        try {
            firestoreInstance.collection("users").document(userId).update(updatedData).await()
            Log.d("UserRepository", "User updated successfully")
        } catch (exception: Exception) {
            Log.e("updateUser", "Error updating user", exception)
        }
    }

    // Use this for deleting an account
    suspend fun removeUser(userId: String) = withContext(Dispatchers.IO) {
        try {
            firestoreInstance.collection("users").document(userId).delete().await()
            Log.d("UserRepository", "User removed successfully")
        } catch (exception: Exception) {
            Log.e("removeUser", "Error removing user", exception)
        }
    }
}
