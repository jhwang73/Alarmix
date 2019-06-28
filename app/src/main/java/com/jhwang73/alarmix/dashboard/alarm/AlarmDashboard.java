package com.jhwang73.alarmix.dashboard.alarm;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.alarm.Alarm;

import java.util.ArrayList;

public class AlarmDashboard extends Dashboard<Alarm> {

    public AlarmDashboard() {
        super(new ArrayList<Alarm>());
    }

}
