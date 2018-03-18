package com.Uca.Finder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterPage extends Fragment {

    public FilterPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_filter_page, container, false);
        Button favouriteButton = (Button)v.findViewById(R.id.favouriteButton);
        Button agencyDetailButton = (Button)v.findViewById(R.id.agencyDetailButton4);
        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FavouriteAgencies.class);
                startActivity(intent);
            }
        });
        agencyDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AgencyDetails.class);
                startActivity(intent);
            }
        });

        return v;
    }

}
