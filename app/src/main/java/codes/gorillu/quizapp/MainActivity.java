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

    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method checks the status of the responses
     */

    public void getAnswers(View view) {

        // Get answers for question one

        RadioButton troopsRadioButton = findViewById(R.id.quest_one_troop);
        boolean isTroops = troopsRadioButton.isChecked();


        // Get answers for question two
        EditText answerField = findViewById(R.id.answer_field);
        String answer = answerField.getText().toString();


        // Get answers for question three

        RadioButton ageThreeRadioButton = findViewById(R.id.question_age_three);
        boolean isAgeThree = ageThreeRadioButton.isChecked();


        // Get answers for question four
        CheckBox earthquakesCheckBox = findViewById(R.id.question_four_earthquakes);
        boolean isEarthquakes = earthquakesCheckBox.isChecked();

        CheckBox otherGorillasCheckBox = findViewById(R.id.question_four_other_gorillas);
        boolean isOtherGorillas = otherGorillasCheckBox.isChecked();

        CheckBox humansCheckBox = findViewById(R.id.question_four_humans);
        boolean isHumansChecked = humansCheckBox.isChecked();

        int score = checkAnswers(isTroops, answer, isAgeThree, isHumansChecked, isEarthquakes, isOtherGorillas);

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

        if (answer.equalsIgnoreCase(getString(R.string.silverback_gorilla)) || answer.equals(getString(R.string.silverback))) {
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




        return score + correctAnswers;
    }

    /**
     * This method displays the total score on the screen when the button is clicked
     */


    private void displayScore(String message, int score) {
        TextView scoreTextView = findViewById(R.id.total_score);
        scoreTextView.setText(message);
        Toast.makeText(this, "Your total score is " + score, Toast.LENGTH_LONG).show();
    }


}
