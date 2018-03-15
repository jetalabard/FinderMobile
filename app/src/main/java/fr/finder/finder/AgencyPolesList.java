package fr.finder.finder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgencyPolesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency_poles_list);
        Button agencyPoleButton = (Button)findViewById(R.id.agencyPoleButton);
        agencyPoleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgencyPolesList.this, PoleDetails.class);
                startActivity(intent);
            }
        });
    }
}
