package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.R

class DetailsPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)

        val getArea: String? = intent.getStringExtra("area")
        val getImage: String? = intent.getStringExtra("image")
        val getName: String? = intent.getStringExtra("name")
        val getRegion: String? = intent.getStringExtra("region")
        val getCapital: String? = intent.getStringExtra("capital")
        val getPopulation: String? = intent.getStringExtra("population")
        val getOfficialName: String? = intent.getStringExtra("officialName")
        val getAlterName: String? = intent.getStringExtra("alterName")
        val getDomain: String? = intent.getStringExtra("domain")
        val getSubRegion: String? = intent.getStringExtra("subregion")
        val getTimeZone: String? = intent.getStringExtra("timezone")
        val getLanguages: String? = intent.getStringExtra("language")
        val getCurrency: String? = intent.getStringExtra("currency")
        val getLat: List<Double>? = intent.getSerializableExtra("lat") as List<Double>?

        val getLatitude: Double? = getLat?.get(0)
        val getLongitude: Double? = getLat?.get(1)

        val image = findViewById<ImageView>(R.id.detailsImage)
        val name = findViewById<TextView>(R.id.detailsName)
        val capital = findViewById<TextView>(R.id.detailsCapital)
        val population = findViewById<TextView>(R.id.countryPopulation)
        val officialName = findViewById<TextView>(R.id.countryOfficialName)
        val alterName = findViewById<TextView>(R.id.countryAlternativeName)
        val domainName = findViewById<TextView>(R.id.countryDomainName)
        val area = findViewById<TextView>(R.id.countryArea)
        val countryRegion = findViewById<TextView>(R.id.countryRegion)
        val countrySubRegion = findViewById<TextView>(R.id.countrySubRegion)
        val timeZone = findViewById<TextView>(R.id.countryTimeZone)
        val languages = findViewById<TextView>(R.id.countryLanguage)
        val currency = findViewById<TextView>(R.id.countryCurrency)
        val latitude = findViewById<TextView>(R.id.countryLatitude)
        val longitude = findViewById<TextView>(R.id.countryLongitude)
        val mapButton = findViewById<Button>(R.id.mapButton)

        name.text = getName
        latitude.text = getLatitude.toString()
        longitude.text = getLongitude.toString()
        currency.text = getCurrency
        languages.text = getLanguages
        timeZone.text = getTimeZone
        countryRegion.text = getRegion
        countrySubRegion.text = getSubRegion
        area.text = getArea + " km² "
        capital.text = getCapital
        population.text = getPopulation
        officialName.text = getOfficialName
        alterName.text = getAlterName
        domainName.text = getDomain

        Glide.with(this).load(getImage).into(image)

        mapButton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("lat", getLatitude)
            intent.putExtra("long", getLongitude)
            intent.putExtra("name", getName)
            startActivity(intent)

        }
    }
}

