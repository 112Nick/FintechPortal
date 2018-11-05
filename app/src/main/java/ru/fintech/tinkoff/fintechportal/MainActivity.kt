package ru.fintech.tinkoff.fintechportal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile)

//        val mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
//
//        val viewPager = findViewById<ViewPager>(R.id.main_view_pager)
//        val tabs = findViewById<TabLayout>(R.id.tabs)
//        viewPager.adapter = mainViewPagerAdapter
//        tabs.setupWithViewPager(viewPager)

    }
}
