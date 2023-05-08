package com.nur.serviceproviderinterviewcrud.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nur.serviceproviderinterviewcrud.R
import com.nur.serviceproviderinterviewcrud.model.Users
import java.util.*

class UserAdapterInactive(val userList:List<Users>, val context: Context): RecyclerView.Adapter<UserAdapterInactive.MyViewholderInactive>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholderInactive {
        val itemView_inactive = LayoutInflater.from(parent.context).inflate(R.layout.item_view_inactive,parent,false)
        return MyViewholderInactive(itemView_inactive)
    }

    override fun onBindViewHolder(holder: MyViewholderInactive, position: Int) {
        val currentItem = userList[position]
        Log.d("inside adapter", "onBindViewHolder: the user name is ${holder.name}")
        holder.name.setText(currentItem.status)
        holder.gender.setText(currentItem.gender)
        holder.mail.setText(currentItem.email)
        holder.avatarName.setText(currentItem.name?.substring(0,1) ?: "N")
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    class MyViewholderInactive(itemView: View):RecyclerView.ViewHolder(itemView) {

        val name: TextView =  itemView.findViewById(R.id.userName_inactive)
        val gender: TextView =  itemView.findViewById(R.id.userGender_inactive)
        val mail: TextView =  itemView.findViewById(R.id.userMail_inactive)
        val avatar: CardView = itemView.findViewById(R.id.avatarImage_inactive)
        val avatarName: TextView = itemView.findViewById(R.id.avatarName_inactive)

    }
}