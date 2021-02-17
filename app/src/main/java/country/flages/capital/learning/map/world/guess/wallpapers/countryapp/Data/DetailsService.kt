package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data

import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data.AllCountryClass.CountryAllDetails
import retrofit2.Call
import retrofit2.http.GET

interface DetailsInterface {
    @GET("all")
    fun getAllCountry(): Call<ArrayList<CountryAllDetails>>
}



