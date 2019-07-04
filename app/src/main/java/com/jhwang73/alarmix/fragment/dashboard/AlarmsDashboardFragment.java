package com.jhwang73.alarmix.fragment.dashboard;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.alarm.AlarmDashboard;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.editor.Editor;
import com.jhwang73.alarmix.editor.alarm.AlarmEditor;
import com.jhwang73.alarmix.fragment.editor.alarm.AlarmEditorFragmentFactory;

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

    @Override
    protected Editor<Alarm> getEditor() {
        // TODO singleton, then configure the item onto it
        return new AlarmEditor();
    }

}
