package ru.fintech.tinkoff.fintechportal.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.fintech.tinkoff.fintechportal.Injector
import ru.fintech.tinkoff.fintechportal.R
import ru.fintech.tinkoff.fintechportal.domain.SignInInfo
import ru.fintech.tinkoff.fintechportal.domain.User
import android.widget.Toast
import android.content.Intent




class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        val KEY_IS_FIRST = "is_first"
        val STORAGE_NAME = "storage"


        val prefs = getSharedPreferences(STORAGE_NAME, MODE_PRIVATE)
        val editor = prefs.edit()

        if (!prefs.getBoolean(KEY_IS_FIRST, true)) {
            startMainActivity()
        }



        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)
        val enterBtn = findViewById<Button>(R.id.enter_btn)
        val forgotPasswordBtn = findViewById<TextView>(R.id.forgot_password_btn)

        enterBtn.setOnClickListener {
            val userEmail = emailField.text.toString()
            val userPassword = passwordField.text.toString()
            val singInInfo = SignInInfo(userEmail, userPassword)



            var callback: Callback<User> = object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.code() == 200) {
                        Log.d("Login","200")
                        val user = response.body()
                        editor.putBoolean(KEY_IS_FIRST, false)
                        editor.apply()
                        startMainActivity()
                        //TODO Database

                    } else {
                        Log.d("Login","123")
                        //TODO toast text
                        Toast.makeText(
                            applicationContext, response.body()?.detail,
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("Login","0")
                    Toast.makeText(
                        applicationContext, "Check internet connection",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            Injector.instance!!.schoolApi.signIn(singInInfo).enqueue(callback)



        }

    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}

