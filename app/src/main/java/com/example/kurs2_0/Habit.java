package com.example.kurs2_0;

public class Habit {
    private String Name;
    private String NotificationText;
    private long NotificationTime;
    private int Day;

    public Habit(String name, String notificationText, long notificationTime, int day) {
        Name = name;
        NotificationText = notificationText;
        NotificationTime = notificationTime;
        Day = day;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNotificationText() {
        return NotificationText;
    }

    public void setNotificationText(String notificationText) {
        NotificationText = notificationText;
    }

    public long getNotificationTime() {
        return NotificationTime;
    }

    public void setNotificationTime(long notificationTime) {
        NotificationTime = notificationTime;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }
}
