package fr.finder.service.Cache;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by jerem on 04/03/2018.
 */

public  class ManagerSharePreferences {

    private Activity Activity;

    private static final String PREFS_TAG = "Finder_Shared_Preferences";

    public ManagerSharePreferences(Activity activity){
        this.Activity = activity;
    }


    /**
     * récupère la liste des objets demandés en cache sous forme de JSON
     * @param tag
     * @return
     */
    public String getDataFromSharedPreferences(String tag){
        SharedPreferences sharedPref = this.Activity.getApplicationContext().getSharedPreferences(PREFS_TAG, Context.MODE_PRIVATE);
        return sharedPref.getString(tag, "");
    }


    /**
     * modifie un simple element en cache
     * @param tag
     * @param newValue
     */
    public void updateSharedPreferences(String tag, String newValue){
        SharedPreferences sharedPref = this.Activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(tag, newValue);
        editor.commit();
    }


    /**
     * ajoute un nouvel élément à la liste JSON contenu en cache
     * @param jsonToAdd
     * @param tag
     */
    public void addInJSONArray(String jsonToAdd, String tag){

        SharedPreferences sharedPref = this.Activity.getApplicationContext().getSharedPreferences(PREFS_TAG, Context.MODE_PRIVATE);
        String jsonSaved = sharedPref.getString(tag, "");
        JSONArray jsonArrayAgencies= new JSONArray();
        try {
            if(jsonSaved.length()!=0)
            {
                jsonArrayAgencies = new JSONArray(jsonSaved);
            }
            jsonArrayAgencies.put(new JSONObject(jsonToAdd));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(tag, jsonArrayAgencies.toString());
        editor.commit();
    }



}
