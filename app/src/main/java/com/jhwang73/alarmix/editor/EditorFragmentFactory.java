package com.jhwang73.alarmix.editor;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.fragments.editor.EditorFragment;

public abstract class EditorFragmentFactory<EditableItem extends Editable> {

    public EditorFragment<EditableItem> make(Dashboard<EditableItem> dashboard) {
        EditorFragment<EditableItem> editorFragment = makeEditorFragment();
        editorFragment.setDashboard(dashboard);
        return editorFragment;
    }

    protected abstract EditorFragment<EditableItem> makeEditorFragment();

}
