package com.example.cv_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.cv_app.R;
import com.example.cv_app.model.User;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MoreInfoActivity extends AppCompatActivity {


    private Button save;
    private EditText mWork, mEducation, mQualifications;
    private Spinner mLanguage, sEducation;


    private SharedPreferences sharedPreferences;
    private static final String Shared_PREF_NAME="mypref";
    private static final String KEY_NAME="name" ;
    private static final String KEY_EMAIL = "email";
    private static final String KEY_HOBBIES = "hobbies";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_AGE = "age";
    private static final String KEY_DRIVE ="drive";
    private static final String KEY_WORK="work" ;
    private static final String KEY_EDUCATION = "education";
    private static final String KEY_QUALIFICATIONS="qualifications" ;
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_EDUCTION_TYPE = "educationType";




    ArrayList<String> languageList;
    ArrayAdapter<String> arrayAdapterLanguage;

    ArrayList<String> educationList;
    ArrayAdapter<String> arrayAdapterEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);


        mWork = findViewById(R.id.editTextWorkId);
        mEducation = findViewById(R.id.editTextEductionId);
        mQualifications = findViewById(R.id.editTextQualificationsId);
        mLanguage = findViewById(R.id.editLanguageId);
        sEducation = findViewById(R.id.spinnerEductionId);
        save = findViewById(R.id.saveButtonId);


        sharedPreferences = getSharedPreferences(Shared_PREF_NAME,MODE_PRIVATE);

        languageList = new ArrayList<>();
        languageList.add("arabic");
        languageList.add("english");
        languageList.add("spanish");



        educationList = new ArrayList<>();
        educationList.add("BS");
        educationList.add("MS");
        educationList.add("PHD");
        educationList.add("other");



        arrayAdapterLanguage = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,languageList);
        arrayAdapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguage.setAdapter(arrayAdapterLanguage);


        arrayAdapterEducation = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,educationList);
        arrayAdapterEducation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sEducation.setAdapter(arrayAdapterEducation);


        User user = new User();
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String email = bundle.getString("email");
        String hobbies = bundle.getString("hobbies");
        String gender = bundle.getString("gender");
        String age = bundle.getString("age");
        String drive = bundle.getString("drive");


        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectLanguage= parent.getItemAtPosition(position).toString();
                user.setLanguage(selectLanguage);


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sEducation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectEduction= parent.getItemAtPosition(position).toString();
                user.setEductionType(selectEduction);


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, name);
                editor.putString(KEY_EMAIL, email);
                editor.putString(KEY_HOBBIES, hobbies);
                editor.putString(KEY_GENDER, gender);
                editor.putString(KEY_AGE, age);
                editor.putString(KEY_DRIVE,drive);
                editor.putString(KEY_WORK, mWork.getText().toString());
                editor.putString(KEY_EDUCATION, mEducation.getText().toString());
                editor.putString(KEY_QUALIFICATIONS, mQualifications.getText().toString());
                editor.putString(KEY_LANGUAGE,user.getLanguage() );
                editor.putString(KEY_EDUCTION_TYPE,user.getEductionType());
                editor.apply();
                Intent intent = new Intent(MoreInfoActivity.this, ShowInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}