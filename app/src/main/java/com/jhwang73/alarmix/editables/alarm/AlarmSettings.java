package com.jhwang73.alarmix.editables.alarm;

import com.jhwang73.alarmix.editables.ItemSettings;

import androidx.annotation.NonNull;

public class AlarmSettings extends ItemSettings<Alarm> {

    private int hour;
    private int minute;

    public AlarmSettings(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @NonNull
    @Override
    public String toString() {
        return this.hour + ":" + this.minute;
    }

}
