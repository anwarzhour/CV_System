package com.example.cv_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cv_app.R;
import com.example.cv_app.model.User;
import com.google.gson.Gson;

public class ShowInfoActivity extends AppCompatActivity {


    private SharedPreferences sharedPreferences;
    private static final String Shared_PREF_NAME="mypref";
    private static final String KEY_NAME="name" ;
    private static final String KEY_EMAIL = "email";
    private static final String KEY_HOBBIES = "hobbies";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_AGE = "age";
    private static final String KEY_WORK="work" ;
    private static final String KEY_EDUCATION = "education";
    private static final String KEY_QUALIFICATIONS="qualifications" ;
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_DRIVE ="drive";

    private TextView mName, mEmail, mHobbies, mGender, mAge, mWork, mEduction, mQualifications, mLanguage, mDriveLicense;
    private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        mName = findViewById(R.id.viewTextNameId);
        mEmail = findViewById(R.id.viewTextEmailId);
        mHobbies = findViewById(R.id.viewTextHobbiesId);
        mGender = findViewById(R.id.viewTextGenderId);
        mAge = findViewById(R.id.viewTextAgeId);
        mWork = findViewById(R.id.viewTextWorkId);
        mEduction = findViewById(R.id.viewTextEductionId);
        mQualifications = findViewById(R.id.viewTextQualificationsId);
        mLanguage = findViewById(R.id.viewTextLanguageId);
        done = findViewById(R.id.doneButton);
        mDriveLicense = findViewById(R.id.viewTextDriveId);


        //call sharedPreferences to get or show user data
        sharedPreferences = getSharedPreferences(Shared_PREF_NAME,MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);
        String hobbies = sharedPreferences.getString(KEY_HOBBIES, null);
        String gender = sharedPreferences.getString(KEY_GENDER,null);
        String age = sharedPreferences.getString(KEY_AGE, null);
        String work = sharedPreferences.getString(KEY_WORK,null);
        String education = sharedPreferences.getString(KEY_EDUCATION,null);
        String qualifications = sharedPreferences.getString(KEY_QUALIFICATIONS, null);
        String language = sharedPreferences.getString(KEY_LANGUAGE,null);
        String drive = sharedPreferences.getString(KEY_DRIVE,null);

        //todo:
       // Gson gson = new Gson();

        User user = new User(name,email,hobbies,gender,age,work,education,qualifications,language,drive);

       // String json = gson.toJson(user);


        if(name != null || email != null){
            mName.setText(name);
            mEmail.setText(user.getEmail());
            mHobbies.setText(user.getHobbies());
            mGender.setText(user.getGender());
            mAge.setText(user.getAge());
            mWork.setText(user.getWork());
            mEduction.setText(user.getEduction());
            mQualifications.setText(user.getQualifications());
            mLanguage.setText(user.getLanguage());
            mDriveLicense.setText(user.getDriveLicense());

        }



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowInfoActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}