package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.Data.AllCountryClass.WonderData
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.R
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.Activity.MapsActivity
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.ViewHolder.WonderViewHolder

class WonderAdapter(val context: Context, var data: List<WonderData>) : RecyclerView.Adapter<WonderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WonderViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return WonderViewHolder(view)
    }

    override fun onBindViewHolder(holder: WonderViewHolder, position: Int) {
        val detail = data.get(position)
        val latitude = detail.wonderLatitude
        val longitude = detail.wonderLongitude
        val name  = detail.wonderName.toString()
        holder.wonderName.text = detail.wonderName.toString()
        holder.wonderCountryName.text = detail.wonderCountryName.toString()
        Glide.with(context).load(detail.wonderFlag).into(holder.wonderFlag)


        holder.itemView.setOnClickListener {
            val intent = Intent(context, MapsActivity::class.java)
            intent.putExtra("lat", latitude)
            intent.putExtra("long", longitude)
            intent.putExtra("name", name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}