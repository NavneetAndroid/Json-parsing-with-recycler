package com.example.parctise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val context: Context, val items: ArrayList<UserModelClass>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_user_layout,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)
     holder.tvID.text=item.id.toString()
        holder.tvemail.text=item.email
        holder.tvfirstname.text=item.first_name
        holder.tvlastname.text=item.last_name

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val tvID =view.findViewById<TextView>(R.id.tv_id)
        val tvemail =view.findViewById<TextView>(R.id.tv_email)
        val tvfirstname =view.findViewById<TextView>(R.id.tv_firstname)
        val tvlastname=view.findViewById<TextView>(R.id.tv_lastname)

    }
}