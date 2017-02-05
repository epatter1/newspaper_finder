package com.example.android.newspaperfinder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

import info.androidhive.androidsplashscreentimer.R;

import static android.R.attr.start;

public class MainActivity extends Activity {

    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //method to convert json to string
    public void parseJSON(View view) {

        if (json_string == null) {

            Toast.makeText(getApplicationContext(), "JSON String not retrieved", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, DisplayItemListView.class);
            intent.putExtra("json_data", json_string);
            startActivity(intent);
        }
    }

    // method to retrieve json string from file
//    public String loadJSONfromFile() {
//        String json = null;
//        try {
//            InputStream inputStream = getAssets()
//        }
//    }


    //method to convert json to string
//    private String getJsonString(String json_string) {
//        try {
//            JSONObject json = new JSONObject(json_string);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }


}
