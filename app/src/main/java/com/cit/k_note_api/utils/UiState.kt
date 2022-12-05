package com.cit.k_note_api.utils

sealed class UiState<T>(val data: T? = null, val message: String? = null) {

    class Loading<T>() : UiState<T>()
    class Error<T>(message: String?, data: T?) : UiState<T>(data, message)
    class Success<T>(data: T?) : UiState<T>(data)


}