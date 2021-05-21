package com.codewithbrahim.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codewithbrahim.example.custom.UserDetailsView;
import com.kofigyan.stateprogressbar.StateProgressBar;

public class StateProgressActivity extends UsageBaseActivity implements UserDetailsView.OnUserDetailClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_progress);

        stateprogressbar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
        setupUserDetailsView();

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), UsagePricingActivity.class);
        startActivity(intent);
    }

    @Override
    public void onUserDetailClickListener(View v) {
        switch (v.getId()) {
            case R.id.udvName:
                Toast.makeText(getApplicationContext(), "User Name Detail Clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.udvEmail:
                Toast.makeText(getApplicationContext(), "User Email Detail Clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.udvPhoneNumber:
                Toast.makeText(getApplicationContext(), "User Phone Number Detail Clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.udvPassword:
                Toast.makeText(getApplicationContext(), "User Password Detail Clicked", Toast.LENGTH_LONG).show();
                break;
        }

    }


    private void setupUserDetailsView() {
        setupUserDetailsView(R.id.udvName);
        setupUserDetailsView(R.id.udvEmail);
        setupUserDetailsView(R.id.udvPhoneNumber);
        setupUserDetailsView(R.id.udvPassword);
    }

    private void setupUserDetailsView(int viewId) {
        UserDetailsView udvView = (UserDetailsView) findViewById(viewId);
        udvView.setOnUserDetailClickListener(this);
    }
}