package com.example.android.blooddonorchecklist;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Context context;
    LinearLayout mainGroup;
    LinearLayout firstPart;
    LinearLayout secondPart;
    LinearLayout thirdPart;
    LinearLayout fourthPart;
    LinearLayout fifthPart;
    LinearLayout sixthPart;
    LinearLayout seventhPart;
    LinearLayout eighthPart;
    LinearLayout ninthPart;
    LinearLayout tenthPart;
    LinearLayout eleventhPart;
    LinearLayout twelfthPart;
    LinearLayout thirteenPart;
    LinearLayout fourteenPart;
    LinearLayout fifteenPart;
    LinearLayout quizEntry;
    LinearLayout quiz6;
    LinearLayout quiz7;
    LinearLayout hepaVacine;
    LinearLayout otherVacine;
    LinearLayout malariaGroup1;
    LinearLayout malariaGroup2;
    ProgressBar progressBar;
    Button nextButton;
    int questionProgess;
    TextView textView;
    String result;
    Boolean success;
    Boolean isFemale = false;
    String[] malaria_countries = {
            "Afghanistan",
            "Algeria",
            "Angola",
            "Argentina",
            "Azerbaijan",
            "Bangladesh",
            "Belize",
            "Benin",
            "Bhutan",
            "Bolivia",
            "Botswana",
            "Brazil",
            "Burkina Faso",
            "Burundi",
            "Cambodia",
            "Cameroon",
            "Cape Verde",
            "Central African Republic",
            "Chad",
            "China",
            "Colombia",
            "Comoros",
            "Congo",
            "Costa Rica",
            "Côte d'Ivoire",
            "Democratic Republic of The Congo",
            "Djibouti",
            "Dominican Republic	Caribbean",
            "DPR Korea",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Ethiopia",
            "French Guiana",
            "Gabon",
            "Gambia",
            "Ghana",
            "Guatemala",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Honduras",
            "India",
            "Indonesia",
            "Iran",
            "Iraq",
            "Jamaica",
            "Kenya",
            "Kyrgyzstan",
            "Lao People's Democratic Republic",
            "Lao",
            "Liberia",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Mali",
            "Mauritania",
            "Mauritius",
            "Mayotte",
            "Mexico",
            "Mozambique",
            "Myanmar",
            "Namibia",
            "Nepal",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "Oman",
            "Pakistan",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Republic of Korea",
            "Rwanda",
            "Sao Tome and Principe",
            "Saudi Arabia",
            "Senegal",
            "Sierra Leone",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "Sri Lanka",
            "Sudan",
            "Suriname",
            "Swaziland",
            "Syrian Arab Republic",
            "Tanzania",
            "Thailand",
            "Timor-Leste",
            "Togo",
            "Turkey",
            "Uganda",
            "Uzbekistan",
            "Vanuatu",
            "Venezuela",
            "Viet Nam",
            "Yemen",
            "Zambia",
            "Zimbabwe"
    };

    Boolean visitedMalariaCountry = false;
    Boolean stayedMoreThan6Months = false;
    Boolean visitedFourMonthsAgo = false;
    Boolean travelledOutsideSingapore = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        //Hide the views except the welcome message and start quiz button
        initializeItems(context);
        firstPart.setVisibility(View.GONE);
        secondPart.setVisibility(View.GONE);
        thirdPart.setVisibility(View.GONE);
        fourthPart.setVisibility(View.GONE);
        fifthPart.setVisibility(View.GONE);
        sixthPart.setVisibility(View.GONE);
        seventhPart.setVisibility(View.GONE);
        eighthPart.setVisibility(View.GONE);
        ninthPart.setVisibility(View.GONE);
        tenthPart.setVisibility(View.GONE);
        eleventhPart.setVisibility(View.GONE);
        twelfthPart.setVisibility(View.GONE);
        thirteenPart.setVisibility(View.GONE);
        fourteenPart.setVisibility(View.GONE);
        fifteenPart.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);
        result = "";
        success = true;

    }

    public void startQuiz(View view) {
        quizEntry = (LinearLayout) findViewById(R.id.quiz_entry);
        quizEntry.setVisibility(View.GONE);
        firstPart.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(7);
        nextButton.setVisibility(View.VISIBLE);
    }

    private void initializeItems(Context c) {
        mainGroup = (LinearLayout) findViewById(R.id.main_viewGroup);
        firstPart = (LinearLayout) findViewById(R.id.first_part);
        secondPart = (LinearLayout) findViewById(R.id.second_part);
        thirdPart = (LinearLayout) findViewById(R.id.third_part);
        fourthPart = (LinearLayout) findViewById(R.id.fourth_part);
        fifthPart = (LinearLayout) findViewById(R.id.fifth_part);
        sixthPart = (LinearLayout) findViewById(R.id.sixth_part);
        seventhPart = (LinearLayout) findViewById(R.id.seventh_part);
        eighthPart = (LinearLayout) findViewById(R.id.eighth_part);
        ninthPart = (LinearLayout) findViewById(R.id.ninth_part);
        tenthPart = (LinearLayout) findViewById(R.id.tenth_part);
        eleventhPart = (LinearLayout) findViewById(R.id.eleventh_part);
        twelfthPart = (LinearLayout) findViewById(R.id.twelfth_part);
        thirteenPart = (LinearLayout) findViewById(R.id.thirteen_part);
        fourteenPart = (LinearLayout) findViewById(R.id.fourteen_part);
        fifteenPart = (LinearLayout) findViewById(R.id.fifteen_part);
        progressBar = (ProgressBar) findViewById(R.id.quiz_progress);
        nextButton = (Button) findViewById(R.id.next_button);
        quiz6 = (LinearLayout) findViewById(R.id.quiz_6_group);
        quiz6.setVisibility(View.GONE);
        quiz7 = (LinearLayout) findViewById(R.id.quiz_7_group);
        quiz7.setVisibility(View.GONE);
        hepaVacine = (LinearLayout) findViewById(R.id.hepa_vacine_group);
        hepaVacine.setVisibility(View.GONE);
        otherVacine = (LinearLayout) findViewById(R.id.other_vacine_group);
        otherVacine.setVisibility(View.GONE);
        malariaGroup1 = (LinearLayout) findViewById(R.id.malaria_group_1);
        malariaGroup1.setVisibility(View.GONE);
        malariaGroup2 = (LinearLayout) findViewById(R.id.malaria_group_2);
        malariaGroup2.setVisibility(View.GONE);
        questionProgess = 1;
    }

    public void loadNext(View view) {
        questionProgess++;
        switch (questionProgess) {
            case 1:
                onRefresh();
                break;
            case 2:
                firstPart.setVisibility(View.GONE);
                if (success) {
                    secondPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(14);
                } else {
                    endQuiz();
                }
                break;
            case 3:
                secondPart.setVisibility(View.GONE);
                if (success) {
                    thirdPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(21);
                } else {
                    endQuiz();
                }
                break;
            case 4:
                thirdPart.setVisibility(View.GONE);
                if (success) {
                    fourthPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(28);
                } else {
                    endQuiz();
                }
                break;
            case 5:
                fourthPart.setVisibility(View.GONE);
                if (success) {
                    fifthPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(35);
                } else {
                    endQuiz();
                }
                break;
            case 6:
                fifthPart.setVisibility(View.GONE);
                if (success) {
                    sixthPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(42);
                } else {
                    endQuiz();
                }
                break;
            case 7:
                sixthPart.setVisibility(View.GONE);
                if (success) {
                    seventhPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(49);
                } else {
                    endQuiz();
                }
                break;
            case 8:
                seventhPart.setVisibility(View.GONE);
                if (success) {
                    eighthPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(56);
                } else {
                    endQuiz();
                }
                break;
            case 9:
                eighthPart.setVisibility(View.GONE);
                if (success) {
                    ninthPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(63);
                } else {
                    endQuiz();
                }
                break;
            case 10:
                ninthPart.setVisibility(View.GONE);
                if (success) {
                    tenthPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(70);
                } else {
                    endQuiz();
                }
                break;
            case 11:
                tenthPart.setVisibility(View.GONE);
                if (success) {
                    eleventhPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(77);
                }
                break;
            case 12:
                eleventhPart.setVisibility(View.GONE);
                if (isFemale) {
                    if (success) {
                        twelfthPart.setVisibility(View.VISIBLE);
                        progressBar.setProgress(84);
                    } else {
                        endQuiz();
                    }
                } else {
                    loadNext(view);
                }
                break;
            case 13:
                twelfthPart.setVisibility(View.GONE);
                if (success) {
                    thirteenPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(91);
                } else {
                    endQuiz();
                }
                break;
            case 14:
                thirteenPart.setVisibility(View.GONE);
                if(travelledOutsideSingapore) {
                    EditText placeOfVisit = (EditText) findViewById(R.id.quiz_answer_60);
                    Editable editable = placeOfVisit.getText();
                    if (!editable.toString().isEmpty()) {
                        if (checkInList(editable.toString())) {
                            visitedMalariaCountry = true;
                        }
                    }
                    EditText text = (EditText) findViewById(R.id.quiz_answer_68);
                    if (!text.getText().toString().isEmpty()) {
                        String strDate = text.getText().toString();
                        DateFormat dateFormat = (DateFormat) new SimpleDateFormat("dd/MM/yyyy");
                        Date date = null;
                        try {
                            date = dateFormat.parse(strDate);
                            Calendar cal = Calendar.getInstance();
                            cal.setTimeInMillis(Calendar.getInstance().getTimeInMillis() - (120 * 24 * 60 * 60 * 1000));
                            visitedFourMonthsAgo = date.before(cal.getTime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


                        if (visitedMalariaCountry && !visitedFourMonthsAgo) {
                            success = false;
                            result = "Donors who have travelled and returned from a malaria endemic area less than four (4) months from the day of screening will be asked to come back at least four (4) months later.\n" +
                                    "\n" +
                                    "Country\tRegion\n" +
                                    "Afghanistan\tCentral Asia\n" +
                                    "Algeria\tNorth Africa\n" +
                                    "Angola\tSouthern Africa\n" +
                                    "Argentina\tSouthern South America\n" +
                                    "Azerbaijan\tTranscaucasia\n" +
                                    "Bangladesh\tSouth Asia\n" +
                                    "Belize\tCentral America\n" +
                                    "Benin\tWest Africa\n" +
                                    "Bhutan\tSouth Asia\n" +
                                    "Bolivia\tAmazon rainforest\n" +
                                    "Botswana\tSouthern Africa\n" +
                                    "Brazil\tAmazon rainforest\n" +
                                    "Burkina Faso\tWest Africa\n" +
                                    "Burundi\tEast Africa\n" +
                                    "Cambodia\tSoutheast Asia\n" +
                                    "Cameroon\tCentral Africa\n" +
                                    "Cape Verde\tWest Africa\n" +
                                    "Central African Republic (CAR)\tCentral Africa\n" +
                                    "Chad\tCentral Africa\n" +
                                    "China\tEastern Asia\n" +
                                    "Colombia\tAmazon rainforest\n" +
                                    "Comoros\tEast Africa\n" +
                                    "Congo\tCentral Africa\n" +
                                    "Costa Rica\tCentral America\n" +
                                    "Côte d'Ivoire\tWest Africa\n" +
                                    "Democratic Republic of The Congo (DRC)\tCentral Africa\n" +
                                    "Djibouti\tEast Africa\n" +
                                    "Dominican Republic\tCaribbean\n" +
                                    "DPR Korea\tEastern Asia\n" +
                                    "Ecuador\tAmazon rainforest\n" +
                                    "Egypt\tNorth Africa\n" +
                                    "El Salvador\tCentral America\n" +
                                    "Equatorial Guinea\tCentral Africa\n" +
                                    "Eritrea\tEast Africa\n" +
                                    "Ethiopia\tEast Africa\n" +
                                    "French Guiana\tAmazon rainforest\n" +
                                    "Gabon\tCentral Africa\n" +
                                    "Gambia\tWest Africa\n" +
                                    "Ghana\tWest Africa\n" +
                                    "Guatemala\tCentral America\n" +
                                    "Guinea\tWest Africa\n" +
                                    "Guinea-Bissau\tWest Africa\n" +
                                    "Guyana\tAmazon rainforest\n" +
                                    "Haiti\tCaribbean\n" +
                                    "Honduras\tCentral America\n" +
                                    "India\tSouth Asia\n" +
                                    "Indonesia\tSoutheast Asia\n" +
                                    "Iran\tCentral Asia\n" +
                                    "Iraq\tMiddle-East\n" +
                                    "Jamaica\tCaribbean\n" +
                                    "Kenya\tEast Africa\n" +
                                    "Kyrgyzstan\tCentral Asia\n" +
                                    "Lao People's Democratic Republic\tSoutheast Asia\n" +
                                    "Liberia\tWest Africa\n" +
                                    "Madagascar\tSouthern Africa\n" +
                                    "Malawi\tSouthern Africa\n" +
                                    "Malaysia\tSoutheast Asia\n" +
                                    "Mali\tWest Africa\n" +
                                    "Mauritania\tWest Africa\n" +
                                    "Mauritius\tSouthern Africa\n" +
                                    "Mayotte\tEast Africa\n" +
                                    "Mexico\tCentral America\n" +
                                    "Mozambique\tSouthern Africa\n" +
                                    "Myanmar\tSoutheast Asia\n" +
                                    "Namibia\tSouthern Africa\n" +
                                    "Nepal\tSouth Asia\n" +
                                    "Nicaragua\tCentral America\n" +
                                    "Niger\tWest Africa\n" +
                                    "Nigeria\tWest Africa\n" +
                                    "Oman\tMiddle-East\n" +
                                    "Pakistan\tCentral Asia\n" +
                                    "Panama\tCentral America\n" +
                                    "Papua New Guinea\tPacific\n" +
                                    "Paraguay\tSouthern South America\n" +
                                    "Peru\tAmazon rainforest\n" +
                                    "Philippines\tSoutheast Asia\n" +
                                    "Republic of Korea\tEastern Asia\n" +
                                    "Rwanda\tEast Africa\n" +
                                    "Sao Tome and Principe\tCentral Africa\n" +
                                    "Saudi Arabia\tMiddle-East\n" +
                                    "Senegal\tWest Africa\n" +
                                    "Sierra Leone\tWest Africa\n" +
                                    "Solomon Islands\tPacific\n" +
                                    "Somalia\tEast Africa\n" +
                                    "South Africa\tSouthern Africa\n" +
                                    "Sri Lanka\tSouth Asia\n" +
                                    "Sudan\tEast Africa\n" +
                                    "Suriname\tAmazon rainforest\n" +
                                    "Swaziland\tSouthern Africa\n" +
                                    "Syrian Arab Republic\tMiddle-East\n" +
                                    "Tanzania\tEast Africa\n" +
                                    "Thailand\tSoutheast Asia\n" +
                                    "Timor-Leste\tSoutheast Asia\n" +
                                    "Togo\tWest Africa\n" +
                                    "Turkey\tEuroasia\n" +
                                    "Uganda\tEast Africa\n" +
                                    "Uzbekistan\tCentral Asia\n" +
                                    "Vanuatu\tPacific\n" +
                                    "Venezuela\tAmazon rainforest\n" +
                                    "Viet Nam\tSoutheast Asia\n" +
                                    "Yemen\tMiddle-East\n" +
                                    "Zambia\tSouthern Africa\n" +
                                    "Zimbabwe\tSouthern Africa";
                        }
                    }
                }
                if (success) {
                    fourteenPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(96);
                } else {
                    endQuiz();
                }
                break;
            case 15:
                fourteenPart.setVisibility(View.GONE);
                if (success) {
                    fifteenPart.setVisibility(View.VISIBLE);
                    progressBar.setProgress(98);
                    nextButton.setText("Finish");
                } else {
                    endQuiz();
                }
                break;
            case 16:
                fifteenPart.setVisibility(View.GONE);
                if (success) {
                    result += "Congradulations! You may proceed to the blood bank to donate blood." +
                            "\nPlease take note that there are other factors such as your blood count, blood pressure and BMI" +
                            "which affect the eligibility of you donating blood.";
                }
                endQuiz();
        }
    }

    private void onRefresh() {
        quizEntry.setVisibility(View.VISIBLE);
        initializeItems(context);
        nextButton.setText("Next");
        nextButton.setVisibility(View.GONE);
        mainGroup.removeView(textView);
        progressBar.setVisibility(View.GONE);
        hepaVacine.setVisibility(View.GONE);
        otherVacine.setVisibility(View.GONE);
        malariaGroup1.setVisibility(View.GONE);
        malariaGroup2.setVisibility(View.GONE);
        quiz6.setVisibility(View.GONE);
        quiz7.setVisibility(View.GONE);
        isFemale = false;
        uncheckRadioButtons();
    }

    private void endQuiz() {
        progressBar.setProgress(100);
        textView = new TextView(context);
        result += "\nYou have finished the quiz. \nThanks for your time!";
        textView.setText(result);
        textView.setTextColor(getResources().getColor(R.color.colorBlack));
        textView.setTag(123);
        textView.setPadding(10, 10, 10, 10);
        mainGroup.addView(textView);
        nextButton.setText("Retake the quiz");
        questionProgess = 0;
        success = true;
        result = "";
    }

    private void uncheckRadioButtons() {
        int[] radioGroups = {R.id.radioGroup1, R.id.radioGroup2, R.id.radioGroup3, R.id.radioGroup4,
                R.id.radioGroup5, R.id.radioGroup6, R.id.radioGroup7, R.id.radioGroup8, R.id.radioGroup9,
                R.id.radioGroup10, R.id.radioGroup11, R.id.radioGroup12, R.id.radioGroup13, R.id.radioGroup14,
                R.id.radioGroup15, R.id.radioGroup16, R.id.radioGroup17, R.id.radioGroup18, R.id.radioGroup19,
                R.id.radioGroup20, R.id.radioGroup21, R.id.radioGroup22, R.id.radioGroup23, R.id.radioGroup24,
                R.id.radioGroup25, R.id.radioGroup26, R.id.radioGroup27, R.id.radioGroup28, R.id.radioGroup29,
                R.id.radioGroup30, R.id.radioGroup31, R.id.radioGroup32, R.id.radioGroup33, R.id.radioGroup34,
                R.id.radioGroup35, R.id.radioGroup36, R.id.radioGroup37, R.id.radioGroup38, R.id.radioGroup39,
                R.id.radioGroup40, R.id.radioGroup41, R.id.radioGroup42, R.id.radioGroup43, R.id.radioGroup44,
                R.id.radioGroup45, R.id.radioGroup46, R.id.radioGroup47, R.id.radioGroup48, R.id.radioGroup49,
                R.id.radioGroup50, R.id.radioGroup51, R.id.radioGroup52, R.id.radioGroup53, R.id.radioGroup54,
                R.id.radioGroup55};
        for (int i = 0; i < radioGroups.length; i++) {
            RadioGroup radioGroup = (RadioGroup) findViewById(radioGroups[i]);
            radioGroup.clearCheck();
        }

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yes_btn1:
                if (checked) {
                    result += "You should not donate blood if you think you may have the HIV infection (the virus that causes AIDS) or if you are at risk of HIV infection through high risk activities. \n" +
                            "\n" +
                            "You should visit your family doctor, the polyclinic or the anonymous testing clinic for HIV testing if you feel you are at risk and not donate blood.";
                    success = false;
                }
                break;
            case R.id.no_btn1:
                if (checked)
                    break;

            case R.id.yes_btn2:
                if (checked)
                    break;

            case R.id.no_btn2:
                if (checked)
                    result = "The \"\"window period\"\" for the HIV virus (virus that causes AIDS) ranges from several weeks to months depending on the individual and type of screening tests used. You should not donate blood if you have been exposed to the virus from high-risk sexual activity or if you have any other risk factors, because your blood may be infectious during this \"\"window period\"\" and we cannot detect the virus using the current tests. \n" +
                            "\n" +
                            "To know more about risk factors, please read \"\"An Important Message to Blood Donors\"\".";
                break;

            case R.id.yes_btn3:
                if (checked)
                    result = "You should not donate blood if you think you may have been exposed to the HIV infection (the virus that causes AIDS) or if you are at risk of HIV infection through high risk activities. \n" +
                            "\n" +
                            "You should visit your family doctor, the polyclinic or the anonymous testing clinic for HIV testing if you feel you are at risk and not donate blood.";
                success = false;
                break;

            case R.id.no_btn3:
                if (checked)
                    break;

            case R.id.yes_btn4:
                if (checked)
                    result = "This is considered very high-risk sexual activity. You should not donate blood after this since this is a major risk factor. \n" +
                            "\n" +
                            "The word \"sexual activity\" means the introduction into the vagina, anus or mouth of any person of any part of the penis of another person; whether or not a condom or other protection was used or \"cunnilingus\". For more information please read \"An Important Message to Blood Donors\".";
                break;

            case R.id.no_btn4:
                if (checked)
                    break;

            case R.id.male_btn:
                if (checked) {
                    quiz6.setVisibility(View.VISIBLE);
                    break;
                }
            case R.id.female_btn:
                if (checked) {
                    isFemale = true;
                    quiz7.setVisibility(View.VISIBLE);
                    break;
                }

            case R.id.yes_btn6:
                if (checked) {
                    result += "This is considered very high-risk sexual activity. You should not donate blood after this since this is a major risk factor. \n" +
                            "\n" +
                            "The word \"sexual activity\" means the introduction into the vagina, anus or mouth of any person of any part of the penis of another person; whether or not a condom or other protection was used or \"cunnilingus\". For more information please read \"An Important Message to Blood Donors\".";
                    success = false;
                    break;
                }


            case R.id.no_btn6:
                if (checked)
                    break;
            case R.id.yes_btn7:
                if (checked) {
                    result = "This is considered high-risk sexual activity. You should not donate blood for at least 12 months following the last sexual contact with the above-mentioned male partner. If you are a regular donor, you may resume only after clearance by a screening interview at the end of 12 months. \n" +
                            "\n" +
                            "The word \"sexual activity\" means the introduction into the vagina, anus or mouth of any person of any part of the penis of another person; whether or not a condom or other protection was used or \"cunnilingus\". For more information please read \"An Important Message to Blood Donors\".";
                    success = false;
                    break;
                }
            case R.id.no_btn7:
                if (checked)
                    break;

            case R.id.yes_btn8:
                if (checked) {
                    result = "The above symptom(s) may be due to HIV infection or some other serious illness. You should not donate blood. Please consult your doctor or visit the polyclinic for a thorough examination and testing to determine the cause.";
                    success = false;
                    break;
                }
            case R.id.no_btn8:
                if (checked)
                    break;
            case R.id.yes_btn9:
                if (checked) {
                    result = "You should not donate blood as this is one of the risk factors for HIV. For more information please read \"An Important Message to Blood Donors\".";
                    success = false;
                    break;
                }
            case R.id.no_btn9:
                if (checked)
                    break;
            case R.id.yes_btn10:
                if (checked) {
                    result = "This is considered high-risk sexual activity. You should not donate blood for at least 12 months. If you are a regular donor, you may resume only after clearance by a screening interview at the end of 12 months. \n" +
                            "\n" +
                            "The word \"sexual activity\" in this question applies to vaginal, oral or anal sex, whether or not a condom or other protection was used. For more information please read \"An Important Message to Blood Donors\".";
                    success = false;
                    break;
                }
            case R.id.no_btn10:
                if (checked)
                    break;
            case R.id.yes_btn12:
                if (checked) {
                    result = "This is considered high-risk sexual activity. You should not donate blood for at least 12 months. If you are a regular donor, you may resume only after clearance by a screening interview at the end of 12 months. \n" +
                            "\n" +
                            "The word \"sexual activity\" in this question applies to vaginal, oral or anal sex, whether or not a condom or other protection was used. For more information please read \"An Important Message to Blood Donors\".";
                    success = false;
                    break;
                }
            case R.id.no_btn12:
                if (checked)
                    break;
            case R.id.yes_btn13:
                if (checked) {
                    result = "This is considered high-risk sexual activity. You should not donate blood for at least 12 months. If you are a regular donor, you may resume only after clearance by a screening interview at the end of 12 months. \n" +
                            "\n" +
                            "The word \"sexual activity\" in this question applies to vaginal, oral or anal sex, whether or not a condom or other protection was used. For more information please read \"An Important Message to Blood Donors\".";
                    success = false;
                    break;
                }
            case R.id.no_btn13:
                if (checked)
                    break;
            case R.id.yes_btn14:
                if (checked) {
                    result = "If you have been diagnosed as having, or treated for, any sexually transmitted diseases other than syphilis, you may only donate blood after 12 months from the time of completion of treatment, provided you have not engaged in any high-risk sexual activities after treatment. \n" +
                            "\n" +
                            "You should not donate blood if you have been previously diagnosed with syphilis or had a positive test for syphilis in the past.";
                    success = false;
                    break;
                }
            case R.id.no_btn14:
                if (checked)
                    break;

            case R.id.yes_btn15:
                if (checked) {
                    result = "This is considered high-risk sexual activity. You should not donate blood for at least 12 months. If you are a regular donor, you may resume only after clearance by a screening interview at the end of 12 months. \n" +
                            "\n" +
                            "The word \"sexual activity\" means the introduction into the vagina, anus or mouth of any person of any part of the penis of another person; whether or not a condom or other protection was used or \"cunnilingus\". For more information please read \"An Important Message to Blood Donors\".";
                    success = false;
                    break;
                }

            case R.id.no_btn15:
                if (checked)
                    break;

            case R.id.yes_btn17:
                if (checked) {
                    result = "If you have donated blood, platelets or plasma in the last 12 weeks, please ensure that the interval between your last donation and your current one is adequate. \n" +
                            "\n" +
                            "We would advise an interval of 12 weeks between each whole blood donation, and an interval of at least 8 weeks when switching from a whole blood donation to an Apheresis Platelet or Plasma Donation. There should be a minimal 4 week interval between Apheresis Platelet or Plasma donations or when switching from Apheresis Platelet/Plasma donations to Whole Blood donation. \n" +
                            "\n" +
                            "This minimal time interval is to protect the well being of donors. Blood donors require an adequate interval to rest and recover from each blood donation. This is to allow the body the necessary time to recover physically and replenish needed nutrients, as well as avoid overtaxing the bone marrow. \n" +
                            "\n" +
                            "\n" +
                            "Kindly refer to the table below for the appropriate intervals between different types of donation. \n" +
                            "\n" +
                            "Previous Donation\tCurrent Donation\tInterval Period\n" +
                            "Whole Blood\tWhole Blood\t12 weeks\n" +
                            "Whole Blood\tPlatelet/Plasmapheresis\t8 weeks\n" +
                            "Platelet/Plasmapheresis\tWhole Blood\t4 weeks\n" +
                            "Platelet/Plasmapheresis\tPlatelet/Plasmapheresis\t4 weeks\n";
                    success = false;
                    break;
                }

            case R.id.no_btn17:
                if (checked)
                    break;

            case R.id.yes_btn18:
                if (checked) {
                    result = "If you were told that you are permanently deferred from giving blood, then you must not donate blood. \n" +
                            "\n" +
                            "If the deferral was temporary, you may donate blood after the deferral period is over. Each case will be evaluated and the suitability of the donors determined by the medical officer reviewing the case.";
                    success = false;
                    break;
                }

            case R.id.no_btn18:
                if (checked)
                    break;

            case R.id.yes_btn19:
                if (checked) {
                    result = "Hepatitis (or liver infection) can be transmitted through blood transfusion. \n" +
                            "\n" +
                            "If you had a previous Hepatitis A infection you will be deferred for 1 year after recovery from the infection. \n" +
                            "\n" +
                            "If you had a previous Hepatitis B or C infection you will be permanently deferred as the virus may persist in the blood and therefore can be transmitted to the blood recipients. \n" +
                            "\n" +
                            "If you have a history of jaundice after birth or related to gallbladder problems, you may be accepted as a blood donor provided the condition has been treated. \n" +
                            "\n" +
                            "If you previously had jaundice where the cause was unknown, you will be deferred from blood donation until the cause of the episode of jaundice can be established. \n" +
                            "\n" +
                            "If you have a positive test for Hepatitis B or C infection, you must not donate blood and the results of the tests must be discussed with our doctors. \n" +
                            "\n" +
                            "For more information please read \"\"An Important Message to Blood Donors\"\" ";
                    success = false;
                    break;
                }


            case R.id.no_btn19:
                if (checked) {
                    break;
                }

            case R.id.yes_btn20:
                if (checked) {
                    result = "If you had close contact with a person with Hepatitis B or C you should not donate blood for a period of 12 months following the period of close contact. \n" +
                            "\n" +
                            "\"\"Close contact\"\" means living in the same household with a person with Hepatitis or coming into contact with the infected person's body fluids/secretions. This includes sexual contact. \n" +
                            "\n" +
                            "If you are living with a relative who is a Hepatitis B carrier (same household) you are required to complete a course of Hepatitis B vaccination and produce documentary proof/record that your Hepatitis B immune status is adequate (sufficient level of antibody response), before making a blood donation. \n" +
                            "\n" +
                            "If your spouse has chronic Hepatitis C infection you should not donate blood due to the potential for transmission of the infection. \n" +
                            "\n" +
                            "If you are hospital staff in direct contact with patients with Hepatitis, you will be deferred for 12 months if you have experienced an inoculation injury or mucous membrane exposure. You may be accepted as a donor if you have been demonstrated to be immune. \n" +
                            "\n" +
                            "For more information please read \"\"An Important Message to Blood Donors\"\"";
                    success = false;
                    break;
                }


            case R.id.no_btn20:
                if (checked)
                    break;

            case R.id.yes_btn21:
                if (checked) {
                    result = "If you have received blood transfusion in the United Kingdom and France between 1980 and the present time, you should not donate blood. This is a precautionary measure to reduce the possible risk of transmission of vCJD or \"\"mad cow disease\"\" by blood and blood products.\n" +
                            "\n" +
                            "If you have received plasma derivatives at any time since 1980 you must not donate blood and will be deferred indefinitely as a precautionary measure to prevent the possible risk of transmission of vCJD by blood and blood products.\n" +
                            "\n" +
                            "Chagas disease is widely endemic throughout Central and South America, and Mexico, where the main mode of transmission is exposure to infected triatomine (or riduviid) bugs. Most infections are asymptomatic or cause non-specific, flu-like symptoms and are not diagnosed. Chagas disease can cause serious complications of the heart and gastrointestinal tract in approximately 30 per cent of infected individuals. Donors who were diagnosed to have Chaga's disease are deferred permanently. Since screening tests for donors are not available, donors with an identified risk of Chagas disease should be permanently deferred. Risk factors include:\n" +
                            "\n" +
                            "1.\tDonors born in South America or Central America and Mexico\n" +
                            "2.\tMother was born in South America or Central America and Mexico\n" +
                            "3.\tReceived blood transfusion in South America or Central America and Mexico\n" +
                            "4.\tLived or worked in rural subsistence farming communities in South America or Central America and Mexico for a continuous period of four weeks or more";
                    success = false;
                    break;
                }

            case R.id.no_btn21:
                if (checked)
                    break;

            case R.id.yes_btn22:
                if (checked) {
                    result = "If you have received blood or blood products (other than UK, Mexico, France, South America or Central America) you should not donate blood for a period of 12 months from the date of the transfusion as these may transmit some viral infections, although the risk is extremely small.";
                    success = false;
                    break;
                }

            case R.id.no_btn22:
                if (checked)
                    break;

            case R.id.yes_btn23:
                if (checked) {
                    result = "The above activity is considered as a risk factor for contracting AIDS and other viruses. Anyone engaging in such activity must not donate blood.";
                    success = false;
                    break;
                }

            case R.id.no_btn23:
                if (checked)
                    break;

            case R.id.yes_btn24:
                if (checked) {
                    result = "You are advised to stop blood donation for 12 months from the date of the ear piercing, tattoo, acupuncture, needle stick injury or exposure to blood contaminated instruments. However, ear piercing, tattoo and acupuncture are acceptable if performed under strictly sterile conditions using disposable needles. If there is any doubt of the sterility, you will be deferred for 12 months from donating blood.";
                    success = false;
                    break;
                }

            case R.id.no_btn24:
                if (checked)
                    break;

            case R.id.yes_btn25:
                if (checked) {
                    result = "If you have been detained in any of the above within the past 12 months and the detention/imprisonment was for a period exceeding 24 hours, you should not donate blood for a period of 12 months from the date of release.";
                    success = false;
                    break;
                }

            case R.id.no_btn25:
                if (checked)
                    break;

            case R.id.yes_btn26:
                if (checked) {
                    break;
                }

            case R.id.no_btn26:
                if (checked) {
                    result = "If you do not feel well on the day of donation you should not donate blood. It may be harmful to both you and the potential recipients if you have an infection or other illness. \n" +
                            "\n" +
                            "If you only had common flu symptoms such as cough and cold without fever, you should not donate blood until one week after your condition has resolved. \n" +
                            "\n" +
                            "If you had diarrhoea recently, you should not donate blood until one week after your condition has resolved.";
                    success = false;
                    break;
                }

            case R.id.yes_btn27:
                if (checked) {
                    result = "If you had fever anytime in the last 3 weeks, please do not donate blood until 3 weeks after your condition has resolved. It may be harmful to both you and the potential recipients if you donate blood when you have an infection or other illness.";
                    success = false;
                    break;
                }

            case R.id.no_btn27:
                if (checked)
                    break;

            case R.id.yes_btn28:
                if (checked)
                    break;

            case R.id.no_btn28:
                if (checked) {
                    result = "Donors should call as soon as possible our \"24-hour hotline\" to report if they feel unwell following blood donation, particularly during the first two weeks post-donation. The reason for urgent donor call back is for us to prevent the release and transfusion to patients of \"potentially\" infected blood. Specific symptoms to look out for within the first two weeks of donating blood include fever, rashes, conjunctivitis ('red or pink eye'), and infective respiratory symptoms such as sore-throat and persistent cough. It is possible that a virus could already be incubating in a person who might not feel unwell when donating blood; the virus presents in the donated blood and could pose problems to ill patients receiving this blood.";
                    success = false;
                    break;
                }


            case R.id.yes_btn30:
                if (checked) {
                    result = "You should inform the medical officers at the blood bank of any illnesses that require regular follow up by your doctor as these medical conditions may lead to problems for the blood recipients and possibly your own condition if you donate blood. \n" +
                            "\n" +
                            "In general, you are advised to stop blood donation for 12 months after major surgery and for 3-6 months after minor surgery. \n" +
                            "\n" +
                            "If you have been infected with significant viral illnesses like chickenpox, dengue fever, chikungunya fever, measles or mumps you should stop blood donation for a period of six months following full recovery. \n" +
                            "\n" +
                            "If you have been exposed to or have a history of close contact with these viral illnesses you should stop blood donation for a period of three weeks from the last contact. However, if you have had previous infection of chickenpox, measles or mumps with a history of close contact with these diseases you may be accepted for donation. \n" +
                            "\n" +
                            "If you have been infected with Severe Acute Respiratory Syndrome (SARS), you should stop blood donation for a period of three months following full recovery and cessation of therapy. \n" +
                            "\n" +
                            "If you have a history of glandular fever or meningitis, you should not donate blood for twelve months following full recovery. \n" +
                            "\n" +
                            "If you have been infected with Brucellosis or Toxoplasmosis, you should stop blood donation for a period of two years following full recovery. \n" +
                            "\n" +
                            "If you have been infected with Chagas disease, Babesiosis, Leishmaniasis, HTLV-I/II or Chronic Q fever, you must not donate blood at all and will be deferred permanently. \n" +
                            "\n" +
                            "You should not donate blood if you have a history of diseases that may be of autoimmune origin (including Graves Disease, ulcerative colitis and atrophic gastritis), even after full recovery (indefinite deferral). \n" +
                            "\n" +
                            "If you have a history of contact with any infectious disease not mentioned above, you should not donate blood for a period not less than the incubation period (time taken for symptoms to appear after first exposure) of the disease. \n" +
                            "\n" +
                            "If you are uncertain of your past illnesses and whether you can donate blood, you should contact your doctor and obtain a letter which provides details of your medical history.";
                    success = false;
                    break;
                }

            case R.id.no_btn30:
                if (checked)
                    break;
            case R.id.yes_btn31:
                if (checked) {
                    result = "You should inform the medical officers at the blood bank of any illnesses that require regular follow up by your doctor as these medical conditions may lead to problems for the blood recipients and possibly your own condition if you donate blood. \n" +
                            "\n" +
                            "In general, you are advised to stop blood donation for 12 months after major surgery and for 3-6 months after minor surgery. \n" +
                            "\n" +
                            "If you have been infected with significant viral illnesses like chickenpox, dengue fever, chikungunya fever, measles or mumps you should stop blood donation for a period of six months following full recovery. \n" +
                            "\n" +
                            "If you have been exposed to or have a history of close contact with these viral illnesses you should stop blood donation for a period of three weeks from the last contact. However, if you have had previous infection of chickenpox, measles or mumps with a history of close contact with these diseases you may be accepted for donation. \n" +
                            "\n" +
                            "If you have been infected with Severe Acute Respiratory Syndrome (SARS), you should stop blood donation for a period of three months following full recovery and cessation of therapy. \n" +
                            "\n" +
                            "If you have a history of glandular fever or meningitis, you should not donate blood for twelve months following full recovery. \n" +
                            "\n" +
                            "If you have been infected with Brucellosis or Toxoplasmosis, you should stop blood donation for a period of two years following full recovery. \n" +
                            "\n" +
                            "If you have been infected with Chagas disease, Babesiosis, Leishmaniasis, HTLV-I/II or Chronic Q fever, you must not donate blood at all and will be deferred permanently. \n" +
                            "\n" +
                            "You should not donate blood if you have a history of diseases that may be of autoimmune origin (including Graves Disease, ulcerative colitis and atrophic gastritis), even after full recovery (indefinite deferral). \n" +
                            "\n" +
                            "If you have a history of contact with any infectious disease not mentioned above, you should not donate blood for a period not less than the incubation period (time taken for symptoms to appear after first exposure) of the disease. \n" +
                            "\n" +
                            "If you are uncertain of your past illnesses and whether you can donate blood, you should contact your doctor and obtain a letter which provides details of your medical history.";
                    success = false;
                    break;
                }
            case R.id.no_btn31:
                if (checked)
                    break;
            case R.id.yes_btn32:
                if (checked) {
                    result = "You should inform the medical officers at the blood bank of any illnesses that require regular follow up by your doctor as these medical conditions may lead to problems for the blood recipients and possibly your own condition if you donate blood. \n" +
                            "\n" +
                            "In general, you are advised to stop blood donation for 12 months after major surgery and for 3-6 months after minor surgery. \n" +
                            "\n" +
                            "If you have been infected with significant viral illnesses like chickenpox, dengue fever, chikungunya fever, measles or mumps you should stop blood donation for a period of six months following full recovery. \n" +
                            "\n" +
                            "If you have been exposed to or have a history of close contact with these viral illnesses you should stop blood donation for a period of three weeks from the last contact. However, if you have had previous infection of chickenpox, measles or mumps with a history of close contact with these diseases you may be accepted for donation. \n" +
                            "\n" +
                            "If you have been infected with Severe Acute Respiratory Syndrome (SARS), you should stop blood donation for a period of three months following full recovery and cessation of therapy. \n" +
                            "\n" +
                            "If you have a history of glandular fever or meningitis, you should not donate blood for twelve months following full recovery. \n" +
                            "\n" +
                            "If you have been infected with Brucellosis or Toxoplasmosis, you should stop blood donation for a period of two years following full recovery. \n" +
                            "\n" +
                            "If you have been infected with Chagas disease, Babesiosis, Leishmaniasis, HTLV-I/II or Chronic Q fever, you must not donate blood at all and will be deferred permanently. \n" +
                            "\n" +
                            "You should not donate blood if you have a history of diseases that may be of autoimmune origin (including Graves Disease, ulcerative colitis and atrophic gastritis), even after full recovery (indefinite deferral). \n" +
                            "\n" +
                            "If you have a history of contact with any infectious disease not mentioned above, you should not donate blood for a period not less than the incubation period (time taken for symptoms to appear after first exposure) of the disease. \n" +
                            "\n" +
                            "If you are uncertain of your past illnesses and whether you can donate blood, you should contact your doctor and obtain a letter which provides details of your medical history.";
                    success = false;
                    break;
                }
            case R.id.no_btn32:
                if (checked)
                    break;
            case R.id.yes_btn33:
                if (checked) {
                    result = "You should inform the medical officers at the blood bank of any illnesses that require regular follow up by your doctor as these medical conditions may lead to problems for the blood recipients and possibly your own condition if you donate blood. \n" +
                            "\n" +
                            "In general, you are advised to stop blood donation for 12 months after major surgery and for 3-6 months after minor surgery. \n" +
                            "\n" +
                            "If you have been infected with significant viral illnesses like chickenpox, dengue fever, chikungunya fever, measles or mumps you should stop blood donation for a period of six months following full recovery. \n" +
                            "\n" +
                            "If you have been exposed to or have a history of close contact with these viral illnesses you should stop blood donation for a period of three weeks from the last contact. However, if you have had previous infection of chickenpox, measles or mumps with a history of close contact with these diseases you may be accepted for donation. \n" +
                            "\n" +
                            "If you have been infected with Severe Acute Respiratory Syndrome (SARS), you should stop blood donation for a period of three months following full recovery and cessation of therapy. \n" +
                            "\n" +
                            "If you have a history of glandular fever or meningitis, you should not donate blood for twelve months following full recovery. \n" +
                            "\n" +
                            "If you have been infected with Brucellosis or Toxoplasmosis, you should stop blood donation for a period of two years following full recovery. \n" +
                            "\n" +
                            "If you have been infected with Chagas disease, Babesiosis, Leishmaniasis, HTLV-I/II or Chronic Q fever, you must not donate blood at all and will be deferred permanently. \n" +
                            "\n" +
                            "If you have a history of diseases that may be of autoimmune origin, including Graves Disease, ulcerative colitis and atrophic gastritis, you will be deferred indefinitely and should not donate blood. \n" +
                            "\n" +
                            "If you have been diagnosed with Zika Virus Disease, you should only donate 4 weeks after the resolution of symptoms. If you (female donor) had sexual contact in the past 3 months with a man who has been diagnosed with Zika Virus Disease, you should not donate for 4 weeks after the date of last sexual contact. Donors who have travelled or resided in an area with active transmission of Zika Virus Disease are advised to donate 4 weeks after returning from ZIka virus affected areas. \n" +
                            "\n" +
                            "If you have a history of contact with any infectious disease not mentioned above, you should not donate blood for a period not less than the incubation period (time taken for symptoms to appear after first exposure) of the disease. \n" +
                            "\n" +
                            "If you are uncertain of your past illnesses and whether you can donate blood, you should contact your doctor and obtain a letter which provides details of your medical history.";
                    success = false;
                    break;
                }
            case R.id.no_btn33:
                if (checked)
                    break;

            case R.id.yes_btn35:
                if (checked) {
                    result = "You must not donate blood, as this is a risk factor for Creutzfeldt-Jakob Disease (CJD), which is a rare neuro-degenerative disorder that is potentially transmissible through blood transfusion. \n" +
                            "\n" +
                            "However, if the growth hormone you have received/are taking is fully synthetic or recombinant, you may be accepted for blood donation.";
                    success = false;
                    break;
                }

            case R.id.no_btn35:
                if (checked)
                    break;

            case R.id.yes_btn36:
                if (checked) {
                    result = "You must not donate blood, as these are risk factors for Creutzfeldt-Jakob Disease (CJD), which is a rare neuro-degenerative disorder that is potentially transmissible through blood transfusion.";
                    success = false;
                    break;
                }

            case R.id.no_btn36:
                if (checked)
                    break;

            case R.id.yes_btn37:
                if (checked) {
                    result = "You must not donate blood. If you have ever received bovine insulin (insulin extracted from the cow). You must not donate blood, even if you have stopped taking bovine insulin as this is a risk factor for the variant Creutzfeldt-Jakob Disease (vCJD or Mad Cow Disease).";
                    success = false;
                    break;
                }

            case R.id.no_btn37:
                if (checked)
                    break;

            case R.id.yes_btn39:
                if (checked) {
                    result = "Deferral of blood donation is generally based on the nature of the disease being treated by the drug rather than the drug itself. You are advised to wait for at least 3 days after taking any medication. However, for the more common medications like Panadol, you may be accepted for blood donation provided you are well at the time of donation. \n" +
                            "\n" +
                            "There are certain drugs for which deferral of blood donation is necessary for longer periods. Please speak to any of our medical staff for clarification of any doubts or if you are taking special medication.";
                    success = false;
                    break;
                }

            case R.id.no_btn39:
                if (checked)
                    break;

            case R.id.yes_btn40:
                if (checked) {
                    result = "If you had dental scaling or dental extraction you should not donate blood for 24 hours and 72 hours respectively after the procedure. If you had wisdom tooth surgical extraction you will be deferred for 3 months after the procedure. The deferral is necessary to reduce the incidence of bacterial contamination in the blood collected.";
                    success = false;
                    break;
                }

            case R.id.no_btn40:
                if (checked)
                    break;

            case R.id.yes_btn41:
                if (checked) {
                    result += "You should stop taking the traditional medication for at least three days before donating blood. Acceptable medications are herbs that are brewed, ginseng linghzi etc.\n" +
                            "\n" +
                            "Please speak to any of the medical staffs at the blood bank for clarification of any doubts or if you are taking traditional medicines.";
                    success = false;
                    break;
                }

            case R.id.no_btn41:
                if (checked)
                    break;

            case R.id.yes_btn43:
                if (checked) {
                    result += "In general, if you have a past history of angina, acute myocardial infarction (heart attack) or ischaemic heart disease you should not donate blood to avoid precipitating any heart problems during or after the blood donation procedures. \n" +
                            "\n" +
                            "If you have a moderate to severe heart valve problem or significant arrhythmia (abnormal heart rhythm) you will be deferred permanently from any blood donation. \n" +
                            "\n" +
                            "If you have non-specific symptoms like shortness of breath, cough or chest pain you will be assessed individually and may be deferred from blood donation. \n" +
                            "\n" +
                            "For more information regarding this matter, please speak to our medical staff.";
                    success = false;
                    break;
                }

            case R.id.no_btn43:
                if (checked)
                    break;

            case R.id.yes_btn44:
                if (checked) {
                    result += "You will be deferred from blood donation if you are using non-diuretic medication to control your high blood pressure. You may donate blood if you do not require medication for blood pressure control or if using only a diuretic medication and your blood pressure is within the acceptable range on the day of blood donation. \n" +
                            "\n" +
                            "For more information regarding this matter, please speak to our medical staff.";
                    success = false;
                    break;
                }

            case R.id.no_btn44:
                if (checked)
                    break;

            case R.id.yes_btn45:
                if (checked) {
                    result += "Generally, if you have any severe or chronic disease of these organs, you should not donate blood. If you have fully recovered, or suffer from milder forms of disease, you will need to be assessed for suitability to donate blood. This assessment will take into account the nature and the severity of the illness, and the treatment that you may be taking. \n" +
                            "\n" +
                            "For more information regarding this matter, please speak to our medical staff.";
                    success = false;
                    break;
                }

            case R.id.no_btn45:
                if (checked)
                    break;
            case R.id.yes_btn46:
                if (checked) {
                    result += "If you have a history of cancer, even if in remission, you should not donate blood. \n" +
                            "\n" +
                            "For more information regarding this matter, please speak to our medical staff.";
                    success = false;
                    break;
                }
            case R.id.no_btn46:
                if (checked)
                    break;
            case R.id.yes_btn47:
                if (checked) {
                    result += "If you have severe, active and generalised skin diseases (such as psoriasis) you should not donate blood. Donors with only mild skin diseases can be accepted. \n" +
                            "\n" +
                            "For more information regarding this matter, please speak to our medical staff.";
                    success = false;
                    break;
                }
            case R.id.no_btn47:
                if (checked)
                    break;

            case R.id.yes_btn48:
                if (checked) {
                    result += "If you have epilepsy which requires treatment, you should not donate blood. However, if you only have a history of childhood febrile convulsions (fits caused by high fever in childhood) you may be accepted as a blood donor.\n" +
                            "\n" +
                            "For more information regarding this matter, please speak to our medical staff.";
                    success = false;
                    break;
                }
            case R.id.no_btn48:
                if (checked)
                    break;
            case R.id.yes_btn49:
                if (checked) {
                    result += "All new or 1st time donors in Singapore with a history of malaria infection will be permanently deferred. \n" +
                            "\n" +
                            "Repeat donors who had a past history of malaria infection but had donated blood in Singapore since their infection may still continue to donate blood. \n" +
                            "\n" +
                            "A repeat donor diagnosed to have malaria before and experienced a relapse is deferred permanently.\n" +
                            "\n" +
                            "Babesiosis is caused by a tiny parasite called Babesia microti,that infects red blood cells. The parasite is spread from animals to humans via a bite from a tick and is usually found is the USA as well as in other parts of the world like Australia, Egypt, Europe, Japan, Korea, Mexico, North/South America, South Africa and Taiwan. Most people infected with Babesiosis do not feel sick, and do not even remember being bitten by a tick. However, Babesiosis can be a severe, life-threatening infection in the hospitalized patients who are blood recipients. Donors who were diagnosed to have Babesiosis are deferred permanently.\n" +
                            "\n" +
                            "Chagas disease is widely endemic throughout Central and South America, and Mexico, where the main mode of transmission is exposure to infected triatomine (or riduviid) bugs. Most infections are asymptomatic or cause non-specific, flu-like symptoms and are not diagnosed. Chagas disease can cause serious complications of the heart and gastrointestinal tract in approximately 30 per cent of infected individuals. Donors who were diagnosed to have Chaga's disease are deferred permanently. Since screening tests for donors are not available, donors with an identified risk of Chagas disease should be permanently deferred. Risk factors include:\n" +
                            "\n" +
                            "1.\tDonors born in South America or Central America and Mexico\n" +
                            "2.\tMother was born in South America or Central America and Mexico\n" +
                            "3.\tReceived blood transfusion in South America or Central America and Mexico\n" +
                            "4.\tLived or worked in rural subsistence farming communities in South America or Central America and Mexico for a continuous period of four weeks or more\n" +
                            "\n" +
                            "For more information regarding this matter, please speak to our medical staff.";
                    success = false;
                    break;
                }
            case R.id.no_btn49:
                if (checked)
                    break;
            case R.id.yes_btn51:
                if (checked) {
                    hepaVacine.setVisibility(View.VISIBLE);
                    EditText text = (EditText) findViewById(R.id.quiz_answer_52);
                    if(!text.getText().toString().isEmpty()) {
                        Date date = (Date) text.getText();
                        Calendar cal = Calendar.getInstance();
                        cal.setTimeInMillis(Calendar.getInstance().getTimeInMillis() - (2 * 24 * 60 * 60 * 1000));
                        Boolean isBefore = date.before(cal.getTime());
                        if (!isBefore) {
                            result += "You may donate blood 48 hours after the vaccination if you have no symptoms.";
                            success = false;
                        }
                    }

                    break;
                }

            case R.id.no_btn51:
                if (checked)
                    break;
            case R.id.yes_btn53:
                if (checked) {
                    otherVacine.setVisibility(View.VISIBLE);
                    EditText quizAnswer54 = (EditText) findViewById(R.id.quiz_answer_54);
                    Editable text = (Editable) quizAnswer54.getText();
                    result += "Your answer:\t" + text + "\n";
                    result += "There are different deferral periods depending on the type of vaccination and the reason it was given. The deferral periods range from 48 hours to 12 months after the vaccination. For more information regarding this matter, please speak to the medical staffs at the blood bank.";
                    success = false;
                    break;
                }
            case R.id.no_btn53:
                if (checked)
                    break;
            case R.id.yes_btn55:
                if (checked) {
                    result += "There are different deferral periods, depending on the condition of the small pox vaccination site and whether there any post-vaccination complications. Please contact our medical officer at Tel: 62130626 for more information/advice. \n" +
                            "\n" +
                            "For those recently exposed to another person's small pox vaccination site, the period of deferral would depend on whether there are any post-exposure complications present. \n" +
                            "\n" +
                            "For more information regarding this matter, please speak to our medical staff.";
                    success = false;
                    break;
                }
            case R.id.no_btn55:
                if (checked)
                    break;
            case R.id.yes_btn56:
                if (checked) {
                    result += "You are advised not to donate blood during pregnancy or within six weeks after the delivery or abortion. If the delivery was by Caeserean Section, please wait for 6 months from the operation before donating blood. \n" +
                            "\n" +
                            "If you are still breastfeeding, you should not donate blood as this may reduce your iron stores and affect your baby's iron intake from the breast milk. \n" +
                            "\n" +
                            "Donors who are still breastfeeding their infant should only donate after she has stopped breast-feeding.";
                    success = false;
                    break;
                }
            case R.id.no_btn56:
                if (checked)
                    break;
            case R.id.yes_btn57:
                if (checked) {
                    result += "You are advised not to donate blood during pregnancy or within six weeks after the delivery or abortion. If the delivery was by Caeserean Section, please wait for 6 months from the operation before donating blood. \n" +
                            "\n" +
                            "If you are still breastfeeding, you should not donate blood as this may reduce your iron stores and affect your baby's iron intake from the breast milk. \n" +
                            "\n" +
                            "Donors who are still breastfeeding their infant should only donate after she has stopped breast-feeding.";
                    success = false;
                    break;
                }
            case R.id.no_btn57:
                if (checked)
                    break;
            case R.id.yes_btn59:
                if (checked) {
                    malariaGroup1.setVisibility(View.VISIBLE);
                    travelledOutsideSingapore = true;
                    break;
                }
            case R.id.no_btn59:
                if (checked)
                    break;
            case R.id.yes_btn61:
                if (checked)
                    break;
            case R.id.no_btn61:
                if (checked)
                    break;
            case R.id.yes_btn63:
                if (checked)
                    break;
            case R.id.no_btn63:
                if (checked)
                    break;
            case R.id.yes_btn64:
                if (checked)
                    break;
            case R.id.no_btn64:
                if (checked)
                    break;
            case R.id.yes_btn65:
                if (checked)
                    break;
            case R.id.no_btn65:
                if (checked)
                    break;
            case R.id.yes_btn66:
                if (checked)
                    break;
            case R.id.no_btn66:
                if (checked)
                    break;
            case R.id.yes_btn67:
                if (checked)
                    break;
            case R.id.no_btn67:
                if (checked)
                    break;
        }
    }
    private Boolean checkInList(String value){
        for(int i=0; i < malaria_countries.length; i++){
            if(value.equals(malaria_countries[i])){
                return true;
            }
        }
        return false;
    }


}
