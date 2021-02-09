package com.cmadushan.android.contacts.fragment.display


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cmadushan.android.contacts.R
import com.cmadushan.android.contacts.data.User
import com.cmadushan.android.contacts.fragment.view.ViewContactFragment
import kotlinx.android.synthetic.main.single_contact.view.*
import androidx.fragment.app.ListFragment as ListFragment1

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_contact,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.Name.text = currentItem.name
        holder.itemView.Phone.text = currentItem.phone
        holder.itemView.rowLayout.setOnClickListener {
            val action =DisplayContactsFragmentDirections.actionDisplayContactsFragmentToViewContactFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }



    fun  setData(user :List<User>){
        this.userList= user
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}