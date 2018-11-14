package ru.fintech.tinkoff.fintechportal.ui

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.fintech.tinkoff.fintechportal.Injector
import ru.fintech.tinkoff.fintechportal.R
import ru.fintech.tinkoff.fintechportal.domain.User

class MainActivity : AppCompatActivity() {

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null

        when (item.itemId) {
            R.id.nav_tests -> selectedFragment = QuestionFragment()
            R.id.nav_mock -> selectedFragment = ProfileFragment()
            R.id.nav_profile -> selectedFragment = ProfileFragment()
        }

        supportFragmentManager.beginTransaction().replace(
            R.id.container,
            selectedFragment!!
        ).commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        var user : User? = intent.getParcelableExtra("USER")

//        var callback: Callback<User> = object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                if (response.code() == 200) {
//                    Log.d("Login","200")
//                    user = response.body()
//
//                    supportFragmentManager.beginTransaction().replace(
//                        R.id.container,
//                        ProfileFragment.newInstance(user)
//                    ).commit()
//
//                } else {
//                    Log.d("Login","123")
//                    //TODO toast text
//                    Toast.makeText(
//                        applicationContext, response.body()?.detail,
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                }
//
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                Log.d("Login","0")
//                Toast.makeText(
//                    applicationContext, "Check internet connection",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//
//        Injector.instance!!.schoolApi.getUser().enqueue(callback)


//        I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.container,
                ProfileFragment.newInstance(user)
            ).commit()
        }
    }
}