package com.jhwang73.alarmix.fragment.editor;

import android.view.View;
import android.widget.Button;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.fragment.SetupFragment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public abstract class EditorFragment<EditableItem extends Editable> extends SetupFragment {

    private Dashboard<EditableItem> dashboard;
    protected EditableItem editableItem;

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
    protected void initializeModel() {
    }

    public void registerDashboard(Dashboard<EditableItem> dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    protected final void initializeListeners(View view) {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateItemSettings();
                dashboard.addItemIfNotPresent(editableItem);

                List<EditableItem> itemsList = dashboard.getItems();

                // Can prob move this into an adapter initliazed inside EditorFragmentFactory
                // which is done by passing editorFragmentFactory.make(this) inside DashboardFragment
                try {
                    FileOutputStream fos = getContext().openFileOutput("DEFAULT", getContext().MODE_PRIVATE);
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(itemsList);
                    os.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

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

    public void loadItem(EditableItem editableItem) {
        this.editableItem = editableItem;
    }

    protected abstract void updateItemSettings();

}
