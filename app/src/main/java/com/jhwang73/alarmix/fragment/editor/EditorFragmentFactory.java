package com.jhwang73.alarmix.fragment.editor;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editor.Editor;

public abstract class EditorFragmentFactory<EditableItem extends Editable> {

    public EditorFragment<EditableItem> make(Dashboard<EditableItem> dashboard, Editor<EditableItem> editor) {
        EditorFragment<EditableItem> editorFragment = makeEditorFragment();
        editorFragment.configureDashboard(dashboard);
        editorFragment.configureEditor(editor);
        editorFragment.updateView();
        return editorFragment;
    }

    protected abstract EditorFragment<EditableItem> makeEditorFragment();

}
