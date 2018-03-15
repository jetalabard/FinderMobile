package fr.finder.finder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgencyMapList extends AppCompatActivity {

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
