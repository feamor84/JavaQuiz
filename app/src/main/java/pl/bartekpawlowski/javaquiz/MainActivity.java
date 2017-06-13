package pl.bartekpawlowski.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Questions

    private EditText question3;
    private EditText question6;

    private RadioGroup question1;
    private RadioGroup question5;
    private RadioGroup question7;

    private CheckBox[] question2 = new CheckBox[4];
    private CheckBox[] question4 = new CheckBox[4];

    // Answers

    private int answer1;
    private int[] answer2 = new int[2];
    private static final String answer3 = "findviewbyid";
    private int[] answer4 = new int[2];
    private int answer5;
    private static final String answer6 = "maxlines";
    private int answer7;

    // Score
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText views
        question3 = (EditText) findViewById(R.id.question_3_method);
        question6 = (EditText) findViewById(R.id.question_6_attribute);

        // RadioGroup views
        question1 = (RadioGroup) findViewById(R.id.question_1_radio_group);
        question5 = (RadioGroup) findViewById(R.id.question_5_radio_group);
        question7 = (RadioGroup) findViewById(R.id.question_7_radio_group);

        // Checkbox views grouped in CheckBox Array by question
        question2[0] = (CheckBox) findViewById(R.id.question_2_button);
        question2[1] = (CheckBox) findViewById(R.id.question_2_cl);
        question2[2] = (CheckBox) findViewById(R.id.question_2_rl);
        question2[3] = (CheckBox) findViewById(R.id.question_2_view);

        question4[0] = (CheckBox) findViewById(R.id.question_4_activity_main_xml);
        question4[1] = (CheckBox) findViewById(R.id.question_4_android_manifest_xml);
        question4[2] = (CheckBox) findViewById(R.id.question_4_main_activity_java);
        question4[3] = (CheckBox) findViewById(R.id.question_4_strings_xml);

        // Answers
        answer1 = R.id.question_1_15;
        answer5 = R.id.question_5_padding;
        answer7 = R.id.question_7_ics;

        answer2[0] = R.id.question_2_rl;
        answer2[1] = R.id.question_2_cl;

        answer4[0] = R.id.question_4_activity_main_xml;
        answer4[1] = R.id.question_4_strings_xml;

    }

    /**
     *
     * Method get text from chosen EditText input
     *
     * @param
     * @return String - text from EditText input, in lowercase and trimed
     *
     */

    private String getTextFromEditText(EditText editText) {

        return editText.getText().toString().toLowerCase().trim();
    }


    /**
     *
     * @param userAnswer - String form users input
     * @param answer = String with right answer
     * @return true if Strings are equal, otherwise false
     *
     */

    private boolean compareStrings(String userAnswer, String answer) {

        if(userAnswer != null) {
            return userAnswer.equals(answer);
        }

        return false;
    }

    /**
     *
     * Method return selected id of RadioButton
     * @param radioGroup = RadioGroup which will be checked
     * @return int of selected RadioButton or -1 if nothing is checked
     *
     */

    private int getSelectedRadioButtonId(RadioGroup radioGroup) {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        return selectedId;
    }

    /**
     *
     * @param checkBoxGroup - array of CheckBoxes from one question
     * @return List<Integer> with all ids of checked boxes
     *
     */

    private List<Integer> getSelectedCheckbox(CheckBox[] checkBoxGroup) {
        List<Integer> checked = new ArrayList<Integer>();

        for(int i = 0; i < checkBoxGroup.length; i++) {
            if(checkBoxGroup[i].isChecked()) {
                checked.add(checkBoxGroup[i].getId());
            }
        }

        return checked;
    }

    /**
     *
     * @param userAnswer - list of all ids checked boxes from user
     * @param answer - array of correct answers ids
     * @return - 0 if user check correct and incorrect answer, 0 don't check all correct answers, int if check all correct answers
     *
     */

    private int calculateCheckboxScore(List<Integer> userAnswer, int[] answer) {
        int correctAnswers = 0;

        if(userAnswer.size() != answer.length) {
            return 0;
        }

        for(int i = 0; i < answer.length; i++) {
            if(userAnswer.contains(answer[i])) {
                correctAnswers++;
            } else {
                return 0;
            }
        }

        return correctAnswers;

    }

    /**
     *
     * @param score - value of users score
     * @return = String to be displayed in Toast
     *
     */

    private String setSubmitScoreText(int score) {
        String text = "";

        text += getText(R.string.your_score_is);
        text += " ";
        text += new Integer(score).toString();

        return text;
    }

    /**
     *
     * @param view - handle Submit button action, check all questions answers
     *
     */

    public void submitScore(View view) {

        score = 0;

        // Question 1
        if(getSelectedRadioButtonId(question1) == answer1) {
            score += 10;
        }

        // Question 2
        score += (calculateCheckboxScore(getSelectedCheckbox(question2), answer2) * 5);

        // Question 3
        if(compareStrings(getTextFromEditText(question3), answer3)) {
            score += 10;
        }

        // Question 4
        score += (calculateCheckboxScore(getSelectedCheckbox(question4), answer4) * 5);

        // Question 5
        if(getSelectedRadioButtonId(question5) == answer5) {
            score += 10;
        }

        // Question 6
        if(compareStrings(getTextFromEditText(question6), answer6)) {
            score += 10;
        }

        // Question 7
        if(getSelectedRadioButtonId(question7) == answer7) {
            score += 10;
        }

        Toast toast = Toast.makeText(this, setSubmitScoreText(score), Toast.LENGTH_LONG);
        toast.show();

    }
}
