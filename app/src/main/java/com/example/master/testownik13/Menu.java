package com.example.master.testownik13;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.color.black;
import static android.R.color.white;

public class Menu extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    boolean theme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        get_savedSettings();
        set_theme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClick_exit(View view) {
        System.exit(0);
    }

    public void onClick_author(View view) {
        Intent intent = new Intent(this, Author.class);
        startActivity(intent);
    }

    public void onClick_settings(View view) {
        Intent intent = new Intent (this, Settings.class);
        startActivity(intent);
    }

    public void onClick_start(View view) {
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Niestety jeszcze nie działa :C\n\n         Naciśnij WSTECZ!", Toast.LENGTH_LONG).show();

    }

    public void get_savedSettings(){
        sharedPreferences = getSharedPreferences("com.example.rysiu.testownik10", MODE_PRIVATE);
        theme = sharedPreferences.getBoolean("theme", false);
    }

    public void set_theme(boolean x) {
        if(x){
            setTheme(R.style.AppTheme_Night);
        }
        else{
            setTheme(R.style.AppTheme);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent reset = getIntent();
        finish();
        startActivity(reset);
    }
}
