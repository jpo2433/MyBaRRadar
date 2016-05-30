package com.example.jasmin.barradar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.jasmin.barradar.R;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.api.DefaultApi;

public class AddLocationActivity extends AppCompatActivity {

    private EditText name;
    private EditText type;
    private EditText address;
    private EditText description;
    private ImageButton image;

    private EditText lat;
    private EditText lng;
    private EditText radius;

    private DefaultApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //to prevent networkonmainthreadexception
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        api = new DefaultApi();
        ApiInvoker.getInstance().ignoreSSLCertificates(true);

        name = (EditText) findViewById(R.id.add_location_name);
        type = (EditText) findViewById(R.id.add_location_type);
        address = (EditText) findViewById(R.id.add_location_address);
        description = (EditText) findViewById(R.id.add_location_description);
        image = (ImageButton) findViewById(R.id.add_location_image);

        lat = (EditText) findViewById(R.id.add_location_latitude);
        lng = (EditText) findViewById(R.id.add_location_longitude);
        radius = (EditText) findViewById(R.id.add_location_radius);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   //TODO handle image
                    io.swagger.client.model.Location loc = null;
                    try {
                        loc = api.locationsPut(name.getText().toString(), type.getText().toString(),Double.parseDouble(lat.getText().toString()), Double.parseDouble(lng.getText().toString()), Double.parseDouble(radius.getText().toString()), address.getText().toString(), null, description.getText().toString(), null);
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                   Intent resultIntent = new Intent();
                    resultIntent.putExtra("location", loc);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            });
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
