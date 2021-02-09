package com.cmadushan.android.contacts.fragment.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cmadushan.android.contacts.R
import com.cmadushan.android.contacts.data.User
import com.cmadushan.android.contacts.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add_contact.*
import kotlinx.android.synthetic.main.fragment_add_contact.view.*

class UpdateFragment : Fragment() {
    private val args: UpdateFragmentArgs by navArgs()
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_contact, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.Name_ed.setText(args.name)
        view.phone_ed.setText(args.phone)
        view.Email_ed.setText(args.email)

        view.findViewById<Button>(R.id.button_save).setOnClickListener {
            updateData()
        }
        view.findViewById<Button>(R.id.button_cancel).setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_DisplayContactsFragment)
        }
        return view
    }
    private fun updateData() {
        val name =Name_ed.text.toString()
        val phone =phone_ed.text.toString()
        val email =Email_ed.text.toString()

        if (inputCheck(name, phone)){
            val updatedUser = User(args.id,name,phone, email)

            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(),"successfully updated", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_DisplayContactsFragment)
        }else{
            Toast.makeText(requireContext(),"please fill all fields", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(name: String,phone : String): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) )
    }

}