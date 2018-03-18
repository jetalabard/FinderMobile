package com.Uca.Finder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoleDetails extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pole_details);
        Button projectButton = (Button)findViewById(R.id.projectButton);
        projectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PoleDetails.this, ProjectDetails.class);
                startActivity(intent);
            }
        });
    }
}
