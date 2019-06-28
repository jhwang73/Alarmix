package com.jhwang73.alarmix.editor;

import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.fragments.editor.EditorFragment;

public abstract class EditorFragmentFactory<EditableItem extends Editable> {

    public abstract EditorFragment<EditableItem> make();

}
