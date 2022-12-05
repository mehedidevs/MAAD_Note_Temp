package com.cit.k_note_api.ui.regsitrationuser

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cit.k_note_api.R
import com.cit.k_note_api.data.model.registration.RequestUserRegsitration
import com.cit.k_note_api.databinding.FragmentRegistrationBinding
import com.cit.k_note_api.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {


    lateinit var binding: FragmentRegistrationBinding

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerUserBtn.setOnClickListener {
            val name = binding.userName.text.toString().trim()
            val email = binding.userEmail.text.toString().trim()
            val password = binding.userPassword.text.toString().trim()

            val userRegReq = RequestUserRegsitration(email, password, name)

            viewModel.registerUser(userRegReq)
        }


        viewModel.userRegistrationResponse.observe(viewLifecycleOwner) {

            when (it) {
                is UiState.Error -> {
                    Log.i("TAG", "Error: ${it.message}")

                }
                is UiState.Loading -> {
                    Log.i("TAG", "Loading .....l")
                }
                is UiState.Success -> {

                    Log.i("TAG", "Error: ${it.data}")

                    findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
                }
            }
        }


    }


}




