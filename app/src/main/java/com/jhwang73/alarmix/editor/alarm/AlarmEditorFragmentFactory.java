package com.jhwang73.alarmix.editor.alarm;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.editor.EditorFragmentFactory;
import com.jhwang73.alarmix.fragments.editor.AlarmEditorFragment;
import com.jhwang73.alarmix.fragments.editor.EditorFragment;

public class AlarmEditorFragmentFactory extends EditorFragmentFactory<Alarm> {

    private static AlarmEditorFragmentFactory alarmEditorFragmentFactory;

    public static synchronized AlarmEditorFragmentFactory getInstance() {
        if (alarmEditorFragmentFactory == null)
            alarmEditorFragmentFactory = new AlarmEditorFragmentFactory();
        return alarmEditorFragmentFactory;
    }

    public EditorFragment<Alarm> makeEditorFragment() {
        return new AlarmEditorFragment();
    }
}
