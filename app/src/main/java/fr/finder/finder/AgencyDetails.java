package fr.finder.finder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AgencyDetails extends AppCompatActivity {

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
