package com.example.chatapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.chatapp.Model.userg
import com.example.chatapp.databinding.ActivitySingInBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SingInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingInBinding
    private lateinit var authr: FirebaseAuth
    private lateinit var Firebasedata: DatabaseReference
    private lateinit var googleSingin:GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySingInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authr= Firebase.auth


        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()



        googleSingin=GoogleSignIn.getClient(this,gso)


        // by clicking on SignIn with google option creting account on firebase .
        binding.btnGoogle.setOnClickListener(){
            singInGoogle()
        }


        binding.btnSignIn.setOnClickListener(){

            // checking  for any of the one  input field is empty or not.

            if (binding.EmailTextSignIn.text.toString().isEmpty() || binding.passwordSingIn.text.toString().isEmpty())
             {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }else{

                // creating or adding a node of  user on firebase

                    authr.signInWithEmailAndPassword(binding.EmailTextSignIn.text.toString(),binding.passwordSingIn.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {

                                // by intent passing user to next page .

                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, "Error Occurs", Toast.LENGTH_SHORT).show()
                            }
                        }
            }
        }

        // hiding the ActionBar

        if(supportActionBar!=null)
        {
            supportActionBar!!.hide()
        }

        // if user already having an account  can signIn by  id and password .
        binding.ClickTextSingIn.setOnClickListener(){
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
//
    private fun singInGoogle() {
        val signinIntent=googleSingin.signInIntent
    launcher.launch(signinIntent)
    }
    private val launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->
        run {
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResult(task)
            }
        }
    }

    private fun handleResult(task: Task<GoogleSignInAccount>) {
        if(task.isSuccessful){
            val account:GoogleSignInAccount?=task.result
            if(account!=null){
                updateUI(account)
            }
        }else{
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential=GoogleAuthProvider.getCredential(account.idToken,null)
        authr.signInWithCredential(credential).addOnCompleteListener(){
            if(it.isSuccessful){
                Firebasedata= FirebaseDatabase.getInstance().getReference()
                val fuser: FirebaseUser? =authr.currentUser
                if (fuser != null) {
                    Firebasedata.child("user").child(authr.currentUser!!.uid).
                    setValue(userg(fuser.email.toString(),
                        fuser.uid,fuser.displayName.toString(),fuser.uid))
                }
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
