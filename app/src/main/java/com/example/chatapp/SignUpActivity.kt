package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.chatapp.Model.userg
import com.example.chatapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var authr: FirebaseAuth
    private lateinit var Firebasedata:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
       Firebasedata=FirebaseDatabase.getInstance().reference
        authr= Firebase.auth
        binding.btnSignup.setOnClickListener() {
            if (binding.EmailText.text.toString().isEmpty() || binding.setPassword.text.toString().isEmpty()
                || binding.username.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Fill all field's properly", Toast.LENGTH_SHORT).show()
            }
            else {
                val email=binding.EmailText.text.toString()
                val password=binding.setPassword.text.toString()
                authr.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information

                            Firebasedata.child("user").child(authr.currentUser!!.uid).setValue(userg(binding.EmailText.text.toString(),binding.setPassword.text.toString()
                                ,binding.username.text.toString(),authr.currentUser!!.uid))
                            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                            val intent=Intent(this,MainActivity::class.java)
                            startActivity(intent)

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    binding.textAlreadyAccount.setOnClickListener(){
        finish()
    }
    }

}
