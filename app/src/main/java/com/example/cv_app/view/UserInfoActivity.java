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
    private EditText mName, mEmail, mHobbies;
    private Spinner mGender,mAge ;

    ArrayList<String> genderList;
    ArrayList<String> ageList;
    ArrayAdapter<String> arrayAdapterGender;
    ArrayAdapter<String> arrayAdapterAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        nextButton = findViewById(R.id.nextButtonId);
        mName = findViewById(R.id.editTextNameId);
        mEmail = findViewById(R.id.editTextEmailId);
        mHobbies = findViewById(R.id.editTextHobbiesId);
        mGender = findViewById(R.id.editGenderId);
        mAge = findViewById(R.id.editAgeId);


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

        mGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String selectGender= parent.getItemAtPosition(position).toString();
               mAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String selectAge= parent.getItemAtPosition(position).toString();

                        nextButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (TextUtils.isEmpty(mName.getText().toString())) {
                                    mName.setError("not valid");
                                }else if(TextUtils.isEmpty(mEmail.getText().toString())){
                                    mEmail.setError("not valid");
                                }else if(TextUtils.isEmpty(mHobbies.getText().toString())){
                                    mHobbies.setError("not valid");
                                }else {
                                    Intent intent = new Intent(UserInfoActivity.this, MoreInfoActivity.class);
                                    intent.putExtra("name", mName.getText().toString());
                                    intent.putExtra("email",mEmail.getText().toString());
                                    intent.putExtra("hobbies", mHobbies.getText().toString());
                                    intent.putExtra("gender",selectGender);
                                    intent.putExtra("age",selectAge);

                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}