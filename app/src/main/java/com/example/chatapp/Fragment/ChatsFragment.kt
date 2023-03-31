package com.example.chatapp.Fragment

//import UserAdapter
//import UserAdapter
import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.Adapters.UserAdapter
import com.example.chatapp.Model.userg
import com.example.chatapp.databinding.FragmentChatsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth

import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class ChatsFragment : androidx.fragment.app.Fragment()  {
    private lateinit var binding:FragmentChatsBinding
//    private val _binding get() =binding!!
    private lateinit var authr: FirebaseAuth
    private lateinit var Firebasedata: DatabaseReference
//    lateinit var recyclerView: RecyclerView

    private  var list = ArrayList<userg>()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val layoutmanager=LinearLayoutManager(context)
////         recyclerView= view.findViewById(R.id.Chat_recyclerview)
//        recyclerView.layoutManager=layoutmanager
//        recyclerView.setHasFixedSize(true)
//        adapter=UserAdapter(list)
//        recyclerView.adapter=adapter
//    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentChatsBinding.inflate(inflater,container,false)
        Firebasedata= FirebaseDatabase.getInstance().reference

        val adapter: UserAdapter = UserAdapter(list)
        binding.ChatRecyclerview.adapter=adapter

        val layoutmanager= LinearLayoutManager(context)
        binding.ChatRecyclerview.layoutManager=layoutmanager
        authr= Firebase.auth
        Firebasedata.child("user").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (post in snapshot.children){
                    val currentUser : userg? = post.getValue(userg::class.java)
                    currentUser?.setUserId(post.key!!)
                   if(authr.currentUser?.uid!=currentUser?.UserId){
                        list.add(currentUser!!)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        return binding.root
    }


}