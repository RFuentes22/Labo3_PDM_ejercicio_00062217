package com.example.labo3ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;
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


        try {
            JSONObject jobj = new JSONObject(mIntent.getStringExtra("JSON"));
            if (mIntent!=null){
                mTextView_User.setText(mTextView_User.getText() + " " + jobj.getString("name") );
                mTextView_LastName.setText(mTextView_LastName.getText() + " " + jobj.getString("lastname") );
                mTextView_Email.setText(mTextView_Email.getText() + " " + jobj.getString("email"));
                mTextView_Gender.setText(mTextView_Gender.getText() + " " + jobj.getString("gender"));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            JSONObject jobj = new JSONObject(mIntent.getStringExtra("JSON"));
            mShare.setOnClickListener(v -> {

                Intent mIntent2 = new Intent();
                mIntent2.setType("text/plain");
                mIntent2.setAction(Intent.ACTION_SEND);


                mIntent2.putExtra("JSON", String.valueOf(jobj));
                startActivity(mIntent2);
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
