package ru.asshands.softwire.dotacounterpick.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.asshands.softwire.dotacounterpick.R
import ru.asshands.softwire.domain.models.Hero
import java.util.*

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    private val mHeroList: MutableList<Hero> = LinkedList()

    fun setData(newHeroes: List<Hero>) {
        mHeroList.clear()
        mHeroList.addAll(newHeroes)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle: TextView = itemView.findViewById(R.id.txtHeroTitle)
        private val txtAttackType: TextView = itemView.findViewById(R.id.txtHeroAttackType)
        private val imgAvatar: ImageView = itemView.findViewById(R.id.imgAvatar)

        fun bind(model: Hero) {
            txtTitle.text = model.title

            if(model.attackType == 0){
            txtAttackType.text = itemView.resources.getString(R.string.attack_type_melee)
            } else {
            txtAttackType.text = itemView.resources.getString(R.string.attack_type_ranged)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_hero, viewGroup, false)
        )
    }

    override fun getItemCount() = mHeroList.count()

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(mHeroList[position])
    }

}