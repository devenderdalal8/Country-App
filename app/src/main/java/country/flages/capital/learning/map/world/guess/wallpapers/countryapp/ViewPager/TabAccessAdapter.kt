package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Fragment.CountryFragment
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Fragment.MapsFragment
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Fragment.WonderFragment

class TabAccessAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {
    val size: Int = 3
    override fun getCount(): Int {
        return size
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return CountryFragment.newInstance(position, "Country")
            }
            1 -> {
                return WonderFragment.newInstance(position, "Wonder")
            }
            2 ->{
                return MapsFragment()
            }
        }
        return CountryFragment.newInstance(position, "Country")
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null;
        if (position == 0) {
            title = "Country"
        } else if (position == 1) {
            title = "Wonder"
        }else if (position == 2) {
            title = " Maps "
        }
        return title
    }
}
