package pl.bartekpawlowski.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Questions

    private EditText question3;
    private EditText question6;

    private RadioGroup question1;
    private RadioGroup question5;
    private RadioGroup question7;

    private CheckBox[] question2;
    private CheckBox[] question4;

    // Answers

    private int answer1;
    private int[] answer2 = new int[2];
    private String answer3 = "findviewbyid";
    private int[] answer4 = new int[2];
    private int answer5;
    private String answer6 = "maxlines";
    private int answer7;

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

        // Checkbox views grouped in Map by question
        question2 = new CheckBox[4];
        question2[0] = (CheckBox) findViewById(R.id.question_2_button);
        question2[1] = (CheckBox) findViewById(R.id.question_2_cl);
        question2[2] = (CheckBox) findViewById(R.id.question_2_rl);
        question2[3] = (CheckBox) findViewById(R.id.question_2_view);

        question4 = new CheckBox[4];
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

        return Objects.equals(userAnswer, answer);
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

    public void submitScore(View view) {

    }
}
