package fr.nspu.sample_data_dragon.view.champion

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import fr.nspu.riot_api.models.ChampionData
import fr.nspu.sample_data_dragon.R
import fr.nspu.sample_data_dragon.view.SettingsActivity


class MainActivity : AppCompatActivity(),
        ChampionsFragment.OnChampionsFragmentInteractionListener,
        ChampionDetailsFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initChamptionsFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                intent.putExtra(PreferenceActivity.EXTRA_SHOW_FRAGMENT, SettingsActivity.PreferencesFragment::class.java!!.getName())
                intent.putExtra(PreferenceActivity.EXTRA_NO_HEADERS, true)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount != 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    override fun onListFragmentInteraction(item: ChampionData, sub: ChampionSubEnum) {
        when (sub) {
            ChampionSubEnum.Abilities -> openAbilitiesFragment(item)
            ChampionSubEnum.Skins-> openChampionSkinsFragment(item)
        }
    }

    override fun onChampionsFragmentInteraction(item: ChampionData) {
        val fragment = ChampionDetailsFragment.newInstance(item.nameKey!!)
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out,
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out)
                .replace(R.id.fl_container, fragment, ChampionDetailsFragment.TAG)
                .addToBackStack(ChampionDetailsFragment.TAG)
                .commit()
    }

    fun initChamptionsFragment() {
        val fragment = ChampionsFragment.newInstance(4)
        supportFragmentManager.beginTransaction()
                .add(R.id.fl_container, fragment, ChampionsFragment.TAG)
                .commit()
    }

    fun openAbilitiesFragment(championData: ChampionData) {
        val fragment = AbilitiesFragment.newInstance(championData.spells!!, championData.passive!!)
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out,
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out)
                .replace(R.id.fl_container, fragment, ChampionDetailsFragment.TAG)
                .addToBackStack(ChampionDetailsFragment.TAG)
                .commit()
    }

    fun openChampionSkinsFragment(championData: ChampionData) {
        val fragment = ChampionSkinsFragment.newInstance(championData.skins!!, championData.nameKey!!)
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out,
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out)
                .replace(R.id.fl_container, fragment, ChampionDetailsFragment.TAG)
                .addToBackStack(ChampionDetailsFragment.TAG)
                .commit()
    }

}
