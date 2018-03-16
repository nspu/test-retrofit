package fr.nspu.sample_data_dragon

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import fr.nspu.riot_api.models.ChampionData

import fr.nspu.sample_data_dragon.ChampionsFragment.OnListFragmentInteractionListener
import fr.nspu.sample_data_dragon.databinding.FragmentChampionBinding

/**
 * [RecyclerView.Adapter] that can display a [ChampionData] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class ChampionRecyclerViewAdapter(private val mValues: List<ChampionData>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<ChampionRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: FragmentChampionBinding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.fragment_champion,
                        parent,
                        false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.champion = mValues.get(position)
        holder.itemView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.binding.champion!!)
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val binding: FragmentChampionBinding) : RecyclerView.ViewHolder(binding.root) {
        override fun toString(): String {
            return super.toString() + " '" + binding!!.champion!!.name + "'"
        }
    }
}
