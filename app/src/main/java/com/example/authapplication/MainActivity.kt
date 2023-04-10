package com.example.authapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<TextView>(R.id.email)
        val uid = findViewById<TextView>(R.id.uid)


        auth = Firebase.auth
        val user = auth.currentUser

        email.text = user?.email.toString()
        uid.text = user?.uid.toString()
        Log.d("byn",email.text.toString())

        val logoutBtn = findViewById<Button>(R.id.logOutBtn)
        logoutBtn.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this,SignIn::class.java))
            finish()
        }
    }
}