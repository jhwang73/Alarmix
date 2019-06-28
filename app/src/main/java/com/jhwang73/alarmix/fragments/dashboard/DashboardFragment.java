package com.jhwang73.alarmix.fragments.dashboard;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editor.EditorFragmentFactory;
import com.jhwang73.alarmix.fragments.SetupFragment;
import com.jhwang73.alarmix.fragments.editor.AlarmEditorFragment;
import com.jhwang73.alarmix.fragments.editor.EditorFragment;

public abstract class DashboardFragment<EditableItem extends Editable> extends SetupFragment {

    private Dashboard<EditableItem> dashboard;
    private EditorFragmentFactory<EditableItem> editorFragmentFactory;

    public DashboardFragment(Dashboard<EditableItem> dashboard, EditorFragmentFactory<EditableItem> editorFragmentFactory) {
        this.dashboard = dashboard;
        this.editorFragmentFactory = editorFragmentFactory;
    }

    public Dashboard<EditableItem> getDashboard() {
        return dashboard;
    }

    public void openNewEditorFragment() {
        editorFragmentFactory.make();

        EditorFragment<EditableItem> editorFragment = editorFragmentFactory.make();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, editorFragment, "openNewEditorFragment")
                .addToBackStack(null)
                .commit();
    }
}
