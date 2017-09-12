package com.example.tarek.mes_sage;


import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static java.security.AccessController.getContext;

public class ListAdapter extends ArrayAdapter<Message> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<Message> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_message, null);
        }

        Message m = getItem(position);

        if (m != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.list_name);
            TextView tt2 = (TextView) v.findViewById(R.id.list_number);

            if (tt1 != null) {
                tt1.setText(m.getName());
            }

            if (tt2 != null) {
                tt2.setText(m.getPhoneNumber());
            }
        }

        return v;
    }

}