package com.example.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.chatapp.Adapters.FragmentAdapter
import com.example.chatapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var authr: FirebaseAuth
    var tabLayouts= arrayOf("Chats","Status","Calls")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authr= Firebase.auth
        val pager=binding.viewPager2
        val tabl=binding.TabLayout
        pager.adapter=FragmentAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tabl,pager){
            tab,position->
                tab.text= tabLayouts[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.settings_menu-> Toast.makeText(this, "Setting is clicked", Toast.LENGTH_SHORT).show()
             R.id.Group_chat->Toast.makeText(this, "Group_Chat is clicked", Toast.LENGTH_SHORT).show()
            R.id.log_out-> {
                SignUpActivity().finish()
                authr.signOut()
                finish()
//                val intent=Intent(this,SingInActivity::class.java)
//                startActivity(intent)
//                MainActivity().finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}