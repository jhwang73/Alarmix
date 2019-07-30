package com.jhwang73.alarmix.editables.alarm;

import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editables.ItemSettings;

import androidx.annotation.NonNull;

public class Alarm implements Editable {

    private static final int DEFAULT_HOUR = 7;
    private static final int DEFAULT_MINUTE = 0;

    public static final String ID = "ALARM_ID";

    private AlarmSettings alarmSettings;

    private boolean isOn;

    public Alarm() {
        isOn = true;
        alarmSettings = new AlarmSettings(DEFAULT_HOUR, DEFAULT_MINUTE);
    }

    public int getHour() { return alarmSettings.getHour(); }

    public int getMinute() { return alarmSettings.getMinute(); }

    public void setHour(int hour) {
        alarmSettings.setHour(hour);
    }

    public void setMinute(int minute) {
        alarmSettings.setMinute(minute);
    }

    @NonNull
    @Override
    public String toString() {
        return alarmSettings.toString() + " - " + Boolean.toString(isOn);
    }

}
