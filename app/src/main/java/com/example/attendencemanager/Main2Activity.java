package com.example.attendencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String subjectname = getIntent().getStringExtra("subject");
        String filename = getIntent().getStringExtra("file");

        TextView subjecttxt = findViewById(R.id.subjecttxt);
        subjecttxt.setText(subjectname);
        sp = getSharedPreferences(filename,0);
        refresh();
    }
    public  void refresh(){
        int present =sp.getInt("present",0);
        int total = sp.getInt("total",0);
        TextView presenttxt = findViewById(R.id.percent);
        if (total==0)
            presenttxt.setText(present+"/"+total+"  "+(0)+"%");
        else
            presenttxt.setText(present+"/"+total+"  "+(present*100/total)+"%");

    }
    public void absentClick(View view){
        int total =  sp.getInt("total",0);
        total +=1;
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("total",total);
        editor.apply();
        refresh();
    }


    public void presentClick(View V){
        int present = sp.getInt("present",0);
        int total =  sp.getInt("total",0);
        present +=1;
        total +=1;
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("present",present);
        editor.putInt("total",total);
        editor.apply();
        refresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    public void editClick(View v){
        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);

        startActivity(intent);
        refresh();
    }
}
