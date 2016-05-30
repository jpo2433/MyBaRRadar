package com.example.jasmin.barradar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jasmin.barradar.R;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.api.DefaultApi;

public class EditLocationActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_edit_location);
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
        lat = (EditText) findViewById(R.id.edit_location_latitude);
        lng = (EditText) findViewById(R.id.edit_location_longitude);
        radius = (EditText) findViewById(R.id.edit_location_radius);

        final io.swagger.client.model.Location location = (io.swagger.client.model.Location) getIntent().getSerializableExtra("location");

        name.setText(location.getTitle());
        type.setText(location.getType());
        address.setText(location.getAddress());
        description.setText(location.getDescription());
        lat.setText(location.getLatitude().toString());
        lng.setText(location.getLongitude().toString());
        radius.setText(location.getRadius().toString());

        //TODO image

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name1 = name.getText().toString();
                    String description1 = description.getText().toString();
                    String type1 = type.getText().toString();
                    String address1 = address.getText().toString();
                    Double lat1 = Double.parseDouble(lat.getText().toString());
                    Double lng1 = Double.parseDouble(lng.getText().toString());
                    Double radius1 = Double.parseDouble(radius.getText().toString());

                    //TODO image
                    location.setTitle(name1);
                    location.setType(type1);
                    location.setAddress(address1);
                    location.setDescription(description1);
                    location.setLatitude(lat1);
                    location.setLongitude(lng1);
                    location.setRadius(radius1);
                    //TODO image
                    try {
                        api.locationsPut(location.getTitle(),location.getType(), location.getLatitude(), location.getLongitude(), location.getRadius(), location.getAddress(), location.getLocationId(), location.getDescription(), null);
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(EditLocationActivity.this, "Location Updated", Toast.LENGTH_SHORT).show();

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("location", location);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            });
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
