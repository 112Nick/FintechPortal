package ru.fintech.tinkoff.fintechportal

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.fintech.tinkoff.fintechportal.api.SchoolApi


class Injector private constructor(context : Context) {

    public val schoolApi : SchoolApi


    init {

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(AddCookieInterceptor(context))
        builder.addInterceptor(RecievedCookiesInterceptor(context))

        val httpClient = builder.build()

        schoolApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl(SchoolApi.BASE_URL)
            .build()
            .create(SchoolApi::class.java)
    }


    companion object {

        var instance: Injector? = null
            private set


        fun init(context: Context) {
            if (instance == null) {
                instance = Injector(context)
            }
        }
    }

}