package ru.fintech.tinkoff.fintechportal.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class User() : Parcelable {
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

    constructor(parcel: Parcel) : this() {
        birthday = parcel.readString()
        email = parcel.readString()
        firstName = parcel.readString()
        lastName = parcel.readString()
        middleName = parcel.readString()
        mobilePhone = parcel.readString()
        description = parcel.readString()
        region = parcel.readString()
        school = parcel.readString()
        schoolGraduation = parcel.readString()
        university = parcel.readString()
        faculty = parcel.readString()
        department = parcel.readString()
        universityGraduation = parcel.readString()
        avatar = parcel.readString()
        currentWork = parcel.readString()
        detail = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(birthday)
        parcel.writeString(email)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(middleName)
        parcel.writeString(mobilePhone)
        parcel.writeString(description)
        parcel.writeString(region)
        parcel.writeString(school)
        parcel.writeString(schoolGraduation)
        parcel.writeString(university)
        parcel.writeString(faculty)
        parcel.writeString(department)
        parcel.writeString(universityGraduation)
        parcel.writeString(avatar)
        parcel.writeString(currentWork)
        parcel.writeString(detail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}