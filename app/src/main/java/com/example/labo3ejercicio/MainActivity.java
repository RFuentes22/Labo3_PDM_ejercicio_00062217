package com.example.labo3ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.Button;



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

            JSONObject json= new JSONObject();


            try {
                json.put("name",textName);
                json.put("lastname",textLastname);
                json.put("email",textEmail);
                json.put("gender",genderValue);
            }
            catch (JSONException e){

            }

            Intent mIntent=new Intent(MainActivity.this,Main2Activity.class);
            mIntent.putExtra("JSON", String.valueOf(json));
            startActivity(mIntent);


        });


    }
}
