package com.example.authapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SingUpActivity : AppCompatActivity() {

    lateinit var auth:FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentUser= auth.currentUser
        if(currentUser != null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)


        auth = Firebase.auth


        val email = findViewById<EditText>(R.id.emailSignUp)
        val pasword = findViewById<EditText>(R.id.passwordSignUp)
        val signUpbtn = findViewById<Button>(R.id.btnSignUp)

        signUpbtn.setOnClickListener {
            createNewAccoutn(email.text.toString(),pasword.text.toString())
        }

    }

    private fun createNewAccoutn(email: String , pasword: String) {
        auth.createUserWithEmailAndPassword(email,pasword).addOnCompleteListener(this) {

            if(it.isSuccessful){
                Log.e("byn","create user successful")
                val user = auth.currentUser
                updateUI()

            }else{
                Log.e("byn","fail to creat user", it.exception)
                Toast.makeText(this, "faild", Toast.LENGTH_SHORT).show()

            }

        }
    }

   private fun updateUI(){
        var i = Intent(this,SignIn::class.java)
       startActivity(i)
       finish()
    }


}
