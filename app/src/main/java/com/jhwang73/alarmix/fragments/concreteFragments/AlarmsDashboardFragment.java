package com.jhwang73.alarmix.fragments.concreteFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhwang73.alarmix.R;
import com.jhwang73.alarmix.fragments.DashboardFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AlarmsDashboardFragment extends DashboardFragment {
    
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
