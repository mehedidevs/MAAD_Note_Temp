package com.cit.k_note_api.data.model.login

data class ResponseUserLogin(
    val token: String,
    val user: User
)