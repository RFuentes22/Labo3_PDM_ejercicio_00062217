package com.example.labo3ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.labo3ejercicio.utils.AppConstant;

import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {


    private TextView mTextView_User,mTextView_LastName,mTextView_Email,mTextView_Gender;
    private Button mShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextView_User = findViewById(R.id.tvuser);
        mTextView_LastName = findViewById(R.id.tvlastname);
        mTextView_Email = findViewById(R.id.tvemail);
        mTextView_Gender = findViewById(R.id.tvgender);
        mShare = findViewById(R.id.btnshare);
        Intent mIntent = getIntent();

        if (mIntent!=null){
            mTextView_User.setText(mTextView_User.getText() + mIntent.getStringExtra(AppConstant.TEXT_Name));
            mTextView_LastName.setText(mTextView_LastName.getText() + mIntent.getStringExtra(AppConstant.TEXT_LastName));
            mTextView_Email.setText(mTextView_Email.getText() + mIntent.getStringExtra(AppConstant.TEXT_Email));
            mTextView_Gender.setText(mTextView_Gender.getText() + mIntent.getStringExtra(AppConstant.TEXT_Gender));


        }

        mShare.setOnClickListener(v -> {
            String textUser=mIntent.getStringExtra(AppConstant.TEXT_Name);
            String textLastname=mIntent.getStringExtra(AppConstant.TEXT_LastName);
            String textEmail=mIntent.getStringExtra(AppConstant.TEXT_Email);
            String genderValue= mIntent.getStringExtra(AppConstant.TEXT_Gender);



            Intent mIntent2 = new Intent();
            mIntent2.setType("text/plain");
            mIntent2.setAction(Intent.ACTION_SEND);
            mIntent2.putExtra(AppConstant.TEXT_Name,textUser); //identificador
            mIntent2.putExtra(AppConstant.TEXT_LastName,textLastname);
            mIntent2.putExtra(AppConstant.TEXT_Email,textEmail);
            mIntent2.putExtra(AppConstant.TEXT_Gender,genderValue);

            startActivity(mIntent2);
        });
    }
}
