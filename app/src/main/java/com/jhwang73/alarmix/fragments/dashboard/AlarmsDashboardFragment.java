package com.jhwang73.alarmix.fragments.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.dashboard.alarm.AlarmDashboard;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.editor.alarm.AlarmEditorFragmentFactory;
import com.jhwang73.alarmix.fragments.editor.AlarmEditorFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AlarmsDashboardFragment extends DashboardFragment<Alarm> {

    public AlarmsDashboardFragment() {
        super(new AlarmDashboard(), AlarmEditorFragmentFactory.getInstance());
    }

    @Override
    protected int getFragmentID() {
        return R.layout.fragment_alarm_manager;
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
