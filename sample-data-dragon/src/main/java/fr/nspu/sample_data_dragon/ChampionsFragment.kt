package fr.nspu.sample_data_dragon

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nspu.riot_api.DataDragonApi
import fr.nspu.riot_api.models.ChampionData
import fr.nspu.riot_api.models.ChampionListData

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
class ChampionsFragment : Fragment() {
    private var mColumnCount = 4
    private var mListener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mColumnCount = arguments!!.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_champion_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            if (mColumnCount <= 1) {
                view.layoutManager = LinearLayoutManager(context)
            } else {
                view.layoutManager = GridLayoutManager(context, mColumnCount)
            }
            ChampionsAsync(view).execute()

        }
        return view
    }

    inner class ChampionsAsync(val view :RecyclerView) : AsyncTask<Unit, Unit, ChampionListData>() {
        override fun doInBackground(vararg params: Unit?): ChampionListData {
            val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
            val language = sharedPref.getString(SettingsActivity.PREF_LANGUAGE, "")
            val version = sharedPref.getString(SettingsActivity.PREF_VERSION, "")
            return  DataDragonApi(version,language, context).dataDragonService.getChampions()!!

        }

        override fun onPostExecute(result: ChampionListData?) {
            super.onPostExecute(result)
            view.adapter = ChampionRecyclerViewAdapter(result!!.data!!.values.toList(),context!!, mListener)
        }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: ChampionData)
    }

    companion object {

        private val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(columnCount: Int): ChampionsFragment {
            val fragment = ChampionsFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }

        val TAG: String? = "ChampionsFragment"
    }
}
