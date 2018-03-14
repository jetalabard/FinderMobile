package fr.finder.finder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


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
        LatLng pos = new LatLng(11.111,-11.111);
        MarkerOptions option = new MarkerOptions();
        option.position(pos).title("salut");
        map.addMarker(option);
        map.moveCamera(CameraUpdateFactory.newLatLng(pos));
    }
}
