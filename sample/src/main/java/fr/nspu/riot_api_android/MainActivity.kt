package fr.nspu.riot_api_android


import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import fr.nspu.riot_api_android.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        RiotService.init(getString(R.string.riotkey))

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var i :Intent = Intent(this, MatchActivity::class.java)
        startActivity(i)

        binding.lContent!!.button.setOnClickListener(View.OnClickListener { v ->
            var i :Intent = Intent(this, MatchActivity::class.java)
            startActivity(i)
        })
    }

}
