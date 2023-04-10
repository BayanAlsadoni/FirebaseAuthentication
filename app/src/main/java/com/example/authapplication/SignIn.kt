package com.example.authapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.StructuredName
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignIn : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = Firebase.auth
        
        val email = findViewById<EditText>(R.id.emailSignIn)
        val password = findViewById<EditText>(R.id.passwordSignIn)
        val signInBtn = findViewById<Button>(R.id.btnSignIn)
        signInBtn.setOnClickListener {
            signIn(email.text.toString(),password.text.toString())
        }


    }
    
    fun signIn(email : String, password: String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener (this){
            if (it.isSuccessful){
                Log.d("byn","sign in successful")
                updateUI()
            }else{
                Log.d("this","fail to sign in")
                Toast.makeText(this, "faild", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun updateUI(){
        var i = Intent(this,MainActivity::class.java)
        startActivity(i)
        finish()
    }
    
}