package com.cmadushan.android.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class AddContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_save).setOnClickListener {
            findNavController().navigate(R.id.action_AddContactFragment_to_DisplayContactsFragment)
        }
        view.findViewById<Button>(R.id.button_cancel).setOnClickListener {
            findNavController().navigate(R.id.action_AddContactFragment_to_DisplayContactsFragment)
        }
    }
}