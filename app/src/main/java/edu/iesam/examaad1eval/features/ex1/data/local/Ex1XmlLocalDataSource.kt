package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1XmlLocalDataSource(context: Context) {
    private val sharedPref = context.getSharedPreferences("db-exam", Context.MODE_PRIVATE)
    private val editor = sharedPref.edit()
    private val gson = Gson()

    // Users functions
    fun getUsers(): List<User> {
        val json = sharedPref.getString("users", "")
        return if (json.isNullOrEmpty()) {
            val emptyList = listOf<User>()
            saveUsers(emptyList)
            emptyList
        } else {
            gson.fromJson(json, Array<User>::class.java).toList()
        }
    }

    fun saveUsers(users: List<User>) {
        val json = gson.toJson(users)
        editor.putString("users", json)
        editor.commit()
    }

    // Items functions
    fun getItems(): List<Item> {
        val json = sharedPref.getString("items", "")
        return if (json.isNullOrEmpty()) {
            val emptyList = listOf<Item>()
            saveItems(emptyList)
            emptyList
        } else {
            gson.fromJson(json, Array<Item>::class.java).toList()
        }
    }

    fun saveItems(items: List<Item>) {
        val json = gson.toJson(items)
        editor.putString("items", json)
        editor.commit()
    }

    // Services functions
    fun getServices(): List<Services> {
        val json = sharedPref.getString("services", "")
        return if (json.isNullOrEmpty()) {
            val emptyList = listOf<Services>()
            saveServices(emptyList)
            emptyList
        } else {
            gson.fromJson(json, Array<Services>::class.java).toList()
        }
    }

    fun saveServices(services: List<Services>) {
        val json = gson.toJson(services)
        editor.putString("services", json)
        editor.commit()
    }
}