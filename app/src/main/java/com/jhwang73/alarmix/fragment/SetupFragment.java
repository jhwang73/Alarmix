package com.jhwang73.alarmix.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class SetupFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int fragmentID = getFragmentID();
        View view = inflater.inflate(fragmentID, container, false);
        initializeModel();
        initializeView(view);
        return view;
    }

    protected abstract int getFragmentID();

    protected abstract void initializeModel();

    private void initializeView(View view) {
        initializeComponents(view);
        initializeListeners(view);
    }

    protected abstract void initializeComponents(View view);

    protected abstract void initializeListeners(View view);

}
