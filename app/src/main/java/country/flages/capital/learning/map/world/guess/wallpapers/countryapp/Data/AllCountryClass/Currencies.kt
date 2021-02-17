package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data.AllCountryClass

import com.google.gson.annotations.SerializedName

data class Currencies(
	@SerializedName("name") val name: String? = null,
	@SerializedName("symbol") val symbol: String? = null
)
