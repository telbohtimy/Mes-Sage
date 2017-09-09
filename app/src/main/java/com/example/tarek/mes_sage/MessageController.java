package com.example.tarek.mes_sage;

import com.example.tarek.mes_sage.Message;


public class MessageController {

    public boolean validInput(String name, String phoneNumber, String messageText, int year, int day, int month, int hour, int minute){
        //Need to add null and empty checks here
        return true;
    }
    public void createMessage(String name, String phoneNumber, String messageText, String frequency, int year, int day, int month, int hour, int minute){
        Message message = new Message(name, phoneNumber, messageText, frequency, true, year, day, month, hour, minute);

    }

}
