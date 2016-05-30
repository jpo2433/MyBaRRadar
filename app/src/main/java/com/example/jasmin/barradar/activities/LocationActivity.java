package com.example.jasmin.barradar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.jasmin.barradar.R;

public class LocationActivity extends AppCompatActivity {

    private TextView title;
    private TextView type;
    private TextView address;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final io.swagger.client.model.Location location_id = (io.swagger.client.model.Location) getIntent().getSerializableExtra("location");

        title = (TextView) findViewById(R.id.location_title);
        type = (TextView) findViewById(R.id.location_type);
        address = (TextView) findViewById(R.id.location_address);
        description = (TextView) findViewById(R.id.location_description);

        refreshLocationView(location_id);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LocationActivity.this, EditLocationActivity.class);
                    intent.putExtra("location", location_id);
                    startActivityForResult(intent, 110);
                }
            });
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 110){
            if(resultCode == RESULT_OK) {
               refreshLocationView((io.swagger.client.model.Location) data.getExtras().getSerializable("location"));
            }
        }
    }

    private void refreshLocationView(io.swagger.client.model.Location location){
        title.setText(location.getTitle());
        type.setText(location.getType());
        address.setText(location.getAddress());
        description.setText(location.getDescription());
    }
}
