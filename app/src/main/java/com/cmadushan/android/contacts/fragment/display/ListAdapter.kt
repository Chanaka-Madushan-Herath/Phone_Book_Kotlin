package com.cmadushan.android.contacts.fragment.display

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cmadushan.android.contacts.R
import com.cmadushan.android.contacts.data.User

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_contact,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.Name).text = currentItem.name
        holder.itemView.findViewById<TextView>(R.id.Phone).text = currentItem.phone
    }
    fun  setData(user :List<User>){
        this.userList= user
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}