package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data.AllCountryClass.CountryAllDetails
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.R
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Activity.DetailsPageActivity
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.ViewHolder.DetailsViewHolder
import java.io.Serializable

class DetailsAdapter(val context: Context, var details: ArrayList<CountryAllDetails>) : RecyclerView.Adapter<DetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return DetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val details = details[position]

        val name = details.name?.trim().toString()
        val url = details.flag
        val capital = details.capital.toString()
        val region = details.region.toString()
        val population = details.population.toString()
        val officialName = details.nativeName.toString()
        val alterName = details.demonym.toString()
        val area = details.area.toString()
        val subRegion = details.subregion.toString()
        val domain = details.topLevelDomain?.get(0).toString()
        val timeZone = details.timezones?.get(0)
        val currency = details.currencies?.get(0)?.name.toString()
        val languages = details.languages?.get(0)?.name.toString()
        val lat = details.latlng

        holder.countryName.text = name
        holder.countryArea.text = capital
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .skipMemoryCache(true)
                .into(holder.countryFlag)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsPageActivity::class.java)
            intent.putExtra("image", url)
            intent.putExtra("subregion", subRegion)
            intent.putExtra("name", name)
            intent.putExtra("capital", capital)
            intent.putExtra("region", region)
            intent.putExtra("population", population)
            intent.putExtra("officialName", officialName)
            intent.putExtra("alterName", alterName)
            intent.putExtra("area", area)
            intent.putExtra("domain", domain)
            intent.putExtra("timezone", timeZone)
            intent.putExtra("currency", currency)
            intent.putExtra("language", languages)
            intent.putExtra("lat", lat as Serializable?)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return details.size
    }

    fun filterList(filterList: ArrayList<CountryAllDetails>) {
        this.details = filterList
        notifyDataSetChanged()
    }
}

