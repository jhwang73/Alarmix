package com.jhwang73.alarmix.dashboard;

import com.jhwang73.alarmix.editables.Editable;

import java.util.List;

public abstract class Dashboard<EditableItem extends Editable> {

    List<EditableItem> items;

    public Dashboard(List<EditableItem> items) {
        this.items = items;
    }

    public List<EditableItem> getItems() {
        return items;
    }

    public void addItem(EditableItem item) {
        items.add(item);
    }

}
