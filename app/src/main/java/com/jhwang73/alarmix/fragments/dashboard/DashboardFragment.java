package com.jhwang73.alarmix.fragments.dashboard;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editor.EditorFragmentFactory;
import com.jhwang73.alarmix.fragments.SetupFragment;
import com.jhwang73.alarmix.fragments.editor.EditorFragment;

import java.util.List;

public abstract class DashboardFragment<EditableItem extends Editable> extends SetupFragment {

    /**
     * The backend components common to all DashboardFragments
     */
    private Dashboard<EditableItem> dashboard;
    private EditorFragmentFactory<EditableItem> editorFragmentFactory;

    /**
     * The UI components common to all DashboardFragments
     */
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

        final ArrayAdapter<EditableItem> alarmListAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), listViewResource, items);
        listView.setAdapter(alarmListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewEditorFragment();
            }
        });
    }

    protected abstract int getListViewResource();

    private void openNewEditorFragment() {

        EditorFragment<EditableItem> editorFragment = editorFragmentFactory.make(dashboard);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, editorFragment, "openNewEditorFragment")
                .addToBackStack(null)
                .commit();
    }

}
