package com.jhwang73.alarmix.editables.alarm;

import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editables.ItemSettings;

import androidx.annotation.NonNull;

public class Alarm implements Editable<Alarm> {

    private int hour;
    private int minute;

    private boolean isOn;

    public Alarm(int hour, int minute) {
        isOn = true;
        this.hour = hour;
        this.minute = minute;
    }

    @NonNull
    @Override
    public String toString() {
        return hour + ":" + minute + " - " + Boolean.toString(isOn);
    }

    @Override
    public ItemSettings<Alarm> getSettings() {
        return null;
    }
}
