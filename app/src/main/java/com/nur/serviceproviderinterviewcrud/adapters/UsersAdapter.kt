package com.nur.serviceproviderinterviewcrud.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nur.serviceproviderinterviewcrud.R
import com.nur.serviceproviderinterviewcrud.model.Users
import java.util.*


class UsersAdapter( val userList:List<Users>, val context: Context): RecyclerView.Adapter<UsersAdapter.MyViewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return  MyViewholder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
       val currentItem = userList[position]
        Log.d("inside adapter", "onBindViewHolder: the user name is ${holder.name}")
        holder.name.setText(currentItem.status)
        holder.gender.setText(currentItem.gender)
        holder.mail.setText(currentItem.email)


        val r = Random()
        val red: Int = r.nextInt(255 - 0 + 1) + 0
        val green: Int = r.nextInt(255 - 0 + 1) + 0
        val blue: Int = r.nextInt(255 - 0 + 1) + 0

        val draw = GradientDrawable()
        draw.shape = GradientDrawable.OVAL
        draw.setColor(Color.rgb(red, green, blue))

        holder.avatar.setBackground(draw)
        holder.avatarName.setText(currentItem.name?.substring(0,1) ?: "N")
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class MyViewholder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val name:TextView =  itemView.findViewById(R.id.userName)
        val gender:TextView =  itemView.findViewById(R.id.userGender)
        val mail:TextView =  itemView.findViewById(R.id.userMail)
        val avatar: CardView = itemView.findViewById(R.id.avatarImage)
        val avatarName: TextView = itemView.findViewById(R.id.avatarName)

    }


}