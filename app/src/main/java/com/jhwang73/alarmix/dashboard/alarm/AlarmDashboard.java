package com.jhwang73.alarmix.dashboard.alarm;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.ItemSettings;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.editables.alarm.AlarmSettings;

import java.util.ArrayList;
import java.util.List;

public class AlarmDashboard extends Dashboard<Alarm> {

    public AlarmDashboard(List<Alarm> alarmList) {
        super(alarmList);
    }

    @Override
    public Alarm getDefaultItem() {
        return new Alarm();
    }

    @Override
    public String getItemId() {
        return Alarm.ID;
    }
}
