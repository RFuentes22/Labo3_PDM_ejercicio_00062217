package com.example.labo3ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class Main3Activity extends AppCompatActivity {

    private TextView mTextView_User, mTextView_LastName, mTextView_Email, mTextView_Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mTextView_User = findViewById(R.id.tvuser);
        mTextView_LastName = findViewById(R.id.tvlastname);
        mTextView_Email = findViewById(R.id.tvemail);
        mTextView_Gender = findViewById(R.id.tvgender);

        Intent mIntent2 = getIntent();

        try {
            JSONObject jobj = new JSONObject(mIntent2.getStringExtra("JSON"));
            if (mIntent2!=null){
                mTextView_User.setText(mTextView_User.getText() + " " + jobj.getString("name") );
                mTextView_LastName.setText(mTextView_LastName.getText() + " " + jobj.getString("lastname") );
                mTextView_Email.setText(mTextView_Email.getText() + " " + jobj.getString("email"));
                mTextView_Gender.setText(mTextView_Gender.getText() + " " + jobj.getString("gender"));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}