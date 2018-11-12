package ru.fintech.tinkoff.fintechportal.domain

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("birthday")
    var birthday: String? = null
    @SerializedName("email")
    var email: String? = null
    @SerializedName("first_name")
    var firstName: String? = null
    @SerializedName("last_name")
    var lastName: String? = null
    @SerializedName("middle_name")
    var middleName: String? = null
    @SerializedName("phone_mobile")
    var mobilePhone: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("region")
    var region: String? = null
    @SerializedName("school")
    var school: String? = null
    @SerializedName("school_graduation")
    var schoolGraduation: String? = null
    @SerializedName("university")
    var university: String? = null
    @SerializedName("faculty")
    var faculty: String? = null
    @SerializedName("department")
    var department: String? = null
    @SerializedName("university_graduation")
    var universityGraduation: String? = null
    @SerializedName("avatar")
    var avatar: String? = null
    @SerializedName("current_work")
    var currentWork: String? = null
    @SerializedName("detail")
    var detail: String? = null

}