package fr.nspu.riot_api_android

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import fr.nspu.riot_api.models.MatchList
import fr.nspu.riot_api.models.MatchReference

import fr.nspu.riot_api_android.MatchFragment.OnListFragmentInteractionListener
import fr.nspu.riot_api_android.databinding.FragmentMatchitemBinding
import java.util.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MatchItemAdapter(matches: MatchList, private val mListener: OnListFragmentInteractionListener?, val mContext: Context) : RecyclerView.Adapter<MatchItemAdapter.ViewHolder>() {
    private var mMatches: List<MatchReference>? = null

    init {
        mMatches = matches.matches
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var mBinding: FragmentMatchitemBinding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.fragment_matchitem,
                        parent
                        , false
                )
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mBinding.match = mMatches!![position]
        holder.mBinding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return mMatches!!.size
    }

    inner class ViewHolder(val mBinding: FragmentMatchitemBinding) : RecyclerView.ViewHolder(mBinding.root)
}
