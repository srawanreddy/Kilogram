package com.example.sravanreddy.kilogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView username, gender, dateofbirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main3);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.my_titlebar);
        username=findViewById(R.id.userName_final);
        username.setText(getIntent().getExtras().getString("username"));
        gender=findViewById(R.id.gender_textview);
        gender.setText(getIntent().getExtras().getString("gender"));
        dateofbirth=findViewById(R.id.dob_textview);
        dateofbirth.setText(getIntent().getExtras().getString("dob"));
    }

    public void handleClick(View view) {
        Intent login=new Intent(Main3Activity.this, MainActivity.class);
        startActivity(login);
    }
}
