package com.cmadushan.android.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DisplayContactsFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ListView>(R.id.displayContacts).setOnClickListener {
            findNavController().navigate(R.id.action_DisplayContactsFragment_to_ViewContactFragment)
        }
        view.findViewById<FloatingActionButton>(R.id.addContact).setOnClickListener {
            findNavController().navigate(R.id.action_DisplayContactsFragment_to_AddContactFragment)
        }
    }
}