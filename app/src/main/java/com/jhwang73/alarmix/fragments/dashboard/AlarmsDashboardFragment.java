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

    private ListView alarmListView;
    private Button addAlarmButton;

    public AlarmsDashboardFragment() {
        super(new AlarmDashboard(), AlarmEditorFragmentFactory.getInstance());
    }
    
    @Nullable
    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alarm_manager, container, false);
    }

    @Override
    protected void initializeComponents(View view) {
        alarmListView = view.findViewById(R.id.alarmList);
        addAlarmButton = view.findViewById(R.id.addAlarmButton);
    }

    @Override
    protected void initializeListeners(View view) {
        List<Alarm> alarms = getDashboard().getItems();
        final ArrayAdapter<Alarm> alarmListAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, alarms);
        alarmListView.setAdapter(alarmListAdapter);
        alarmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        addAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewEditorFragment();
            }
        });
    }
}
