package com.landfathich.bottomnavigationtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.landfathich.bottomnavigationtest.fragments.ExploreFragment
import com.landfathich.bottomnavigationtest.fragments.HomeFragment
import com.landfathich.bottomnavigationtest.fragments.LibraryFragment
import com.landfathich.bottomnavigationtest.fragments.SubscriptionsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_explore -> {
                    openFragment(ExploreFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_library -> {
                    openFragment(LibraryFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_subscriptions -> {
                    openFragment(SubscriptionsFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_home -> {
                    openFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}