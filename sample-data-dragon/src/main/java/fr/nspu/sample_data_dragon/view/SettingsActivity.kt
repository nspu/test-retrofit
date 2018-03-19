package fr.nspu.sample_data_dragon.view

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.media.RingtoneManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.preference.ListPreference
import android.preference.Preference
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.preference.RingtonePreference
import android.text.TextUtils
import android.view.MenuItem
import fr.nspu.riot_api.DataDragonApi
import fr.nspu.sample_data_dragon.R

/**
 * A [PreferenceActivity] that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 *
 * See [Android Design: Settings](http://developer.android.com/design/patterns/settings.html)
 * for design guidelines and the [Settings API Guide](http://developer.android.com/guide/topics/ui/settings.html)
 * for more information on developing a Settings UI.
 */
class SettingsActivity : AppCompatPreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActionBar()
    }

    /**
     * Set up the [android.app.ActionBar], if the API is available.
     */
    private fun setupActionBar() {
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * {@inheritDoc}
     */
    override fun onIsMultiPane(): Boolean {
        return isXLargeTablet(this)
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    override fun isValidFragment(fragmentName: String): Boolean {
        return PreferenceFragment::class.java.name == fragmentName
                || PreferencesFragment::class.java.name == fragmentName
    }

    /**
     * This fragment shows general preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    class PreferencesFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.preferences)
            setHasOptionsMenu(true)

            val listLanguagesPreference: ListPreference = findPreference(PREF_LANGUAGE) as ListPreference
            bindPreferenceSummaryToValue(listLanguagesPreference)
            listLanguagesPreference.summary = listLanguagesPreference.value
            GetLanguageAsync(listLanguagesPreference).execute()


            val listVersionsPreference:ListPreference = findPreference(PREF_VERSION) as ListPreference
            bindPreferenceSummaryToValue(listVersionsPreference)
            listVersionsPreference.summary = listVersionsPreference.value
            GetVersionAsync(listVersionsPreference).execute()
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            val id = item.itemId
            if (id == android.R.id.home) {
                startActivity(Intent(activity, SettingsActivity::class.java))
                return true
            }
            return super.onOptionsItemSelected(item)
        }

        inner class GetLanguageAsync(val preference: ListPreference) : AsyncTask<Unit, Unit, List<String>>() {

            var mDialog: ProgressDialog? = null

            override fun onPreExecute() {
                super.onPreExecute()
                mDialog = ProgressDialog.show(activity, "",
                        "Loading", true)
            }

            override fun doInBackground(vararg params: Unit?): List<String>? {
                var languages = DataDragonApi("","",activity).dataDragonService.getLanguages()
                return languages
            }

            override fun onPostExecute(result: List<String>?) {
                super.onPostExecute(result)
                preference.entries = result!!.toTypedArray()
                preference.entryValues = result!!.toTypedArray()
                mDialog!!.cancel()
            }

            override fun onCancelled(result: List<String>?) {
                super.onCancelled(result)
                mDialog!!.cancel()
            }
        }

        inner class GetVersionAsync(val preference: ListPreference) : AsyncTask<Unit, Unit, List<String>>() {

            var mDialog: ProgressDialog? = null

            override fun onPreExecute() {
                super.onPreExecute()
                mDialog = ProgressDialog.show(activity, "",
                        "Loading", true)
            }

            override fun doInBackground(vararg params: Unit?): List<String>? {
                var languages = DataDragonApi("", "",activity).dataDragonService.getVersions()
                return languages
            }

            override fun onPostExecute(result: List<String>?) {
                super.onPostExecute(result)
                preference.entries = result!!.toTypedArray()
                preference.entryValues = result!!.toTypedArray()
                mDialog!!.cancel()
            }

            override fun onCancelled(result: List<String>?) {
                super.onCancelled(result)
                mDialog!!.cancel()
            }
        }
    }

    companion object {

        const val PREF_LANGUAGE = "language"
        const val PREF_VERSION = "version"

        /**
         * A preference value change listener that updates the preference's summary
         * to reflect its new value.
         */
        private val sBindPreferenceSummaryToValueListener = Preference.OnPreferenceChangeListener { preference, value ->
            val stringValue = value.toString()

            if (preference is ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                val listPreference = preference
                val index = listPreference.findIndexOfValue(stringValue)

                // Set the summary to reflect the new value.
                preference.setSummary(
                        if (index >= 0)
                            listPreference.entries[index]
                        else
                            null)

            } else if (preference is RingtonePreference) {
                // For ringtone preferences, look up the correct display value
                // using RingtoneManager.
                if (TextUtils.isEmpty(stringValue)) {
                    // Empty values correspond to 'silent' (no ringtone).
                    preference.setSummary(R.string.pref_ringtone_silent)

                } else {
                    val ringtone = RingtoneManager.getRingtone(
                            preference.getContext(), Uri.parse(stringValue))

                    if (ringtone == null) {
                        // Clear the summary if there was a lookup error.
                        preference.setSummary(null)
                    } else {
                        // Set the summary to reflect the new ringtone display
                        // name.
                        val name = ringtone.getTitle(preference.getContext())
                        preference.setSummary(name)
                    }
                }

            } else {
                // For all other preferences, set the summary to the value's
                // simple string representation.
                preference.summary = stringValue
            }
            true
        }

        /**
         * Helper method to determine if the device has an extra-large screen. For
         * example, 10" tablets are extra-large.
         */
        private fun isXLargeTablet(context: Context): Boolean {
            return context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_XLARGE
        }

        /**
         * Binds a preference's summary to its value. More specifically, when the
         * preference's value is changed, its summary (line of text below the
         * preference title) is updated to reflect the value. The summary is also
         * immediately updated upon calling this method. The exact display format is
         * dependent on the type of preference.

         * @see .sBindPreferenceSummaryToValueListener
         */
        private fun bindPreferenceSummaryToValue(preference: Preference) {
            // Set the listener to watch for value changes.
            preference.onPreferenceChangeListener = sBindPreferenceSummaryToValueListener

            // Trigger the listener immediately with the preference's
            // current value.
            sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                    PreferenceManager
                            .getDefaultSharedPreferences(preference.context)
                            .getString(preference.key, ""))
        }
    }
}
