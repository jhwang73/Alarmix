package com.jhwang73.alarmix.dashboard.alarm;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.ItemSettings;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.editables.alarm.AlarmSettings;

import java.util.ArrayList;

public class AlarmDashboard extends Dashboard<Alarm> {

    public AlarmDashboard() {
        super(new ArrayList<Alarm>());
    }

    @Override
    public ItemSettings getDefaultSettings() {
        return AlarmSettings.DEFAULT_SETTINGS;
    }
}
