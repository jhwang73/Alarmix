package com.jhwang73.alarmix.fragment.dashboard;

import android.content.SharedPreferences;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.dashboard.alarm.AlarmDashboard;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.fragment.editor.EditorFragmentFactory;
import com.jhwang73.alarmix.fragment.editor.alarm.AlarmEditorFragmentFactory;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class AlarmsDashboardFragment extends DashboardFragment<Alarm> {

    @Override
    protected int getFragmentID() {
        return R.layout.fragment_alarm_manager;
    }

    @Override
    protected Dashboard<Alarm> loadDashboard() {
        List<Alarm> alarmList = loadOrInitializeAlarmList();
        return new AlarmDashboard(alarmList);
    }

    private List<Alarm> loadOrInitializeAlarmList() {
        String ALARM_JSON_NOT_FOUND = "ALARM_JSON_NOT_FOUND";
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Alarm", MODE_PRIVATE);
        String alarmListJson = sharedPreferences.getString("AlarmList.json", ALARM_JSON_NOT_FOUND);
        if (alarmListJson == ALARM_JSON_NOT_FOUND) {
            List<Alarm> alarmList = new ArrayList<>();
//            sharedPreferences.edit().putString();
        } else {
            Gson gson = Gson();
        }


        // What this should do is
        // if not in sharedPref, make a empty list in sharedPref
        // return whats in shraedPref
        return new ArrayList<>();
    }

    @Override
    protected EditorFragmentFactory<Alarm> initializeEditorFragmentFactory() {
        return AlarmEditorFragmentFactory.getInstance();
    }

    @Override
    protected int getListViewID() {
        return R.id.alarmList;
    }

    @Override
    protected int getAddItemButtonID() {
        return R.id.newAlarmButton;
    }

    @Override
    protected int getListViewResource() {
        return android.R.layout.simple_spinner_item;
    }

}
