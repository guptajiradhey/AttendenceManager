package com.example.attendencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String subjectName = getIntent().getStringExtra("subject");
        String filename = getIntent().getStringExtra("file");

        TextView subjecttxt = findViewById(R.id.subjecttxt);
        subjecttxt.setText(subjectName);

        sp = getSharedPreferences(filename,0);
    }

    public void update(View v){
        EditText presenttxt = findViewById(R.id.presenttxt);
        EditText totaltxt = findViewById(R.id.totaltxt);
        int present = Integer.parseInt(presenttxt.getText().toString());
        int total = Integer.parseInt(totaltxt.getText().toString());
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("present",present);
        editor.putInt("total",total);
        editor.apply();
    }
}
