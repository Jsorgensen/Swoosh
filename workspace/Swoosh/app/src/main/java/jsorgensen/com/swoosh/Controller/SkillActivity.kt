package jsorgensen.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jsorgensen.com.swoosh.Model.Player
import jsorgensen.com.swoosh.R
import jsorgensen.com.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onSkillFinishClick(view: View) {
        if(player.skill == ""){
            Toast.makeText(this, "Select a skill level to continue.", Toast.LENGTH_LONG).show()
            return
        }

        val finishActivity = Intent(this, FinishActivity::class.java)
        finishActivity.putExtra(EXTRA_PLAYER, player)
        startActivity(finishActivity)
    }

    fun onBeginnerClick(view: View){
        if(!beginnerSkillButton.isChecked){
            player.skill = ""
            return
        }

        ballerSkillButton.isChecked = false
        player.skill = "Beginner"
    }

    fun onBallerClick(view: View){
        if(!ballerSkillButton.isChecked){
            player.skill = ""
            return
        }

        beginnerSkillButton.isChecked = false
        player.skill = "Baller"
    }
}
