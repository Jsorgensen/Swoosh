package jsorgensen.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jsorgensen.com.swoosh.Utilities.EXTRA_LEAGUE
import jsorgensen.com.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueActivityNext(view: View) {
        if (selectedLeague == ""){
            Toast.makeText(this, "Select a league to continue.", Toast.LENGTH_LONG).show()
            return
        }

        val skillActivity = Intent(this, SkillActivity::class.java)
        skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
        startActivity(skillActivity)
    }

    fun mensButtonOnClick(view: View){
        if(!mensLeagueButton.isChecked){
            selectedLeague = ""
            return
        }

        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        selectedLeague = "Mens"
    }

    fun womensButtonOnClick(veiw:View){
        if(!womensLeagueButton.isChecked){
            selectedLeague = ""
            return
        }

        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        selectedLeague = "Womens"
    }

    fun coedButtonOnClick(view: View){
        if(!coedLeagueButton.isChecked){
            selectedLeague = ""
            return
        }

        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false

        selectedLeague = "Co-ed"
    }
}
