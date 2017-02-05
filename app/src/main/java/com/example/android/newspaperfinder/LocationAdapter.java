package com.example.android.newspaperfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.androidsplashscreentimer.R;

/**
 * Created by epatter1 on 2/4/2017.
 */

public class LocationAdapter extends ArrayAdapter{
    List list = new ArrayList();

    public LocationAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Locations object) {
        super.add(object);
        list.add(object);
    }
    //get total number of location objects
    @Override
    public int getCount() {
        return list.size();
    }

    //get each object from the list
    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    //converts XML to corresponding ViewGroup and passes textView objects to that View
        View row;
        row = convertView;
        LocationHolder locationHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            locationHolder = new LocationHolder();
            locationHolder.tview_style = (TextView) row.findViewById(R.id.tview_style);
            locationHolder.tview_details = (TextView) row.findViewById(R.id.tview_details);
            locationHolder.tview_latitude = (TextView) row.findViewById(R.id.tview_latitude);
            locationHolder.tview_longitude = (TextView) row.findViewById(R.id.tview_longitude);
            row.setTag(locationHolder);

        }
        else {
            locationHolder = (LocationHolder) row.getTag();
        }

        Locations locations = (Locations) this.getItem(position);
        locationHolder.tview_style.setText(locations.getStyle());
        locationHolder.tview_details.setText(locations.getDetails());
        locationHolder.tview_latitude.setText(locations.getLatitude());
        locationHolder.tview_longitude.setText(locations.getLongitude());

        return row;


    }
    // houses the location textview objects
    static class LocationHolder
    {
        TextView tview_style, tview_details, tview_longitude, tview_latitude;
    }
}
