package com.jhwang73.alarmix.fragment.dashboard;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.fragment.SetupFragment;
import com.jhwang73.alarmix.fragment.editor.EditorFragment;
import com.jhwang73.alarmix.fragment.editor.EditorFragmentFactory;

import java.util.List;

public abstract class DashboardFragment<EditableItem extends Editable> extends SetupFragment {

    private Dashboard<EditableItem> dashboard;
    private EditorFragmentFactory<EditableItem> editorFragmentFactory;

    private ListView listView;
    private Button addItemButton;

    public Dashboard<EditableItem> getDashboard() {
        return dashboard;
    }

    @Override
    protected void initializeModel() {
        List<EditableItem> editableItemList = loadOrInitializeItemsList();
        this.dashboard = loadDashboard(editableItemList);
        this.editorFragmentFactory = initializeEditorFragmentFactory();
    }

    protected abstract List<EditableItem> loadOrInitializeItemsList();

    protected abstract Dashboard<EditableItem> loadDashboard(List<EditableItem> itemList);
    
    protected abstract EditorFragmentFactory<EditableItem> initializeEditorFragmentFactory();

    @Override
    protected void initializeComponents(View view) {
        listView = view.findViewById(getListViewID());
        addItemButton = view.findViewById(getAddItemButtonID());
    }

    protected abstract int getListViewID();

    protected abstract int getAddItemButtonID();

    @Override
    protected void initializeListeners(View view) {
        initializeListViewListener(view);
        initializeAddItemButtonListener(view);
    }

    private void initializeListViewListener(View view) {
        List<EditableItem> items = getDashboard().getItems();
        int listViewResource = getListViewResource();
        final ArrayAdapter<EditableItem> listViewAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), listViewResource, items);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EditableItem editableItem = listViewAdapter.getItem(position);
                openEditorFragment(editableItem);
            }
        });
    }

    protected abstract int getListViewResource();

    private void initializeAddItemButtonListener(View view) {
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditableItem editableItem = dashboard.getDefaultItem();
                openEditorFragment(editableItem);
            }
        });
    }

    private void openEditorFragment(EditableItem item) {

        EditorFragment<EditableItem> editorFragment = editorFragmentFactory.make(dashboard);
        editorFragment.loadItem(item);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, editorFragment, "openNewEditorFragment")
                .addToBackStack(null)
                .commit();
    }

}
