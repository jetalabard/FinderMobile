package com.Uca.Finder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.finder.business.Agency;
import com.finder.service.Facade.ServiceFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterPage extends Fragment {

    private String Country;

    private String City;

    private String Name;


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
                if(!Name.isEmpty())
                {

                    Intent intent = new Intent(getActivity(), AgencyDetails.class);
                    intent.putExtra("AgencyName",Name);
                    startActivity(intent);
                }

            }
        });



        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            List<Agency> agencies = new ServiceFacade(this.getActivity()).getAgencies();
            List<String> Country = new ArrayList<>();
            List<String> Cities = new ArrayList<>();
            List<String> Agencies = new ArrayList<>();
            for(Agency a : agencies){
                Country.add(a.getAdress().getCountry());
                Cities.add(a.getAdress().getCity());
                Agencies.add(a.toString());
            }
            Spinner sItemsCity = (Spinner) this.getActivity().findViewById(R.id.spinnerCity);
            Spinner sItemsCountry = (Spinner) this.getActivity().findViewById(R.id.SpinnerCountry);
            final Spinner sItemsName = (Spinner) this.getActivity().findViewById(R.id.spinnerName);

            ArrayAdapter<String> adapterCity = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, Cities);
            adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sItemsCity.setAdapter(adapterCity);

            ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, Country);
            adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sItemsCountry.setAdapter(adapterCountry);

            ArrayAdapter<String> adapterName = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, Agencies);
            adapterName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sItemsName.setAdapter(adapterName);

            sItemsName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id)
                {
                    Name = sItemsName.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Name = "";
                }
            });


        } catch (Exception e) {
            Toast.makeText(getActivity(), e.toString(),Toast.LENGTH_LONG).show();
        }
    }

}
