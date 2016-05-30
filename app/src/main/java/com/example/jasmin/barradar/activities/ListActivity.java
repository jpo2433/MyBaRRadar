package com.example.jasmin.barradar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jasmin.barradar.R;
import com.example.jasmin.barradar.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Location;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private ItemAdapter adapter;
    private DefaultApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //to prevent networkonmainthreadexception
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        api = new DefaultApi();
        ApiInvoker.getInstance().ignoreSSLCertificates(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ListActivity.this, AddLocationActivity.class);
                    startActivityForResult(intent, 100);
                }
            });
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.list_locations);

        List<Location> locations = new ArrayList<>();
        try {
            //TODO users position
            locations = api.locationsGet(10.0,10.0,10.0);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        adapter = new ItemAdapter(this, android.R.layout.simple_list_item_1, locations);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, LocationActivity.class);
                intent.putExtra("location", adapter.getItem(position));
                startActivityForResult(intent, 111);
            }
        });

        registerForContextMenu(listView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2 || requestCode == 111) {
            if (resultCode == RESULT_OK) {
                updateLocationListView();
            }
        }
    }

    public void updateLocationListView() {
        List<Location> assignments = null;
        try {
            //TODO user position and radius
            assignments = api.locationsGet(10.0,10.0,10.0);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        adapter = new ItemAdapter(this, android.R.layout.simple_list_item_1, assignments);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Delete");
        menu.add(1, v.getId(), 1, "Edit");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getTitle() == "Delete") {
            Toast.makeText(getApplicationContext(), "Location deleted", Toast.LENGTH_LONG).show();
            Location assignment = adapter.getItem(info.position);
            adapter.remove(assignment);
            try {
                api.locationsDelete(assignment.getLocationId());
            } catch (ApiException e) {
                e.printStackTrace();
            }
            updateLocationListView();
        } else if(item.getTitle() == "Edit") {
            Intent intent = new Intent(ListActivity.this, EditLocationActivity.class);
            intent.putExtra("location", adapter.getItem(info.position));
            startActivityForResult(intent, 111);
        }else{
            return false;
        }
        return true;
    }

}
