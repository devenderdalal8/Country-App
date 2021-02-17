package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataFactory {

    companion object DetailsService {
        val detailsInterface: DetailsInterface

        init {
            val BASE_URL = "https://restcountries.eu/rest/v2/"

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            detailsInterface = retrofit.create(DetailsInterface::class.java)
        }
    }
}
