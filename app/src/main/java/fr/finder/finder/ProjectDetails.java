package fr.finder.finder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.finder.business.Collaborator;

public class ProjectDetails extends AppCompatActivity {

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
