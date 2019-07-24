package com.jhwang73.alarmix.editables;

import java.io.Serializable;

// Maybe this? I guess probably not necessary
//public abstract class ItemSettings<EditableItem extends Editable<EditableItem>> {
public abstract class ItemSettings<EditableItem extends Editable> implements Serializable {

    public abstract EditableItem makeItem();

}
