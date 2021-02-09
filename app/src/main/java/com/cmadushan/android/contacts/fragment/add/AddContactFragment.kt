package com.cmadushan.android.contacts.fragment.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cmadushan.android.contacts.R
import com.cmadushan.android.contacts.data.User
import com.cmadushan.android.contacts.data.UserViewModel
import java.util.jar.Attributes

class AddContactFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_contact, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.findViewById<Button>(R.id.button_save).setOnClickListener {
            insertDataToDatabase()

        }
        view.findViewById<Button>(R.id.button_cancel).setOnClickListener {
            val action = AddContactFragmentDirections.actionAddContactFragmentToDisplayContactsFragment()
            findNavController().navigate(action)
        }
        return view

    }
    private fun insertDataToDatabase() {
        val name = view?.findViewById<EditText>(R.id.Name_ed)?.text.toString()
        val phone = view?.findViewById<EditText>(R.id.phone_ed)?.text.toString()
        val email = view?.findViewById<EditText>(R.id.Email_ed)?.text.toString()

        if (inputCheck(name, phone)){
            val user =User(0,name,phone, email)

            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"successfully added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_AddContactFragment_to_DisplayContactsFragment)
        }else{
            Toast.makeText(requireContext(),"please fill all fields",Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(name: String,phone : String): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) )
    }
}