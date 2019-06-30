package com.jhwang73.alarmix.fragments.editor;

import android.view.View;
import android.widget.Button;

import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.fragments.SetupFragment;

public abstract class EditorFragment<EditableItem extends Editable> extends SetupFragment {

    Button okButton;
    Button cancelButton;

    @Override
    protected void initializeComponents(View view) {
        okButton = view.findViewById(getOkButtonID());
        cancelButton = view.findViewById(getCancelButtonID());
    }

    protected abstract int getOkButtonID();

    protected abstract int getCancelButtonID();

    @Override
    protected void initializeListeners(View view) {

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

}
