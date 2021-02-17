package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data.AllCountryClass.WonderData
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.R
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Adapter.WonderAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class WonderFragment : Fragment() {

    lateinit var wonderRecyclerView: RecyclerView
    lateinit var wonderAdapter: WonderAdapter
    private var param1: Int? = null
    private var param2: String? = null

    var wonder1 = WonderData((R.drawable.tajmahal), "Taj Mahal ", "India ", 27.1712, 78.0387)
    var wonder2 = WonderData((R.drawable.colosseum), "Colosseum", " Italy ", 41.890251, 12.492373)
    var wonder3 = WonderData((R.drawable.machupicchu), "Machu Picchu ", " Peru ", -13.163068, -72.545128)
    var wonder4 = WonderData((R.drawable.christtheredeemer), "Christ The Redeemer", " Brazil ", -20.91362, -43.21125)
    var wonder5 = WonderData((R.drawable.mayan_pyramid), " Chichen Itza", " Mexico ", 20.6764, -88.5679)
    var wonder6 = WonderData((R.drawable.petra), "Petra", " Jordan ", 30.328960, 35.444832)
    var wonder7 = WonderData((R.drawable.greatwall), "Great wall of China ", " China ", 40.431908, -116.570374)

    var myWonderList: ArrayList<WonderData> = arrayListOf(wonder1, wonder2, wonder3, wonder4, wonder5, wonder6, wonder7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_wonder, container, false)

        wonderRecyclerView = view.findViewById(R.id.recyclerView2)
        newRecyclerView()
        return view
    }

    private fun newRecyclerView() {
        wonderAdapter = WonderAdapter(context ?: return, myWonderList)
        wonderRecyclerView.adapter = wonderAdapter
        wonderRecyclerView.layoutManager = LinearLayoutManager(context)

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
                WonderFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
