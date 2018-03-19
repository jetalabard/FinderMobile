package fr.finder.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.finder.business.AgencyBDD;
import retrofit2.Call;

/**
 * Created by Gilo on 18/03/2018.
 */

public class ModelAgency extends Model {
    public ModelAgency() {
        webservice = getClient();
    }
    public ArrayList<AgencyBDD> gets() {

        Call<ArrayList<AgencyBDD>> call = webservice.gets();

        try {

            return call.execute().body();

        }
        catch (Exception e) {

            Log.d("debug", "DEBUG Exception " + e.toString());
            return null;

        }

    }
}
