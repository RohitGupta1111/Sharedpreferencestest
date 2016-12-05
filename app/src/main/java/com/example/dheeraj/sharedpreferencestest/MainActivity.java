package com.example.dheeraj.sharedpreferencestest;

import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//test change
    EditText editText1;
    EditText editText2;
    Button save,next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText) findViewById(R.id.textview2);
        editText2=(EditText) findViewById(R.id.textview4);
        save=(Button) findViewById(R.id.button1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("Mydata",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("name",editText1.getText().toString());
                editor.putString("password",editText2.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"DATA SAVED",Toast.LENGTH_SHORT).show();
            }
        });
        next=(Button) findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });
    }
}
