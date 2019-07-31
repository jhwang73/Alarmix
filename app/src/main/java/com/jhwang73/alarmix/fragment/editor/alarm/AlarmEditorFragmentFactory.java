package com.jhwang73.alarmix.fragment.editor.alarm;

import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.fragment.editor.EditorFragment;
import com.jhwang73.alarmix.fragment.editor.EditorFragmentFactory;

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
