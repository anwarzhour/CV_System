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

public class UserInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button nextButton;
    private EditText mName, mEmail, mHobbies, mAge;
    private Spinner mGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        nextButton = findViewById(R.id.nextButtonId);
        mName = findViewById(R.id.editTextNameId);
        mEmail = findViewById(R.id.editTextEmailId);
        mHobbies = findViewById(R.id.editTextHobbiesId);
        mGender = findViewById(R.id.editGenderId);
        mAge = findViewById(R.id.editTextAgeId);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGender.setAdapter(adapter);
        mGender.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectGender = parent.getItemAtPosition(position).toString();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mName.getText().toString())) {
                    mName.setError("not valid");
                }else if(TextUtils.isEmpty(mEmail.getText().toString())){
                    mEmail.setError("not valid");
                }else if(TextUtils.isEmpty(mHobbies.getText().toString())){
                    mHobbies.setError("not valid");
                }else if(TextUtils.isEmpty(mAge.getText().toString())){
                    mAge.setError("not valid");
                }else {
                    Intent intent = new Intent(UserInfoActivity.this, MoreInfoActivity.class);
                    intent.putExtra("name", mName.getText().toString());
                    intent.putExtra("email",mEmail.getText().toString());
                    intent.putExtra("hobbies", mHobbies.getText().toString());
                    intent.putExtra("gender",selectGender);
                    intent.putExtra("age", mAge.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}