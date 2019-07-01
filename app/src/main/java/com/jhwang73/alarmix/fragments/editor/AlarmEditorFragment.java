package com.jhwang73.alarmix.fragments.editor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.alarm.Alarm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AlarmEditorFragment extends EditorFragment<Alarm> {

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
    protected Alarm makeNewItemWithCurrentSettings() {
        return new Alarm();
    }
}
