package com.example.dheeraj.sharedpreferencestest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {
    TextView textView2,textView4;
    Button load,prev;
    public static String DEFAULT="N/A";
    String name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        textView2=(TextView) findViewById(R.id.textview2);
        textView4=(TextView) findViewById(R.id.textview4);
        load=(Button) findViewById(R.id.button1);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("Mydata", MODE_PRIVATE);
                name = sharedPreferences.getString("name",DEFAULT);
                password = sharedPreferences.getString("password",DEFAULT);
                if(name==DEFAULT||password==DEFAULT){
                    Toast.makeText(NextActivity.this,"No DATA WAS FOUND",Toast.LENGTH_SHORT).show();
                }
                else{
                    textView2.setText(name.toString());
                    textView4.setText(password.toString());
                }
            }
        });
        prev=(Button) findViewById(R.id.button2);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NextActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

}
