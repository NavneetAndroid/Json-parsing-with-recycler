package com.example.parctise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvUsersList= findViewById<RecyclerView>(R.id.rvUsersList)
        val usersList: ArrayList<UserModelClass> = ArrayList()
        try {

            val obj = JSONObject(getJSONFromAssets()!!)
            val usersArray = obj.getJSONArray("users")

            for (i in 0 until usersArray.length()) {
                val user = usersArray.getJSONObject(i)
                val id = user.getInt("id")
                val firstname = user.getString("first_name")
                val email = user.getString("email")
                val lastname = user.getString("last_name")
                val userDetails =
                    UserModelClass(id, firstname, email, lastname)

                usersList.add(userDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val itemAdapter = UserAdapter(this, usersList)
        rvUsersList.adapter = itemAdapter

    }
    private fun getJSONFromAssets(): String? {

        var json: String?
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("Users.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()

            return null
        }
        return json
    }
}