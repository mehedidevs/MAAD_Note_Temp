package com.cit.k_note_api.data.model.registration

data class RequestUserRegsitration(
    val email: String,
    val password: String,
    val username: String
)