package com.example.tarek.mes_sage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Message> messageList = new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BuildMessageActivity.class);
                startActivity(intent);
            }
        });


        Context context = getApplicationContext();
        MessageController.loadMessageList(context);

        Context context2 = getApplicationContext();
        CharSequence text = MessageController.getMessageList().toString();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context2, text, duration);
        toast.show();


        messageList.add(new Message("A", "B", "C", "D", false, 1, 1, 1, 1, 2));
        messageList.add(new Message("a", "B", "C", "D", true, 1, 1, 1, 1, 2));
        messageList.add(new Message("A", "B", "C", "D", false, 1, 1, 1, 1, 2));
        messageList.add(new Message("a", "B", "C", "D", true, 1, 1, 1, 1, 2));
        messageList.add(new Message("A", "B", "C", "D", false, 1, 1, 1, 1, 2));
        messageList.add(new Message("a", "B", "C", "D", true, 1, 1, 1, 1, 2));
        messageList.add(new Message("A", "B", "C", "D", false, 1, 1, 1, 1, 2));
        messageList.add(new Message("a", "B", "C", "D", true, 1, 1, 1, 1, 2));
        messageList.add(new Message("A", "B", "C", "D", false, 1, 1, 1, 1, 2));

        if(messageList.isEmpty()){

            TextView ProgrammaticallyTextView = (TextView) findViewById(R.id.no_message);
            ProgrammaticallyTextView.setText(" You have no messages to send ");
            ProgrammaticallyTextView.setTextSize(12);
            ProgrammaticallyTextView.setPadding(20, 300, 20, 100);

        }
        else {
            ListView listView = (ListView) findViewById(R.id.message_list_view);
            // get data from the table by the ListAdapter
            ListAdapter customAdapter = new ListAdapter(this, R.layout.list_message, MessageController.getMessageList());
            listView.setAdapter(customAdapter);
        }

    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    public void onPause() {
        super.onPause();
        MessageController.saveMessageList(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        MessageController.saveMessageList(this);

    }
}
