package com.jhwang73.alarmix.fragment.editor;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;

public abstract class EditorFragmentFactory<EditableItem extends Editable> {

    public EditorFragment<EditableItem> make(Dashboard<EditableItem> dashboard, EditableItem editableItem) {
        EditorFragment<EditableItem> editorFragment = makeEditorFragment();
        editorFragment.configureDashboard(dashboard);
        editorFragment.configureEditableItem(editableItem);
        editorFragment.updateView();
        return editorFragment;
    }

    protected abstract EditorFragment<EditableItem> makeEditorFragment();

}
