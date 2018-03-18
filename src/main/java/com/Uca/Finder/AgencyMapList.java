package com.Uca.Finder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AgencyMapList extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency_map_list);
        Button agencyPlanButton = (Button)findViewById(R.id.agencyPlanButton1);
        agencyPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to view of plan -> Ismail
            }
        });
    }

}
