package com.jhwang73.alarmix.fragment.editor;

import android.view.View;
import android.widget.Button;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editables.ItemSettings;
import com.jhwang73.alarmix.editor.Editor;
import com.jhwang73.alarmix.fragment.SetupFragment;

public abstract class EditorFragment<EditableItem extends Editable> extends SetupFragment {

    private Dashboard<EditableItem> dashboard;
    private Editor<EditableItem> editor;

    private Button okButton;
    private Button cancelButton;

    @Override
    protected final void initializeComponents(View view) {
        okButton = view.findViewById(getOkButtonID());
        cancelButton = view.findViewById(getCancelButtonID());
        initializeAdditionalComponents(view);
    }

    protected abstract int getOkButtonID();

    protected abstract int getCancelButtonID();

    protected abstract void initializeAdditionalComponents(View view);

    @Override
    protected final void initializeListeners(View view) {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemSettings<EditableItem> itemSettings = getCurrentSettings();
                EditableItem editableItem = editor.make(itemSettings);
                dashboard.addItem(editableItem);
                getActivity().onBackPressed();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    public void configureDashboard(Dashboard<EditableItem> dashboard) {
        this.dashboard = dashboard;
    }

    public void configureEditor(Editor<EditableItem> editor) {
        this.editor = editor;
    }

    public abstract void updateView();

    protected abstract ItemSettings<EditableItem> getCurrentSettings();

}
