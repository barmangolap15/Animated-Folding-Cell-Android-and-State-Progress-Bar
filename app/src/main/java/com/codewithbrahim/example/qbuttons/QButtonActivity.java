package com.codewithbrahim.example.qbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codewithbrahim.example.R;
import com.manojbhadane.QButton;

public class QButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_button);


        QButton qButton = (QButton) findViewById(R.id.btn);

        qButton.setCornerRadious(5);
        qButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        qButton.setStrokeWidth(5);
        qButton.setStrokeDashGap(5);
        qButton.setStrokeDashWidth(90);
        qButton.setStrokeColor(getResources().getColor(R.color.colorPrimaryDark));

    }
}