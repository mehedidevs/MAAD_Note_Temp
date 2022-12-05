package com.cit.k_note_api.ui.regsitrationuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cit.k_note_api.data.model.registration.RequestUserRegsitration
import com.cit.k_note_api.data.model.registration.ResponseRegisterUser
import com.cit.k_note_api.data.repo.UserRepo
import com.cit.k_note_api.utils.UiState
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userRepo: UserRepo) : ViewModel() {


    val userRegistrationResponse: LiveData<UiState<ResponseRegisterUser>>
        get() = userRepo.userRegistrationResponse

    fun registerUser(requestUserRegistration: RequestUserRegsitration) {

        viewModelScope.launch {
            userRepo.registerUser(requestUserRegistration)
        }
    }


}