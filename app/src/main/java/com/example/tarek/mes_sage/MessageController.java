package com.example.tarek.mes_sage;


import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MessageController {

    private ArrayList<Message> messageList = new ArrayList<Message>();
    Gson gson = new Gson();
    String filename = "messageList.txt";

    public boolean validInput(String name, String phoneNumber, String messageText, int year, int day, int month, int hour, int minute){
        //Need to add null and empty checks here
        return true;
    }
    public void createMessage(Context context, String name, String phoneNumber, String messageText, String frequency, int year, int day, int month, int hour, int minute){
        Message message = new Message(name, phoneNumber, messageText, frequency, true, year, day, month, hour, minute);
        messageList.add(message);
        saveMessageList(context);
    }
    public void saveMessageList(Context context){
        String save = gson.toJson(this.messageList);
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(save.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMessageList(Context context){
        try {
            FileInputStream fis = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            String load = sb.toString();
            messageList = gson.fromJson(load, ArrayList.class);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
