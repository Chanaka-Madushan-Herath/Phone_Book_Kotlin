package com.cmadushan.android.contacts.fragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cmadushan.android.contacts.R
import kotlinx.android.synthetic.main.fragment_view_contact.view.*
import kotlinx.android.synthetic.main.fragment_view_contact.view.Name
import kotlinx.android.synthetic.main.fragment_view_contact.view.Phone

class ViewContactFragment : Fragment() {

    private val args by navArgs<ViewContactFragmentArgs>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_view_contact, container, false)


        view.Name.setText(args.CurrentUser.name)
        view.Phone.setText(args.CurrentUser.phone)
        view.Email.setText(args.CurrentUser.email)

        view.updateContact.setOnClickListener{
            val name = args.CurrentUser.name
            val phone = args.CurrentUser.phone
            val  email = args.CurrentUser.email
            val id =args.CurrentUser.id

            val action = ViewContactFragmentDirections.actionViewContactFragmentToUpdateFragment(name,phone,email,id)
            findNavController().navigate(action)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}