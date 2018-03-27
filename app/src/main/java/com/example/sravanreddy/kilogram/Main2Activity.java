package com.example.sravanreddy.kilogram;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText dob, userName, password, confirmPassword;
    CheckBox checkBox;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main2);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.my_titlebar);

        dob=findViewById(R.id.dob_edittext);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datepicker=new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(), "Date picker");
            }
        });
        userName=findViewById(R.id.usernameET_signup);
        password=findViewById(R.id.passwordET_signup);
        confirmPassword=findViewById(R.id.confirmPassword_edittext);
        checkBox=findViewById(R.id.agree_check);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar calender=Calendar.getInstance();
        calender.set(Calendar.YEAR, year);
        calender.set(Calendar.MONTH, month);
        calender.set(Calendar.DAY_OF_MONTH, day);
        dob.setText(DateFormat.getDateInstance().format(calender.getTime()));
    }

    public void radioClickHandler(View view) {
        boolean checked=((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.female_radio:
                if(checked){
                gender=((RadioButton)view).getText().toString();
                }
                break;
            case R.id.male_radio:
                if(checked){
                    gender=((RadioButton)view).getText().toString();
                }
                break;

        }
    }

    public void submitHandler(View view) {
        if(checkBox.isChecked() && ((password.getText().toString()).equals(confirmPassword.getText().toString())) && userName.getText().toString()!=null && password.getText().toString()!=null ){
            Intent intent=new Intent(Main2Activity.this, Main3Activity.class);
            intent.putExtra("username", userName.getText().toString());
            intent.putExtra("password", password.getText().toString());
            intent.putExtra("gender", gender);
            intent.putExtra("dob", dob.getText().toString());
            startActivity(intent);
        }
        else if(!checkBox.isChecked()){
            Toast.makeText(Main2Activity.this,"Please agree to the Contions", Toast.LENGTH_SHORT).show();
        }
        else if(!password.equals(confirmPassword)){
            Toast.makeText(Main2Activity.this,"Please check the password", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(Main2Activity.this,"Please fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }
}
