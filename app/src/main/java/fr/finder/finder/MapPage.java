package fr.finder.finder;


import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapPage extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    public MapPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map_page, container, false);
        FloatingActionButton helpSearchMapButton = (FloatingActionButton) v.findViewById(R.id.helpSearchMapButton);
        final RelativeLayout helpSearchMapBox = (RelativeLayout) v.findViewById(R.id.helpSearchMapBox);
        Button buttonSearchMap = (Button)v.findViewById(R.id.searchMapButton);

        helpSearchMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helpSearchMapBox.getVisibility() == View.VISIBLE) {
                    helpSearchMapBox.setVisibility(View.INVISIBLE);
                }
                else {
                    helpSearchMapBox.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonSearchMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send to server the request to have the location of the different companies
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng pos = getLocationFromAddress(getActivity(), "Paris, France");

        MarkerOptions option = new MarkerOptions();
        option.position(pos).title("Paris");
        map.addMarker(option);
        map.moveCamera(CameraUpdateFactory.newLatLng(pos));
        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                //Intent intent = new Intent(getActivity(), PageCompany.class); // A changer ici Ismail !!
                //startActivity(intent);
            }
        });
    }


    public void customAddMarker(LatLng latLng, String title, String snippet) {
        //use when we will custom the marker - optional
    }

    public LatLng getLocationFromAddress(Context context,String strAddress) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng position = null;
        try {
            address = coder.getFromLocationName(strAddress, 2);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();
            position = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return position;
    }

}
