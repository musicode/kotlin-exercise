package com.musicode.bottomnavigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    enum class FragmentType {
        home, dashboard, notifications
    }

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_home -> {
                    setFragment(FragmentType.home)
                }

                R.id.navigation_dashboard -> {
                    setFragment(FragmentType.dashboard)
                }

                R.id.navigation_notifications -> {
                    setFragment(FragmentType.notifications)
                }
            }
            false
        }

        setFragment(FragmentType.home)
    }

    fun setFragment(type: FragmentType) {

        val transation = fragmentManager.beginTransaction()

        when (type) {
            FragmentType.home -> {
                title = "Home"
                transation.replace(R.id.fragment_container, HomeFragment())
            }

            FragmentType.dashboard -> {
                title = "Dashboard"
                transation.replace(R.id.fragment_container, DashboardFragment())
            }

            FragmentType.notifications -> {
                title = "Notifications"
                transation.replace(R.id.fragment_container, NotificationsFragment())
            }
        }

        transation.addToBackStack(null)
        transation.commit()

    }
}
