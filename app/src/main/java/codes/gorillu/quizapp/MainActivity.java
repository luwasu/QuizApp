package codes.gorillu.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This quiz app lets you learn about gorillas by answering interesting questions
 */

public class MainActivity extends AppCompatActivity {


    private int answerOneId;
    private int answerTwoId;
    private int answerThreeId;
    private int answerFourFirstId;
    private int answerFourSecondId;
    private int answerFourThirdId;
    private int displayMessageId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve all View ID`s to make the the application more efficient
        answerOneId = R.id.quest_one_troop;
        answerTwoId = R.id.answer_field;
        answerThreeId = R.id.question_age_three;
        answerFourFirstId = R.id.question_four_humans;
        answerFourSecondId = R.id.question_four_earthquakes;
        answerFourThirdId = R.id.question_four_other_gorillas;
        displayMessageId = R.id.total_score;

    }

    /**
     * This method checks the status of the responses
     */

    public void getAnswers(View view) {

        // Get answers for question one
        RadioButton troopsRadioButton = findViewById(answerOneId);
        boolean isTroops = troopsRadioButton.isChecked();

        // Get answers for question two
        EditText answerField = findViewById(answerTwoId);
        String answer = answerField.getText().toString().trim();

        // Get answers for question three
        RadioButton ageThreeRadioButton = findViewById(answerThreeId);
        boolean isAgeThree = ageThreeRadioButton.isChecked();

        // Get answers for question four
        CheckBox humansCheckBox = findViewById(answerFourFirstId);
        boolean isHumansChecked = humansCheckBox.isChecked();

        CheckBox earthquakesCheckBox = findViewById(answerFourSecondId);
        boolean isEarthquakes = earthquakesCheckBox.isChecked();

        CheckBox otherGorillasCheckBox = findViewById(answerFourThirdId);
        boolean isOtherGorillas = otherGorillasCheckBox.isChecked();


        // set score variable to be passed to displayScore
        int score = checkAnswers(isTroops, answer, isAgeThree, isHumansChecked, isEarthquakes, isOtherGorillas);

        // set
        displayScore(getString(R.string.display_score_part_one) + score + getString(R.string.display_score_part_two), score);

    }


    /**
     * @param isTroops        correct answer for question one
     * @param answer          correct answer for question two
     * @param isAgeThree      correct answer for question three
     * @param isEarthquakes   correct answer for question four
     * @param isOtherGorillas correct answer for question four
     * @return total score for correct answered questions
     */


    private int checkAnswers(boolean isTroops, String answer, boolean isAgeThree, boolean isHumansChecked, boolean isEarthquakes, boolean isOtherGorillas) {
        int correctAnswers = 0;

        // Check if question one is correct and add score
        if (isTroops) {
            correctAnswers++;
        }

        // Check if question two is correct and add score

        if (answer.equalsIgnoreCase(getString(R.string.silverback_gorilla)) || answer.equalsIgnoreCase(getString(R.string.silverback))) {
            correctAnswers++;
        }

        // Check if question three is correct and add score
        if (isAgeThree) {
            correctAnswers++;
        }

        // Check if question four has the false answer checked
        if (isHumansChecked) {
            correctAnswers--;
        }


        // Check if question four is correct
        if (isOtherGorillas) {
            correctAnswers++;
        }

        // Check if question four is correct
        if (isEarthquakes) {
            correctAnswers++;
        }


        // Check if question is smaller then 0 and set it to be 0
        if (correctAnswers <= 0) {
            correctAnswers = 0;
        }


        return correctAnswers;
    }

    /**
     * This method displays the total score on the screen when the button is clicked
     */
    private void displayScore(String message, int score) {
        TextView scoreTextView = findViewById(displayMessageId);
        scoreTextView.setText(message);

        // Toast to display score for when the score button is pressed
        Toast.makeText(this, getString(R.string.toast_message) + score, Toast.LENGTH_LONG).show();
    }
}
