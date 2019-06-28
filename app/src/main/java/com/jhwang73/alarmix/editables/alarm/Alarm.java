package com.jhwang73.alarmix.editables.alarm;

import com.jhwang73.alarmix.editables.Editable;

import androidx.annotation.NonNull;

public class Alarm implements Editable {

    private boolean isOn;

    public Alarm() {
        isOn = true;
    }

    @NonNull
    @Override
    public String toString() {
        return Boolean.toString(isOn);
    }
}
