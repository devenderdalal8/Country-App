package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.ViewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.R

class WonderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val wonderFlag = itemView.findViewById<ImageView>(R.id.flagImage)
    val wonderName = itemView.findViewById<TextView>(R.id.flagName)
    val wonderCountryName = itemView.findViewById<TextView>(R.id.area)
}