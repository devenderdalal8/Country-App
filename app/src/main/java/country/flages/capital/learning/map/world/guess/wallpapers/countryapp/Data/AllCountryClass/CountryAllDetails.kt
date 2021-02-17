package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data.AllCountryClass

import com.google.gson.annotations.SerializedName

class CountryAllDetails (
        @SerializedName("name") val name : String? = null,
        @SerializedName("capital") val capital : String? = null,
        @SerializedName("region") val region : String? = null,
        @SerializedName("subregion") val subregion : String? = null,
        @SerializedName("population") val population : Int? = null,
        @SerializedName("demonym") val demonym : String? = null,
        @SerializedName("area") val area : Float? = null,
        @SerializedName("nativeName") val nativeName : String? = null,
        @SerializedName("flag") val flag : String? = null,
        @SerializedName("topLevelDomain") val topLevelDomain : List<String>? = null,
        @SerializedName("timezones") val timezones : List<String>? = null,
        @SerializedName("currencies") val currencies : List<Currencies>? = null,
        @SerializedName("languages") val languages : List<Languages>? = null,
        @SerializedName("latlng") val latlng : List<Double>? = null,
)