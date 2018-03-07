package fr.finder.service.ImplementationService;

import android.app.Activity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.finder.business.Agency;
import fr.finder.business.Collaborator;
import fr.finder.business.Pole;
import fr.finder.business.Project;
import fr.finder.business.User;
import fr.finder.service.AbstractService.IServiceCache;
import fr.finder.service.Cache.FinderCache;
import fr.finder.service.Cache.ManagerSharePreferences;
import fr.finder.service.Cache.SharedPreferencesTags;

/**
 * Created by jerem on 05/03/2018.
 */

public class ServiceCache implements IServiceCache
{
    private ManagerSharePreferences SharedPreferences;

    private Gson gson ;

    public ServiceCache(Activity activity){
        SharedPreferences = new ManagerSharePreferences(activity);
        gson = new Gson();
    }


    @Override
    public User getIdentity() {
        User user =null;
        String JsonList = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_AGENCY);
        if(!JsonList.isEmpty()){
            Type type = new TypeToken<User>() {}.getType();
            user = gson.fromJson(JsonList, type);
        }
        return user;
    }

    @Override
    public void addIdentity(User user)
    {
        SharedPreferences.updateSharedPreferences(gson.toJson(user),SharedPreferencesTags.PREF_USER);
    }

    @Override
    public List<Agency> getAgencies() {
        List<Agency> list = new ArrayList<>();
        String JsonList = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_AGENCY);
        if(!JsonList.isEmpty()){
            Type type = new TypeToken<List<Agency>>() {}.getType();
            list = gson.fromJson(JsonList, type);
        }
        return list;
    }

    @Override
    public void addAgencies(Agency agency) {
        String jsonToAdd = gson.toJson(agency);
        SharedPreferences.addInJSONArray(jsonToAdd,SharedPreferencesTags.PREF_AGENCY);
    }

    @Override
    public void InitialiseAngenciesListIfNotExist(List<Agency> agencies) {
        String jsonToAdd = gson.toJson(agencies);
        SharedPreferences.updateSharedPreferences(jsonToAdd,SharedPreferencesTags.PREF_AGENCY);
    }

    @Override
    public List<Agency> getFavoriteAgencies() {
        List<Agency> list = new ArrayList<>();
        String JsonList = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_FAVORITE_AGENCY);
        if(!JsonList.isEmpty()){
            Type type = new TypeToken<List<Agency>>() {}.getType();
            list = gson.fromJson(JsonList, type);
        }
        return list;

    }

    @Override
    public void addFavoriteAgencies(Agency agency) {
        String jsonToAdd = gson.toJson(agency);
        SharedPreferences.addInJSONArray(jsonToAdd,SharedPreferencesTags.PREF_FAVORITE_AGENCY);
    }

    @Override
    public void InitialiseFavoritesAngenciesListIfNotExist(List<Agency> agencies) {
        String jsonToAdd = gson.toJson(agencies);
        SharedPreferences.updateSharedPreferences(jsonToAdd,SharedPreferencesTags.PREF_FAVORITE_AGENCY);
    }

    @Override
    public List<Pole> getPoles() {
        List<Pole> list = new ArrayList<>();
        String JsonList = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_POLE);
        if(!JsonList.isEmpty()) {
            Type type = new TypeToken<List<Pole>>() {}.getType();
            list = gson.fromJson(JsonList, type);
        }
        return list;
    }

    @Override
    public void addPole(Pole pole) {
        String jsonToAdd = gson.toJson(pole);
        SharedPreferences.addInJSONArray(jsonToAdd,SharedPreferencesTags.PREF_POLE);
    }

    @Override
    public void InitialisePolesListIfNotExist(List<Pole> poles) {
        String jsonToAdd = gson.toJson(poles);
        SharedPreferences.updateSharedPreferences(jsonToAdd,SharedPreferencesTags.PREF_POLE);
    }

    @Override
    public List<Project> getProjects() {
        List<Project> list = new ArrayList<>();
        String JsonList = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_PROJECT);
        if(!JsonList.isEmpty()){
            Type type = new TypeToken<List<Project>>() {}.getType();
            list = gson.fromJson(JsonList, type);
        }
        return list;

    }

    @Override
    public void addProject(Project project) {
        String jsonToAdd = gson.toJson(project);
        SharedPreferences.addInJSONArray(jsonToAdd,SharedPreferencesTags.PREF_PROJECT);
    }

    @Override
    public void InitialiseProjetsListIfNotExist(List<Project> projects) {
        String jsonToAdd = gson.toJson(projects);
        SharedPreferences.updateSharedPreferences(jsonToAdd,SharedPreferencesTags.PREF_PROJECT);
    }

    @Override
    public List<Collaborator> getCollaborators() {
        List<Collaborator> list = new ArrayList<>();
        String JsonList = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_COLLABORATOR);
        if(!JsonList.isEmpty()){
            Type type = new TypeToken<List<Collaborator>>() {}.getType();
            list = gson.fromJson(JsonList, type);
        }
        return list;

    }

    @Override
    public void addCollaborator(Collaborator collaborator) {
        String jsonToAdd = gson.toJson(collaborator);
        SharedPreferences.addInJSONArray(jsonToAdd,SharedPreferencesTags.PREF_COLLABORATOR);
    }

    @Override
    public void InitialiseCollaboratorListIfNotExist(List<Collaborator> collaborators) {
        String jsonToAdd = gson.toJson(collaborators);
        SharedPreferences.updateSharedPreferences(jsonToAdd,SharedPreferencesTags.PREF_COLLABORATOR);
    }

    @Override
    public boolean isInCache(String tag) {
        String JsonList = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_IN_CACHE);
        Type type = new TypeToken<List<FinderCache>>() {}.getType();
        List<FinderCache> caches = gson.fromJson(JsonList, type);
        boolean cacheIsok = false;
        for (FinderCache cache: caches) {
            if(cache.getCachable().equals(tag)){
                if(cache.isDateValid()){
                    cacheIsok = true;
                    break;
                }
            }
        }
        return cacheIsok;
    }

    @Override
    public void addCache(FinderCache cache) {
        String jsonToAdd = gson.toJson(cache);
        SharedPreferences.addInJSONArray(jsonToAdd,SharedPreferencesTags.PREF_IN_CACHE);
    }

    @Override
    public long getDeadlineValidity() {
        String duration = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_DEADLINE_VALIDITY);
        if(!duration.isEmpty()){
            return Long.parseLong(duration);
        }else{
            return SharedPreferencesTags.DEFAULT_DURATION;
        }

    }

    @Override
    public boolean cacheIsActivate() {
        String activateString = SharedPreferences.getDataFromSharedPreferences(SharedPreferencesTags.PREF_CACHE_IS_ACTIVATE);
        boolean isactivate = false;
        if(!activateString.isEmpty()){
            isactivate = Boolean.parseBoolean(activateString);
        }
        return isactivate;
    }

    @Override
    public void desactivateCache() {
        SharedPreferences.updateSharedPreferences(SharedPreferencesTags.PREF_CACHE_IS_ACTIVATE,String.valueOf(false));
    }

    @Override
    public void activateCache() {
        SharedPreferences.updateSharedPreferences(SharedPreferencesTags.PREF_CACHE_IS_ACTIVATE,String.valueOf(true));
    }
}
