package com.example.tarek.mes_sage;

public class Message {

    private String name;
    private String phoneNumber;
    private String messageText;
    private String frequency;
    private boolean send;
    private int year;
    private int day;
    private int month;
    private int time;

    //Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public boolean isSend() { return send; }
    public void setSend(boolean send) { this.send = send; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }
    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }
    public int getTime() { return time; }
    public void setTime(int time) { this.time = time; }

}
