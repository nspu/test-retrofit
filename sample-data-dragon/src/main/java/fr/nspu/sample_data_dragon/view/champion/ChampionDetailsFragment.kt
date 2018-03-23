package fr.nspu.sample_data_dragon.view.champion


import android.app.ProgressDialog
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nspu.riot_api.DataDragonApi
import fr.nspu.riot_api.models.ChampionData
import fr.nspu.riot_api.models.ChampionListData
import fr.nspu.sample_data_dragon.R
import fr.nspu.sample_data_dragon.databinding.FragmentChampionDetailsBinding
import fr.nspu.sample_data_dragon.view.SettingsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [ChampionDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChampionDetailsFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.btnAbilities.id -> mListener?.onListFragmentInteraction(champion!!, ChampionSubEnum.Abilities)
            binding.btnSkins.id -> mListener?.onListFragmentInteraction(champion!!, ChampionSubEnum.Skins)
            binding.btnAllytips.id -> mListener?.onListFragmentInteraction(champion!!, ChampionSubEnum.AlliTips)
            binding.btnEnnemytips.id -> mListener?.onListFragmentInteraction(champion!!, ChampionSubEnum.EnemyTips)
            binding.btnLore.id -> mListener?.onListFragmentInteraction(champion!!, ChampionSubEnum.Lore)
        }
    }

    private var nameChampion: String? = null
    private var champion: ChampionData? = null
    private lateinit var binding: FragmentChampionDetailsBinding
    private var mListener: OnListFragmentInteractionListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            nameChampion = arguments!!.getString(ARG_NAME_CHAMPION)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_champion_details, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val language = sharedPref.getString(SettingsActivity.PREF_LANGUAGE, "")
        val version = sharedPref.getString(SettingsActivity.PREF_VERSION, "")
        var dataDragonApi = DataDragonApi(version, language, context)
        var progressDialog: ProgressDialog = ProgressDialog.show(context, "", "loading...", true);
        dataDragonApi.dataDragonService.getChampion((nameChampion!!) )!!.enqueue( object : Callback<ChampionListData> {


            override fun onFailure(call: Call<ChampionListData>?, t: Throwable?) {
                progressDialog.cancel()
            }

            override fun onResponse(call: Call<ChampionListData>?, response: Response<ChampionListData>?) {
                champion = response!!.body()!!.data!!.get(nameChampion!!)
                activity!!.runOnUiThread{
                    image()
                }
                progressDialog.cancel()
            }
        })
    }

    fun image() {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val language = sharedPref.getString(SettingsActivity.PREF_LANGUAGE, "")
        val version = sharedPref.getString(SettingsActivity.PREF_VERSION, "")
        var dataDragonApi = DataDragonApi(version, language, activity)
        binding.tvName.text = nameChampion
        binding.btnAbilities!!.setOnClickListener(this@ChampionDetailsFragment)
        binding.btnSkins!!.setOnClickListener(this@ChampionDetailsFragment)
        binding.btnAllytips!!.setOnClickListener(this@ChampionDetailsFragment)
        binding.btnEnnemytips!!.setOnClickListener(this@ChampionDetailsFragment)
        binding.btnLore!!.setOnClickListener(this@ChampionDetailsFragment)
        dataDragonApi.imageService.getLoadingScreenArt(this.champion!!.name!!, 0, binding.ivLoadingSplach)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnChampionSkinsFragmentInteractionListener")
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
        fun onListFragmentInteraction(item: ChampionData, sub: ChampionSubEnum)
    }

    companion object {
        private val ARG_NAME_CHAMPION = "name-champion"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment ChampionDetailsFragment.
         */
        fun newInstance(nameChampion: String): ChampionDetailsFragment {
            val fragment = ChampionDetailsFragment()
            val args = Bundle()
            args.putString(ARG_NAME_CHAMPION, nameChampion)
            fragment.arguments = args
            return fragment
        }

        val TAG: String? = "ChampionDetailsFragment"

    }

}
