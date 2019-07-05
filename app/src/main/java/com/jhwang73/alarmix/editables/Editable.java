package com.jhwang73.alarmix.editables;

public interface Editable<EditableItem extends Editable> {

    public abstract ItemSettings<EditableItem> getSettings();

}
