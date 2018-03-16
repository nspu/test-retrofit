package fr.nspu.sample_data_dragon

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import fr.nspu.riot_api.models.ChampionData
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ChampionsFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

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

    fun initChamptionsFragment() {
        val fragment = ChampionsFragment.newInstance(4)
        supportFragmentManager.beginTransaction()
                .add(R.id.fl_container, fragment, ChampionsFragment.TAG)
                .commit()
    }

    override fun onListFragmentInteraction(item: ChampionData) {

    }

}
