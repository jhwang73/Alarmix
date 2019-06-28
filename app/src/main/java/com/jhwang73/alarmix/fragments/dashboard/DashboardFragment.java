package com.jhwang73.alarmix.fragments.dashboard;

import com.jhwang73.alarmix.dashboard.Dashboard;
import com.jhwang73.alarmix.editables.Editable;
import com.jhwang73.alarmix.fragments.SetupFragment;

public abstract class DashboardFragment<EditableItem extends Editable> extends SetupFragment {

    private Dashboard<EditableItem> dashboard;

    public DashboardFragment(Dashboard<EditableItem> dashboard) {
        this.dashboard = dashboard;
    }

    public Dashboard<EditableItem> getDashboard() {
        return dashboard;
    }

}
