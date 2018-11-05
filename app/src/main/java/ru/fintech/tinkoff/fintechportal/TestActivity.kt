package ru.fintech.tinkoff.fintechportal

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val adapter = QuestionsViewPagerAdapter(supportFragmentManager)
//        adapter.addFragment(FragmentOne() , " One ")
//        adapter.addFragment(FragmentTwo() , " Two ")
//        adapter.addFragment(FragmentThree() , " Three ")
//        adapter.addFragment(FragmentFour() , " Four ")
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }

}