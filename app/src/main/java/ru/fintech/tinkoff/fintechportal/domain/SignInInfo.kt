package ru.fintech.tinkoff.fintechportal.domain

import com.google.gson.annotations.SerializedName

class SignInInfo(@SerializedName("email") var email: String?, @SerializedName("password") var password: String?) {

}