package com.Uca.Finder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AgencyDetails extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency_details);
        Button agencyMap = (Button)findViewById(R.id.accessAgencyPlanButton);
        Button agencyPoleList = (Button)findViewById(R.id.activityPoleButton);
        agencyMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgencyDetails.this, AgencyMapList.class);
                startActivity(intent);
            }
        });
        agencyPoleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgencyDetails.this, AgencyPolesList.class);
                startActivity(intent);
            }
        });

    }
}
