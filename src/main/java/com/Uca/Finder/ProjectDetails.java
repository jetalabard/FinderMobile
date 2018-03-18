package com.Uca.Finder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProjectDetails extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);
        Button teamPlan = (Button)findViewById(R.id.teamPlan1);
        Button detailCollab = (Button)findViewById(R.id.detailCollab);
        teamPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 // plan team -> Ismail
            }
        });
        detailCollab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectDetails.this, CollaboratorDetails.class);
                startActivity(intent);
            }
        });
    }
}
