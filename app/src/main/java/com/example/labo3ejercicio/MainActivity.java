package com.example.labo3ejercicio;

import android.content.Intent;
import android.nfc.Tag;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;

import com.example.labo3ejercicio.utils.AppConstant;


public class MainActivity extends AppCompatActivity {

    private EditText name,lastname,email;
    private RadioButton gender;
    private Button btnsubmit;
    private RadioGroup genders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsubmit = findViewById(R.id.btnsubmit);
        name= findViewById(R.id.name);
        lastname= findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        genders= findViewById(R.id.radiogroup);



        btnsubmit.setOnClickListener(v -> {
           String textName=name.getText().toString();
           String textLastname=lastname.getText().toString();
           String textEmail=email.getText().toString();


            int idRadio = genders.getCheckedRadioButtonId();
            gender = findViewById(idRadio);
            String genderValue=gender.getText().toString();

            Intent mIntent=new Intent(MainActivity.this,Main2Activity.class);
            mIntent.putExtra(AppConstant.TEXT_Name,textName); //identificador
            mIntent.putExtra(AppConstant.TEXT_LastName,textLastname);
            mIntent.putExtra(AppConstant.TEXT_Email,textEmail);
            mIntent.putExtra(AppConstant.TEXT_Gender,genderValue);
            startActivity(mIntent);


        });


    }
}
