package com.mobileinteraction.sampleapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mobileinteraction.sampleapp.R
import com.mobileinteraction.sampleapp.data.LoggedInUser
import com.mobileinteraction.sampleapp.databinding.FragmentHomeBinding
import com.mobileinteraction.sampleapp.databinding.FragmentLoginBinding
import com.mobileinteraction.sampleapp.ui.login.LoginFragmentDirections
import java.util.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val args by navArgs<HomeFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        _binding = FragmentHomeBinding.bind(view)
        val user = args.loggedUser
        _binding?.apply {
            tvName.text = user.displayName
        }

    }

}