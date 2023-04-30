package com.danielcaballero.mynewcompose.login.domain

import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository){

    suspend operator fun invoke(user: String, password: String): Boolean =
        repository.doLogin(user, password)
}