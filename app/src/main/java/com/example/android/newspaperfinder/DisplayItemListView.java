package com.example.android.newspaperfinder;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;

import info.androidhive.androidsplashscreentimer.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class DisplayItemListView extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    LocationAdapter locationAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_item_listview_layout);
        listView = (ListView) findViewById(R.id.listview);
        locationAdapter = new LocationAdapter(this, R.layout.row_layout);
        listView.setAdapter(locationAdapter);

        //get the string from the intent via the key specified in parseJSON method
        json_string = getIntent().getExtras().getString("json_data");
        // pass the JSON data
        //TODO: read from newspaper_locations.json file
        //https://developer.android.com/reference/android/util/JsonReader.html;

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("locations");
            int count = 0;
            String style, details, latitude, longitude;

            while(count < jsonObject.length()) {

              JSONObject jObj = jsonArray.getJSONObject(count);
                style = jObj.getString("style");
                details = jObj.getString("details");
                latitude = jObj.getString("lat");
                longitude = jObj.getString("lng");
                Locations locations = new Locations(style, details, latitude, longitude);
                locationAdapter.add(locations);
                count++;

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
