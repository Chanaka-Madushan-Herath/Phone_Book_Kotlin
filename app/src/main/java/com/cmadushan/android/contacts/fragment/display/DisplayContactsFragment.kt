package com.cmadushan.android.contacts.fragment.display

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmadushan.android.contacts.R
import com.cmadushan.android.contacts.data.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DisplayContactsFragment : Fragment() {


    private lateinit var mUserViewModel:UserViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_display_contacts, container, false)

        val adapter =ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter =adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        view.findViewById<FloatingActionButton>(R.id.addContact).setOnClickListener {
            findNavController().navigate(R.id.action_DisplayContactsFragment_to_AddContactFragment)
        }

        return view
    }


}


