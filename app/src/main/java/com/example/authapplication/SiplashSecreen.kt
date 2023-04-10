package com.example.authapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SiplashSecreen : AppCompatActivity() {

    val auth = Firebase.auth

//    override fun onStart() {
//        super.onStart()
//        val currentUser= auth.currentUser
//        if(currentUser != null){
//            startActivity(Intent(this,MainActivity::class.java))
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siplash_secreen)

        Handler().postDelayed({
            val i= Intent(this,SingUpActivity::class.java)
            startActivity(i)
            finish()
        },2500)


    }
}