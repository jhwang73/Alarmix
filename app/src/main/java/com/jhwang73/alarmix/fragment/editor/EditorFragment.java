package com.jhwang73.alarmix.fragment.editor;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editables.ItemSettings;
import com.jhwang73.alarmix.editables.alarm.Alarm;
import com.jhwang73.alarmix.editor.Editor;
import com.jhwang73.alarmix.fragment.SetupFragment;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

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
    protected void initializeModel() {
        this.editor = initializeEditor();
    }

    public void registerDashboard(Dashboard<EditableItem> dashboard) {
        this.dashboard = dashboard;
    }

    protected abstract Editor<EditableItem> initializeEditor();

    @Override
    protected final void initializeListeners(View view) {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemSettings itemSettings = getCurrentSettings();
                EditableItem editableItem = editor.make(itemSettings);
                dashboard.addItem(editableItem);
                List<EditableItem> itemsList = dashboard.getItems();

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("DEFAULT", MODE_PRIVATE);
                Gson gson = new Gson();
                String itemListJson = gson.toJson(itemsList);
                sharedPreferences.edit().putString(dashboard.getItemId(), itemListJson).commit();

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

    public abstract void loadSettings(ItemSettings itemSettings);

    protected abstract ItemSettings getCurrentSettings();

}
