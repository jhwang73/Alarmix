package com.jhwang73.alarmix.fragments;

import android.app.AlarmManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jhwang73.alarmix.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AlarmFragment extends SetupFragment {
    
    @Nullable
    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alarm_manager, container, false);
    }

    @Override
    protected void initializeComponents(View view) {

    }

    @Override
    protected void initializeListeners(View view) {

    }
}
