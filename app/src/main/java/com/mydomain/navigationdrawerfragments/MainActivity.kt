package com.mydomain.navigationdrawerfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.mydomain.navigationdrawerfragments.fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val toggle = ActionBarDrawerToggle( this@MainActivity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MessageFragment())
            .commit()
        navigationView.setCheckedItem(R.id.nav_message)

        navigationView.setNavigationItemSelectedListener(object: NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.nav_message -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, MessageFragment())
                            .commit()
                    }
                    R.id.nav_chat -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, ChatFragment())
                            .commit()
                    }
                    R.id.nav_profile -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, ProfileFragment())
                            .commit()
                    }
                    R.id.nav_fragments_comm -> {

                        val fragment = ExampleFragment.newInstance()

                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit()

                    }
                    R.id.nav_send -> {
                        Toast.makeText(this@MainActivity, "Send clicked", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_share -> {
                        Toast.makeText(this@MainActivity, "Share clicked", Toast.LENGTH_SHORT).show()
                    }
                }
                drawer.closeDrawer(GravityCompat.START)
                return  true
            }
        })
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}