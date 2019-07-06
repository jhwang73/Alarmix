package com.jhwang73.alarmix.editor.alarm;

import com.jhwang73.alarmix.editables.ItemSettings;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.editables.alarm.AlarmSettings;
import com.jhwang73.alarmix.editor.Editor;

public class AlarmEditor extends Editor<Alarm> {

    @Override
    public Alarm make(ItemSettings settings) {
        return new Alarm(1, 1);
    }
}
