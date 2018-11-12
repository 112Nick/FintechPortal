package ru.fintech.tinkoff.fintechportal.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import ru.fintech.tinkoff.fintechportal.domain.SignInInfo
import ru.fintech.tinkoff.fintechportal.domain.User

interface SchoolApi {

    companion object {
        val BASE_URL = "https://fintech.tinkoff.ru"
    }

    @POST("/api/signin")
    fun signIn(@Body signInInfo: SignInInfo): Call<User>
}