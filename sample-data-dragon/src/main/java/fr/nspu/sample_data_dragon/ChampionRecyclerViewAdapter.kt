package fr.nspu.sample_data_dragon

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.AsyncTask
import android.preference.PreferenceManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import fr.nspu.riot_api.DataDragonApi
import fr.nspu.riot_api.models.ChampionData

import fr.nspu.sample_data_dragon.ChampionsFragment.OnListFragmentInteractionListener
import fr.nspu.sample_data_dragon.databinding.FragmentChampionBinding

/**
 * [RecyclerView.Adapter] that can display a [ChampionData] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class ChampionRecyclerViewAdapter(private val mValues: List<ChampionData>,private var context: Context, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<ChampionRecyclerViewAdapter.ViewHolder>() {

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
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val language = sharedPref.getString(SettingsActivity.PREF_LANGUAGE, "")
        val version = sharedPref.getString(SettingsActivity.PREF_VERSION, "")
        DataDragonApi(version,language, context).imageService!!.getChampionSquare(holder.binding.champion!!.id!! as String, holder.binding.ivChampionSquare, mapOf("fit" to false))
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val binding: FragmentChampionBinding) : RecyclerView.ViewHolder(binding.root)
}
