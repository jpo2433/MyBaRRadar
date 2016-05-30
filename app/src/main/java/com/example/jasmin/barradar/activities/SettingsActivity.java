package com.example.jasmin.barradar.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jasmin.barradar.R;

import io.swagger.client.ApiException;

public class SettingsActivity extends AppCompatActivity {

    private EditText radius;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        radius = (EditText) findViewById(R.id.searching_radius);
        int rad = MainActivity.prefs.getInt("radius", 1000);
        radius.setText(""+rad);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int rad = Integer.parseInt(radius.getText().toString());
                    if(rad!= 0){
                        SharedPreferences.Editor editor = MainActivity.prefs.edit();
                        editor.putInt("radius", rad);
                        editor.commit();
                        Toast.makeText(SettingsActivity.this,"Radius changed",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
