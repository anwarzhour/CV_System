package com.example.cv_app.view;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cv_app.R;
import com.example.cv_app.model.User;


public class CV_ViewFragment extends Fragment {

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

    private TextView mName, mEmail, mHobbies, mGender, mAge, mWork, mEduction, mQualifications, mLanguage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_c_v__view, container, false);

        mName = view.findViewById(R.id.viewTextNameId);
        mEmail = view.findViewById(R.id.viewTextEmailId);
        mHobbies = view.findViewById(R.id.viewTextHobbiesId);
        mGender = view.findViewById(R.id.viewTextGenderId);
        mAge = view.findViewById(R.id.viewTextAgeId);
        mWork = view.findViewById(R.id.viewTextWorkId);
        mEduction = view.findViewById(R.id.viewTextEductionId);
        mQualifications = view.findViewById(R.id.viewTextQualificationsId);
        mLanguage = view.findViewById(R.id.viewTextLanguageId);

        sharedPreferences = getActivity().getSharedPreferences(Shared_PREF_NAME,getActivity().MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);
        String hobbies = sharedPreferences.getString(KEY_HOBBIES, null);
        String gender = sharedPreferences.getString(KEY_GENDER,null);
        String age = sharedPreferences.getString(KEY_AGE, null);
        String work = sharedPreferences.getString(KEY_WORK,null);
        String education = sharedPreferences.getString(KEY_EDUCATION,null);
        String qualifications = sharedPreferences.getString(KEY_QUALIFICATIONS, null);
        String language = sharedPreferences.getString(KEY_LANGUAGE,null);

        User user = new User(name,email,hobbies,gender,age,work,education,qualifications,language);



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
        }

        return view;
    }
}