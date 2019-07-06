package com.jhwang73.alarmix.dashboard;

import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.editables.ItemSettings;

import java.util.Comparator;
import java.util.List;

public abstract class Dashboard<EditableItem extends Editable> {

    private List<EditableItem> items;

    public Dashboard(List<EditableItem> items) {
        this.items = items;
    }

    public List<EditableItem> getItems() {
        return items;
    }

    public void addItem(EditableItem item) {
        // TEST
//        if item already in items, update. Otherwise, add as new
        items.add(item);
    }

    public void sortList() {
        // TEST
    }

    public abstract ItemSettings getDefaultSettings();

}
