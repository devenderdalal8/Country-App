package country.flages.capital.learning.map.world.guess.wallpapers.countryapp.View.ViewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import country.flages.capital.learning.map.world.guess.wallpapers.countryapp.R

class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName = itemView.findViewById<TextView>(R.id.flagName)
        var countryArea = itemView.findViewById<TextView>(R.id.area)
        var countryFlag = itemView.findViewById<ImageView>(R.id.flagImage)
    }
