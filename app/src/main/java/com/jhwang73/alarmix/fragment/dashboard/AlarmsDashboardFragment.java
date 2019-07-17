package com.jhwang73.alarmix.fragment.dashboard;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.dashboard.alarm.AlarmDashboard;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.fragment.editor.EditorFragmentFactory;
import com.jhwang73.alarmix.fragment.editor.alarm.AlarmEditorFragmentFactory;

import java.lang.reflect.Type;
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
        // Need a check on this and/or create in Main
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("DEFAULT", MODE_PRIVATE);
        String alarmListJson = sharedPreferences.getString("ALARM_ID", ALARM_JSON_NOT_FOUND);

        System.out.println(alarmListJson);

        Gson gson = new Gson();

        if (alarmListJson.equals(ALARM_JSON_NOT_FOUND)) {
            List<Alarm> alarmList = new ArrayList<>();
            String alarmListJSon = gson.toJson(alarmList);
            return alarmList;

        } else {
            Type alarmListType = new TypeToken<List<Alarm>>(){}.getType();
            List<Alarm> alarmList = gson.fromJson(alarmListJson, alarmListType);
            return alarmList;
        }
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
