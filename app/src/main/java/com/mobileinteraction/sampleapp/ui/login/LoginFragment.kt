package com.mobileinteraction.sampleapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mobileinteraction.sampleapp.R
import com.mobileinteraction.sampleapp.data.LoggedInUser
import com.mobileinteraction.sampleapp.databinding.FragmentLoginBinding
import java.util.*

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLoginBinding.bind(view)

        loginViewModel.loginFormState.observe(viewLifecycleOwner, Observer {loginState->
            _binding?.apply {
                // show error unless both username / password is valid
                if (loginState.usernameError != null) {
                    usernameET.error = getString(loginState.usernameError)
                }
                if (loginState.passwordError != null) {
                    passwordET.error = getString(loginState.passwordError)
                }
                if(loginState.isDataValid){
                    //navigate to Homefragment and passing loggedin user
                    val user = LoggedInUser(UUID.randomUUID().toString(), usernameET.text.toString())
                    val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(user)
                    findNavController().navigate(action)
                }
            }
        })
        _binding?.apply {
            loginBtn.setOnClickListener {
                loginViewModel.doLogin(usernameET.text.toString(),passwordET.text.toString())
            }
            forgotBtn.setOnClickListener {
                Toast.makeText(activity,getString(R.string.not_implemented),Toast.LENGTH_LONG).show()
            }
        }
    }
}