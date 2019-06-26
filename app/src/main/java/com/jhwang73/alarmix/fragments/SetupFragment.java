package com.jhwang73.alarmix.fragments;

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
        View view = inflateView(inflater, container, savedInstanceState);
        initializeView(view);
        return view;
    }

    @Nullable
    protected abstract View inflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    private void initializeView(View view) {
        initializeComponents(view);
        initializeListeners(view);
    }

    protected abstract void initializeComponents(View view);

    protected abstract void initializeListeners(View view);

}
