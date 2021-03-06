package com.example.tarek.mes_sage;


import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.ContentValues.TAG;
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

        final Message m = getItem(position);

        final ImageButton send = (ImageButton) v.findViewById(R.id.send_boolean);
        if(!m.isSend()){
            send.setColorFilter(android.R.color.darker_gray);
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked ");
                if(m.isSend()){
                    m.setSend(false);
                    send.setColorFilter(android.R.color.darker_gray);
                }
                else{
                    m.setSend(true);
                    send.setColorFilter(Color.argb(255, 8, 190, 199));
                }
            }
        });

        if (m != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.list_name);
            TextView tt2 = (TextView) v.findViewById(R.id.list_number);
            TextView tt3 = (TextView) v.findViewById(R.id.list_frequency);
            TextView tt4 = (TextView) v.findViewById(R.id.list_message);
            TextView tt5 = (TextView) v.findViewById(R.id.list_date);
            TextView tt6 = (TextView) v.findViewById(R.id.list_time);

            if (tt1 != null) {
                tt1.setText(m.getName());
            }
            if (tt2 != null) {
                tt2.setText(m.getPhoneNumber());
            }
            if (tt3 != null) {
                tt3.setText(m.getFrequency());
            }
            if (tt4 != null) {
                tt4.setText(m.getMessageText());
            }
            if (tt5 != null) {
                tt5.setText(m.getYear()+ "/" + m.getMonth()+"/"+ m.getDay());
            }
            if (tt6 != null) {
                tt6.setText(m.getHour()+":"+m.getMinute());
            }
        }
            return v;
    }

}