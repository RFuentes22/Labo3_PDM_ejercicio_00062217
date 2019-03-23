package com.example.labo3ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import com.example.labo3ejercicio.utils.AppConstant;


public class MainActivity extends AppCompatActivity {

     EditText name,lastname,email;

     Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= findViewById(R.id.name);
        lastname= findViewById(R.id.lastname);
        email = findViewById(R.id.email);



        btn1.setOnClickListener(v -> {
            String text=name.getText().toString();

            Intent mIntent=new Intent(MainActivity.this,Main2Activity.class);
            mIntent.putExtra(AppConstant.TEXT_KEY,text); //identificador
            startActivity(mIntent);


        });


    }
}
