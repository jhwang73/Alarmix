package com.jhwang73.alarmix.editor;

import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editables.ItemSettings;

public abstract class Editor<EditableItem extends Editable> {

    public abstract EditableItem make(ItemSettings settings);

    // Either constructor takes in an EditITem
//    or some method does
    // At the very least the settings

}
