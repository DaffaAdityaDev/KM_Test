package com.example.kmtest.ThirdScreen

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kmtest.R
import com.example.kmtest.data.User

class ThirdScreenAdapter(private var userList: List<User>) :
    RecyclerView.Adapter<ThirdScreenAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_title_item)
        val tvEmail: TextView = view.findViewById(R.id.tv_email_item)
        val ivAvatar: ImageView = view.findViewById(R.id.iv_user_item)
        val llContainer = view.findViewById<ViewGroup>(R.id.ll_container_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = View.inflate(parent.context, R.layout.user_layout_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.tvName.text = user.first_name + " " + user.last_name
        holder.tvEmail.text = user.email
        Glide.with(holder.itemView.context).load(user.avatar).into(holder.ivAvatar)
        holder.llContainer.setOnClickListener {
            // Handle click
            val resultIntent = Intent()
            resultIntent.putExtra("EXTRA_USERNAME", user.first_name + " " + user.last_name)
            (holder.itemView.context as Activity).setResult(Activity.RESULT_OK, resultIntent)
            (holder.itemView.context as Activity).finish()
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUsers(newUsers: List<User>) {
        userList = newUsers
        notifyDataSetChanged()
    }
}

