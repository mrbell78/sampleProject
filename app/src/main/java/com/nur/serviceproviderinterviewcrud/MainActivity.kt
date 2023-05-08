package com.nur.serviceproviderinterviewcrud


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.nur.serviceproviderinterviewcrud.view.ServiceProviderRegistration


class MainActivity : AppCompatActivity() {



    private lateinit var tablayout: TabLayout
    private lateinit var viewPager2: ViewPager2

    private lateinit var tabadapter : FragmentPageAdapter

    private lateinit var fab:FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.homepage)

        tablayout = findViewById(R.id.tablyoutfortab)
        viewPager2 = findViewById(R.id.viewPager2)
        fab = findViewById(R.id.fab)
        tabadapter = FragmentPageAdapter(supportFragmentManager,lifecycle)

        fab.setOnClickListener { startActivity(Intent(this, ServiceProviderRegistration::class.java)) }

        tablayout.addTab(tablayout.newTab().setText("Active"))
        tablayout.addTab(tablayout.newTab().setText("Inactive"))

        viewPager2.adapter = tabadapter
        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tablayout.selectTab(tablayout.getTabAt(position))
            }
        })




    }
}