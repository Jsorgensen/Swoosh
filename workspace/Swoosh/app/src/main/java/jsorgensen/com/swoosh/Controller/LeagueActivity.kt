package jsorgensen.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import jsorgensen.com.swoosh.Model.Player
import jsorgensen.com.swoosh.R
import jsorgensen.com.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun leagueActivityNext(view: View) {
        if (player.league == ""){
            Toast.makeText(this, "Select a league to continue.", Toast.LENGTH_LONG).show()
            return
        }

        val skillActivity = Intent(this, SkillActivity::class.java)
        skillActivity.putExtra(EXTRA_PLAYER, player)
        startActivity(skillActivity)
    }

    fun mensButtonOnClick(view: View){
        if(!mensLeagueButton.isChecked){
            player.league = ""
            return
        }

        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        player.league = "Mens"
    }

    fun womensButtonOnClick(veiw:View){
        if(!womensLeagueButton.isChecked){
            player.league = ""
            return
        }

        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        player.league = "Womens"
    }

    fun coedButtonOnClick(view: View){
        if(!coedLeagueButton.isChecked){
            player.league = ""
            return
        }

        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false

        player.league = "Co-ed"
    }
}
