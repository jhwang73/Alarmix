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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    protected List<Alarm> loadOrInitializeItemsList() {

        try {
            FileInputStream fis = getContext().openFileInput("DEFAULT");
            ObjectInputStream is = new ObjectInputStream(fis);
            List<Alarm> alarms = (List<Alarm>) is.readObject();
            is.close();
            fis.close();
            return alarms;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Alarm> alarmList = new ArrayList<>();
        return alarmList;
    }

    @Override
    protected Dashboard<Alarm> loadDashboard(List<Alarm> alarms) {
        return new AlarmDashboard(alarms);
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
