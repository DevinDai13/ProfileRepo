package com.example.profile20;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileDetailActivity extends AppCompatActivity {

    TextView nameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

        nameTextView = (TextView) findViewById(R.id.nameTextView);

        String profileName = (String) getIntent().getExtras().get("ProfileName");

        nameTextView.setText(profileName);
    }
}
