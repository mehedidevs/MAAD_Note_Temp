package com.cit.k_note_api.data.repo

import android.provider.Contacts.Intents.UI
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cit.k_note_api.api.UserApi
import com.cit.k_note_api.data.model.login.RequestLogin
import com.cit.k_note_api.data.model.registration.RequestUserRegsitration
import com.cit.k_note_api.data.model.registration.ResponseRegisterUser
import com.cit.k_note_api.utils.UiState
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Callback
import javax.inject.Inject

class UserRepo @Inject constructor(private val userApi: UserApi) {

    private val _userRegistrationResponse = MutableLiveData<UiState<ResponseRegisterUser>>()
    val userRegistrationResponse: LiveData<UiState<ResponseRegisterUser>>
        get() = _userRegistrationResponse

    suspend fun registerUser(request: RequestUserRegsitration) {

        _userRegistrationResponse.postValue(UiState.Loading())

        val response = userApi.registration(request)

        if (response.isSuccessful && response.body() != null) {
            _userRegistrationResponse.postValue(UiState.Success(response.body()))

        } else if (response.errorBody() != null) {

            var errorMsg: String = response.errorBody()!!.charStream().readText()

            val errObj = JSONObject(errorMsg)
            _userRegistrationResponse.postValue(UiState.Error(errObj.getString("message"), null))
        } else {

            _userRegistrationResponse.postValue(UiState.Error("Something went Wrong! ", null))
        }


    }


}