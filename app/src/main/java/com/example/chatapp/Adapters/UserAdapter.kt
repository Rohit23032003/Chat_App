package com.example.chatapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.ChatDetailActivity
import com.example.chatapp.Model.userg
import com.example.chatapp.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(private val list:ArrayList<userg>):RecyclerView.Adapter<UserAdapter.Viewholder>() {
    class Viewholder(item:View):RecyclerView.ViewHolder(item) {
         var pic:CircleImageView=item.findViewById(R.id.profile_pic)
        var name:TextView=item.findViewById(R.id.user_name_list)
        var Lastmessage:TextView=item.findViewById(R.id.lastMessage_list)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val layout=LayoutInflater.from(parent.context).inflate(R.layout.sample_user,parent,false)
        return  Viewholder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
////        holder.pic.setImageResource(list[position].ProfilePic)
        Picasso.get().load(list[position].ProfilePic).placeholder(R.drawable.avatar3)
        holder.name.text=list[position].UserName
       val  user :userg=list.get(position)
        val userId=list[position].UserId.toString()
        holder.Lastmessage.text=list[position].LastMessage
//        holder.itemView.setOnClickListener(){
//            Toast.makeText(it.context, "$userId", Toast.LENGTH_SHORT).show()
//            val intent=Intent(it.context,ChatDetailActivity::class.java).also {
//                it.putExtra("userId",userId)
//                it.putExtra("ProfilePic",user.getProfilePic().toString())
//                it.putExtra("UserName",user.getUserName().toString())
//            }
//            it.context.startActivities(arrayOf(intent))
//        }

    }
}
