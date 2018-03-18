package com.Uca.Finder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FavouriteAgencies extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_agencies);
        Button agencyDetailButton = (Button)findViewById(R.id.agencyDetailButton2);
        Button agencyDetailButton1 = (Button)findViewById(R.id.agencyDetailButton3);
        agencyDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavouriteAgencies.this, AgencyDetails.class);
                startActivity(intent);
            }
        });
        agencyDetailButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavouriteAgencies.this, AgencyDetails.class);
                startActivity(intent);
            }
        });
    }
}
