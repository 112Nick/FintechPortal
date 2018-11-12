package ru.fintech.tinkoff.fintechportal.ui

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import ru.fintech.tinkoff.fintechportal.R

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

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.container,
                ProfileFragment()
            ).commit()
        }
    }
}