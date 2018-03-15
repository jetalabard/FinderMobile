package fr.finder.finder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CollaboratorDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collaborator_details);
        Button teamPlan = (Button)findViewById(R.id.teamPlan);
        teamPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Plan ->  Ismail
            }
        });
    }
}
