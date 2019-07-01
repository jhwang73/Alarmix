package com.jhwang73.alarmix.fragments.editor;

import android.view.View;
import android.widget.Button;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.fragments.SetupFragment;

public abstract class EditorFragment<EditableItem extends Editable> extends SetupFragment {

    private Dashboard<EditableItem> dashboard;

    private Button okButton;
    private Button cancelButton;

    public void setDashboard(Dashboard<EditableItem> dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    protected final void initializeComponents(View view) {
        okButton = view.findViewById(getOkButtonID());
        cancelButton = view.findViewById(getCancelButtonID());
    }

    protected abstract int getOkButtonID();

    protected abstract int getCancelButtonID();

    @Override
    protected final void initializeListeners(View view) {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dashboard.addItem(makeNewItemWithCurrentSettings());
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

    protected abstract EditableItem makeNewItemWithCurrentSettings();

}
