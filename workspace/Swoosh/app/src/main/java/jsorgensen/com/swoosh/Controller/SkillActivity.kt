package jsorgensen.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jsorgensen.com.swoosh.Utilities.EXTRA_LEAGUE
import jsorgensen.com.swoosh.R
import jsorgensen.com.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var selectedSkill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onSkillFinishClick(view: View) {
        if(selectedSkill == ""){
            Toast.makeText(this, "Select a skill level to continue.", Toast.LENGTH_LONG).show()
            return
        }

        val finishActivity = Intent(this, FinishActivity::class.java)
        finishActivity.putExtra(EXTRA_LEAGUE, league)
        finishActivity.putExtra(EXTRA_SKILL, selectedSkill)
        startActivity(finishActivity)
    }

    fun onBeginnerClick(view: View){
        if(!beginnerSkillButton.isChecked){
            selectedSkill = ""
            return
        }

        ballerSkillButton.isChecked = false
        selectedSkill = "Beginner"
    }

    fun onBallerClick(view: View){
        if(!ballerSkillButton.isChecked){
            selectedSkill = ""
            return
        }

        beginnerSkillButton.isChecked = false
        selectedSkill = "Baller"
    }
}
