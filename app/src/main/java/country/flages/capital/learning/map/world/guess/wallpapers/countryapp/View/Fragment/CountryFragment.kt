package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data.AllCountryClass.CountryAllDetails
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data.DataFactory
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.R
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Adapter.DetailsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CountryFragment : Fragment() {

    private var param1: Int? = null
    private var param2: String? = null

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DetailsAdapter
    lateinit var searchView: EditText
    lateinit var search: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_country, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)
        getDetails()
        return view
    }

    private fun getDetails() {
        val country = DataFactory.detailsInterface.getAllCountry()
        country.enqueue(object : Callback<ArrayList<CountryAllDetails>> {
            override fun onResponse(call: Call<ArrayList<CountryAllDetails>>, response: Response<ArrayList<CountryAllDetails>>) {
                val detail = response.body()
                if (detail != null) {
                    Log.d(" response ", detail.get(0).name.toString())
                    adapter = DetailsAdapter(context ?: return, detail)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(context)

                    searchView.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(
                                s: CharSequence?,
                                start: Int,
                                count: Int,
                                after: Int
                        ) {}

                        override fun onTextChanged(
                                s: CharSequence?,
                                start: Int,
                                before: Int,
                                count: Int
                        ) {

                        }

                        override fun afterTextChanged(s: Editable?) {
                            filter(s.toString())
                        }

                        private fun filter(text: String) {
                            var filteredList: ArrayList<CountryAllDetails>? = ArrayList()
                            for (item in detail) {
                                if (item.name?.toLowerCase()?.contains(text.toLowerCase()) == true) {
                                    filteredList?.add(item)
                                }
                            }
                            if (filteredList != null) {
                                adapter.filterList(filteredList)
                            }
                        }
                    })
                }
            }

            override fun onFailure(call: Call<ArrayList<CountryAllDetails>>, t: Throwable) {
                Log.e("Error", t.toString())
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
                CountryFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}