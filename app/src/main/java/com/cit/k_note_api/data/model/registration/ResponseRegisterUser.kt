package com.cit.k_note_api.data.model.registration

data class ResponseRegisterUser(
    val token: String,
    val user: User
)