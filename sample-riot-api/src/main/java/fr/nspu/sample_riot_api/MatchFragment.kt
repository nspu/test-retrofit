package fr.nspu.sample_riot_api

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nspu.riot_api.models.MatchList
import fr.nspu.riot_api.models.MatchReference


/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class MatchFragment() : Fragment() {
    private var mListener: OnListFragmentInteractionListener? = null
    private var mName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_matchitem_list, container, false)
        mName  = arguments!!.getString(ARG_NAME)
        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            val recyclerView = view as RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(context)
            GetMatchsAsync(recyclerView).execute()
        }
        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    inner class GetMatchsAsync(var recyclerView: RecyclerView) : AsyncTask<Unit, Unit, MatchList>() {
        var mDialog: ProgressDialog? = null

        override fun onPreExecute() {
            super.onPreExecute()
            mDialog = ProgressDialog.show(context, "",
                    "Loading", true)
        }

        override fun onPostExecute(matchs: MatchList?) {
            super.onPostExecute(matchs)
            recyclerView!!.adapter = MatchItemAdapter(matchs!!, MatchFragment().mListener, context!!)
            mDialog!!.cancel()

        }

        override fun doInBackground(vararg params: Unit?): MatchList? {
            var matchs:MatchList? = null
            try {

                var account = RiotService.instance!!.riotApi.summonerService.getSummonerByName(mName!!)

                if (account == null) {
                    Throwable("User not find")
                }

                matchs = RiotService.instance!!.riotApi.matchService.getMatchListByAccountId(account!!.accountId!!)

                if(matchs == null){
                    Throwable("No match")
                }


            } catch (e: Exception) {
                cancel(true)
                Snackbar.make(recyclerView!!, e.message.toString(), Snackbar.LENGTH_LONG)
                        .setAction("Ok") { v -> }.show()
            }
            return matchs
        }

        override fun onCancelled(result: MatchList?) {
            super.onCancelled(result)
            mDialog!!.cancel()
        }


    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: MatchReference)
    }

    companion object {
        val ARG_NAME = "summoner-name"

        fun newInstance(name: String): MatchFragment {
            val fragment = MatchFragment()
            val args = Bundle()
            args.putString(ARG_NAME, name)
            fragment.arguments = args
            return fragment
        }

        val TAG: String = "CHAMPION_FRAGMENT_TAG"
    }
}
