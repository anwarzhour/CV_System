package com.example.cv_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cv_app.R;
import com.example.cv_app.model.User;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private Button nextButton;
    private EditText mName, mEmail;
    private Spinner mGender,mAge, mDriveLicense, mHobbies ;

    ArrayList<String> genderList;
    ArrayList<String> ageList;
    ArrayList<String> driveList;
    ArrayList<String> hobbiesList;

    ArrayAdapter<String> arrayAdapterGender;
    ArrayAdapter<String> arrayAdapterAge;
    ArrayAdapter<String> arrayAdapterDriveLicense;
    ArrayAdapter<String> arrayAdapterHobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        nextButton = findViewById(R.id.nextButtonId);
        mName = findViewById(R.id.editTextNameId);
        mEmail = findViewById(R.id.editTextEmailId);
        mHobbies = findViewById(R.id.hobbiesId);
        mGender = findViewById(R.id.editGenderId);
        mAge = findViewById(R.id.editAgeId);
        mDriveLicense = findViewById(R.id.driveId);



        driveList = new ArrayList<>();
        driveList.add("Yes");
        driveList.add("No");

        arrayAdapterDriveLicense = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,driveList);
        arrayAdapterDriveLicense.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDriveLicense.setAdapter(arrayAdapterDriveLicense);


        hobbiesList = new ArrayList<>();
        hobbiesList.add("Gaming");
        hobbiesList.add("Travel");
        hobbiesList.add("Art");
        hobbiesList.add("Nature");
        hobbiesList.add("Social");
        hobbiesList.add("History");



        arrayAdapterHobbies = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,hobbiesList);
        arrayAdapterHobbies.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mHobbies.setAdapter(arrayAdapterHobbies);




        genderList = new ArrayList<>();
        genderList.add("male");
        genderList.add("female");

        arrayAdapterGender = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,genderList);
        arrayAdapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGender.setAdapter(arrayAdapterGender);

        ageList = new ArrayList<>();
        ageList.add("18");
        ageList.add("19");
        ageList.add("20");
        ageList.add("21");
        ageList.add("22");
        ageList.add("23");
        ageList.add("24");
        ageList.add("25");
        ageList.add("26");
        ageList.add("27");
        ageList.add("28");
        ageList.add("29");
        ageList.add("30");
        ageList.add("31");
        ageList.add("32");
        ageList.add("33");

        arrayAdapterAge = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,ageList);
        arrayAdapterAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAge.setAdapter(arrayAdapterAge);


        User user = new User();

        mHobbies.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectHobbies= parent.getItemAtPosition(position).toString();
                user.setHobbies(selectHobbies);


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        mGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectGender= parent.getItemAtPosition(position).toString();
                user.setGender(selectGender);


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectAge= parent.getItemAtPosition(position).toString();
                user.setAge(selectAge);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mDriveLicense.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectDriveLicense= parent.getItemAtPosition(position).toString();
                user.setDriveLicense(selectDriveLicense);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, MoreInfoActivity.class);
                //use it to send data to next activity
                intent.putExtra("name", mName.getText().toString());
                intent.putExtra("email",mEmail.getText().toString());
                intent.putExtra("hobbies", user.getHobbies());
                intent.putExtra("drive",user.getDriveLicense());
                intent.putExtra("age",user.getAge());
                intent.putExtra("gender",user.getGender());
                startActivity(intent);
                finish();
            }
        });


    }


}