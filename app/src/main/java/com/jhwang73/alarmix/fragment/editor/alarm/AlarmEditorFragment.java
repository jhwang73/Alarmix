package com.jhwang73.alarmix.fragment.editor.alarm;

import android.os.Build;
import android.view.View;
import android.widget.TimePicker;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.dashboard.alarm.AlarmDashboard;
import com.jhwang73.alarmix.editables.ItemSettings;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.editables.alarm.AlarmSettings;
import com.jhwang73.alarmix.fragment.editor.EditorFragment;

public class AlarmEditorFragment extends EditorFragment<Alarm> {

    private TimePicker timePicker;

    @Override
    protected int getFragmentID() {
        return R.layout.fragment_alarm_editor;
    }

    @Override
    protected int getOkButtonID() {
        return R.id.setAlarm;
    }

    @Override
    protected int getCancelButtonID() {
        return R.id.cancelAlarm;
    }

    @Override
    protected void initializeAdditionalComponents(View view) {
        timePicker = view.findViewById(R.id.timePicker);
        visualizeItem();
    }

    @Override
    protected void updateItemSettings() {
        editableItem.setHour(safeGetHour());
        editableItem.setMinute(safeGetMinute());
    }

    private void visualizeItem() {
        safeSetHour(editableItem.getHour());
        safeSetMinute(editableItem.getMinute());
    }

    private void safeSetHour(int hour) {
        if (Build.VERSION.SDK_INT >= 23)
            timePicker.setHour(hour);
        else
            timePicker.setCurrentHour(hour);
    }

    private void safeSetMinute(int minute) {
        if (Build.VERSION.SDK_INT >= 23)
            timePicker.setMinute(minute);
        else
            timePicker.setCurrentMinute(minute);
    }

    private int safeGetHour() {
        if (Build.VERSION.SDK_INT >= 23)
            return timePicker.getHour();
        else
            return timePicker.getCurrentHour();
    }

    private int safeGetMinute() {
        if (Build.VERSION.SDK_INT >= 23)
            return timePicker.getMinute();
        else
            return timePicker.getCurrentMinute();
    }
}
