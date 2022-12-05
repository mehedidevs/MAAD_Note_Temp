package com.cit.k_note_api.api

import com.cit.k_note_api.data.model.login.RequestLogin
import com.cit.k_note_api.data.model.login.ResponseUserLogin
import com.cit.k_note_api.data.model.registration.RequestUserRegsitration
import com.cit.k_note_api.data.model.registration.ResponseRegisterUser
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/users/signup")
    suspend fun registration(@Body request: RequestUserRegsitration): Response<ResponseRegisterUser>

    @POST("/users/signin")
    suspend fun login(@Body request: RequestLogin): Response<ResponseUserLogin>


}