package com.jhwang73.alarmix.fragment.dashboard;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editables.ItemSettings;
import com.jhwang73.alarmix.editor.Editor;
import com.jhwang73.alarmix.fragment.editor.EditorFragmentFactory;
import com.jhwang73.alarmix.fragment.SetupFragment;
import com.jhwang73.alarmix.fragment.editor.EditorFragment;

import java.util.List;

public abstract class DashboardFragment<EditableItem extends Editable> extends SetupFragment {

    private Dashboard<EditableItem> dashboard;
    private EditorFragmentFactory<EditableItem> editorFragmentFactory;

    private ListView listView;
    private Button addItemButton;

    public DashboardFragment(Dashboard<EditableItem> dashboard, EditorFragmentFactory<EditableItem> editorFragmentFactory) {
        this.dashboard = dashboard;
        this.editorFragmentFactory = editorFragmentFactory;
    }

    public Dashboard<EditableItem> getDashboard() {
        return dashboard;
    }

    @Override
    protected void initializeComponents(View view) {
        listView = view.findViewById(getListViewID());
        addItemButton = view.findViewById(getAddItemButtonID());
    }

    protected abstract int getListViewID();

    protected abstract int getAddItemButtonID();

    @Override
    protected void initializeListeners(View view) {
        List<EditableItem> items = getDashboard().getItems();

        int listViewResource = getListViewResource();

        final ArrayAdapter<EditableItem> listViewAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), listViewResource, items);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EditableItem editableItem = listViewAdapter.getItem(position);
                ItemSettings<EditableItem> itemSettings = editableItem.getSettings();

                openEditorFragment(itemSettings);
            }
        });

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO

                EditableItem editableItem = null;
                ItemSettings<EditableItem> defaultSettings = null;

                openEditorFragment(defaultSettings);
            }
        });
    }

    protected abstract int getListViewResource();

    private void openEditorFragment(ItemSettings<EditableItem> itemSettings) {

        EditorFragment<EditableItem> editorFragment = editorFragmentFactory.make(dashboard, getEditor());

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, editorFragment, "openNewEditorFragment")
                .addToBackStack(null)
                .commit();
    }

    protected abstract Editor<EditableItem> getEditor();

}
