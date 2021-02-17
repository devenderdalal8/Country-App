package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.R
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.ViewPager.TabAccessAdapter

class MainActivity : AppCompatActivity() {
    var viewPagerTab: TabLayout? =null
    var fragmentPagerAdapter: TabAccessAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPagerTab()
    }

    private fun viewPagerTab() {
        viewPagerTab = findViewById(R.id.tabs)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager!!.adapter = TabAccessAdapter(supportFragmentManager)
        viewPager!!.currentItem = 0
        viewPagerTab!!.setupWithViewPager(viewPager)
    }
}
