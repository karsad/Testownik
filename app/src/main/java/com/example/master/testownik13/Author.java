package com.example.master.testownik13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Author extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
    }

    public void onClick_return(View view) {
        finish();
    }

    public void onClick_contact(View view) {
        String chooser_title = getString(R.string.chooser_title1);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Testownik - kontakt");
        String email = getString(R.string.email);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {email});
        Intent chooser = Intent.createChooser(intent, chooser_title);
        startActivity(chooser);
    }

}
