package work.nbcc.questions2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import work.nbcc.questions2.databinding.ActivityMainBinding


private val ActivityMainBinding.trueButton: Any
    get() {}
private val ActivityMainBinding.question_view: TextView
    get() {}

class GameFragment : Fragment() {
    data class Question(val text: String, val answers: Boolean)

    private val questionBank:MutableList<Question> = mutableListOf(
        Question(text = "The Rick&amp;MortyThatTheShowFollowsAreOriginallyFromDimensionC-173", answers = false),
        Question(text = "Jerry\\'sStationWagonIsBasedOnTheCarFromNationalLampoon\\'sVacation?", answers =true),
        Question(text = "Rick&amp;MortyHaveAppearedInTheOpeningTitleScreenOfTheSimpsons?", answers =false),
        Question(text = "JaguarFrom\\'PickleRick\\'HadHisOwnSpinOffShowWithAdultSwim?", answers =false),
        Question(text = "TwoBrothers\\'IsTheFirstShowRick&amp;MortyWatchOnInter-DimensionalCable?", answers =true),
        Question(text = "AccordingToDanHarmon,ASchmeckleIsWorth\$148?",answers = false),
        Question(text = "TheBloomflarkIsTheUniversalCurrencyForTheGalacticFederation?", answers =true)
    )

    private var questionIndex = 0
    private lateinit var questionView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.fragment_game)

        questionView = binding.question_view
        questionView.text = questionBank[questionIndex].text



        // trueButton = findViewById(R.id.button_True)
        binding.trueButton.setOnClickListener{
            if(questionBank[questionIndex].answer){
                Toast.makeText(applicationContext, "You are right!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "You are wrong!",Toast.LENGTH_SHORT).show()
            }
        }

        falseButton = findViewById(R.id.button_False)
        falseButton.setOnClickListener{
            if(questionBank[questionIndex].answer){
                Toast.makeText(applicationContext, "You are right!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "You are wrong!",Toast.LENGTH_SHORT).show()
            }
        }

        nextButton = findViewById(R.id.imageButton_next)
        nextButton.setOnClickListener{
            questionIndex = (questionIndex + 1) % 20
            questionView.setText(questionBank[questionIndex].textResId)
        }

        lastButton = findViewById(R.id.imageButton_previous)
        lastButton.setOnClickListener{
            questionIndex = (questionIndex + 19) % 20
            questionView.setText(questionBank[questionIndex].textResId)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
}
