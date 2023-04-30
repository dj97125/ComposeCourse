package com.danielcaballero.mynewcompose.login.data.network

import retrofit2.Response
import retrofit2.http.GET


data class LoginResponse(
    val success: Boolean
)

interface LoginClient {
    @GET("/V3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    suspend fun doLogin(): Response<LoginResponse>
}