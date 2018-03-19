package fr.nspu.sample_data_dragon.view.champion

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Parcelable
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nspu.riot_api.DataDragonApi
import fr.nspu.riot_api.models.ChampionPassive
import fr.nspu.sample_data_dragon.R
import fr.nspu.riot_api.models.ChampionSpell
import fr.nspu.sample_data_dragon.databinding.ContainerAbilityBinding
import fr.nspu.sample_data_dragon.databinding.FragmentAbilitiesBinding
import fr.nspu.sample_data_dragon.view.SettingsActivity
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AbilitiesFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AbilitiesFragment.newInstance] factory method to
 * create an instance of thisfragment.
 */
class AbilitiesFragment : Fragment() {
    private var mChampionSpells: List<ChampionSpell>? = null
    private var mChampionPassif: ChampionPassive? = null
    private lateinit var mBinding: FragmentAbilitiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mChampionSpells = arguments!!.getParcelableArrayList<ChampionSpell>(ARG_CHAMPION_SPELLS)
            mChampionPassif = arguments!!.getParcelable(ARG_CHAMPION_PASSIF)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_abilities, container, false)

        displayPassif(mBinding, mChampionPassif!!)
        displaySpell("Q",mBinding.incQ!!, mChampionSpells!!.get(0))
        displaySpell("W",mBinding.incW!!, mChampionSpells!!.get(1))
        displaySpell("E",mBinding.incE!!, mChampionSpells!!.get(2))
        displaySpell("R",mBinding.incR!!, mChampionSpells!!.get(3))

        return mBinding.root
    }

    private fun displaySpell(key:String, binding:ContainerAbilityBinding, championSpell: ChampionSpell){
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val language = sharedPref.getString(SettingsActivity.PREF_LANGUAGE, "")
        val version = sharedPref.getString(SettingsActivity.PREF_VERSION, "")
        var dataDragonApi = DataDragonApi(version, language, context)
        dataDragonApi.imageService.getChampionAbility(championSpell.image!!.full!!, binding.ivAbility)

        binding.tvName.text = Html.fromHtml(key + " " + championSpell.name)
        binding.tvDescription.text =  Html.fromHtml(championSpell.description)
        binding.tvRange.text = championSpell.range!!.joinToString()
        binding.tvCooldown.text = championSpell.cooldown!!.joinToString()
        binding.tvCost.text = championSpell.cost!!.joinToString()
    }

    private fun displayPassif(binding:FragmentAbilitiesBinding, championPassif: ChampionPassive){
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val language = sharedPref.getString(SettingsActivity.PREF_LANGUAGE, "")
        val version = sharedPref.getString(SettingsActivity.PREF_VERSION, "")
        var dataDragonApi = DataDragonApi(version, language, context)
        dataDragonApi.imageService.getPassiveAbility(championPassif.image!!.full!!, binding.ivAbilityPassif)
        binding!!.tvNamePassif.text = championPassif.name
        binding!!.tvDescriptionPassif.text = Html.fromHtml(championPassif.description)
    }

    companion object {
        private val ARG_CHAMPION_SPELLS = "championSpells"
        private val ARG_CHAMPION_PASSIF = "championPassif"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param championSpells liste of abilities.
         * @return A new instance of fragment AbilitiesFragment.
         */
        fun newInstance(championSpells: List<Any>, passive: ChampionPassive): AbilitiesFragment {
            val fragment = AbilitiesFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_CHAMPION_SPELLS, championSpells as ArrayList<out Parcelable>)
            args.putParcelable(ARG_CHAMPION_PASSIF, passive)
            fragment.arguments = args
            return fragment
        }
    }
}
