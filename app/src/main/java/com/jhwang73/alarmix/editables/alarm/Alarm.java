package com.jhwang73.alarmix.editables.alarm;

import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editables.ItemSettings;

import androidx.annotation.NonNull;

public class Alarm implements Editable<Alarm> {

    private AlarmSettings alarmSettings;

    private boolean isOn;

    public Alarm(int hour, int minute) {
        isOn = true;
        alarmSettings = new AlarmSettings(hour, minute);
    }

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

    @Override
    public ItemSettings<Alarm> getItemSettings() {
        return alarmSettings;
    }
}
