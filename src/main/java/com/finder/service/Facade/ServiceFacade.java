package com.finder.service.Facade;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import com.Uca.Finder.Dialog;
import com.finder.business.Agency;
import com.finder.business.Collaborator;
import com.finder.business.Pole;
import com.finder.business.Project;
import com.finder.controller.TestConnection;
import com.finder.service.Cache.IServiceCache;
import com.finder.service.Cache.ServiceCache;
import com.finder.service.Cache.SharedPreferencesTags;
import com.finder.service.WebService.ChoiceDataTestOrRealData;
import com.finder.service.WebService.AccessDataWebService;
import com.finder.service.WebService.IAccessData;
import com.test.AccessDataTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerem on 04/03/2018.
 */

public class ServiceFacade implements IFacadeService {

    private IServiceCache cache;

    private boolean CacheIsActivate;

    private IAccessData service;

    /**
     * parent activity
     */
    private Activity activity;

    private AlertDialog alertDialog;


    /**
     *
     * @param activity
     */
    public ServiceFacade(Activity activity)
    {
        this.activity = activity;
        cache = new ServiceCache(activity);
        CacheIsActivate = cache.cacheIsActivate();
        if (ChoiceDataTestOrRealData.DataTestOrRealData) {
            service = new AccessDataWebService();
        } else {
            service = new AccessDataTest();
        }
    }

    private Boolean hasInternet()
    {
        Log.e("ServiceFacade","hasInertnet");
        if(new TestConnection(activity).isNetworkAvailable()){
            return true;
        }else{
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showDialogConnection();
                }
            });
            return false;
        }
    }

    private void showMessageIfNoConnectionElseLoadApplication() {
        TestConnection test = new TestConnection(activity);

        if(!test.isNetworkAvailable())
        {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showDialogConnection();
                }
            });
        }else{
            Intent intent = activity.getIntent();
            activity.finish();
            activity.startActivity(intent);
        }
    }

    private void showDialogConnection() {
        Dialog d = new Dialog(activity, "Problème Connexion", "Connectez vous et rééssayez.", false);
        alertDialog  = d.setPositiveButton("Rééssayer", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showMessageIfNoConnectionElseLoadApplication();
            }
        }).setNegativeButton("Annuler", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                activity.finish();
            }
        }).create();
        alertDialog.show();
    }

    @Override
    public List<Agency> getAgencies() {
        Log.e("ServiceFacade","getAgencies");
        List<Agency> list = null;
        if (CacheIsActivate)
        {
            Log.e("ServiceFacade","getAgencies Cache");
            boolean isInCache = cache.isInCache(SharedPreferencesTags.PREF_AGENCY);
            if (isInCache)
            {
                Log.e("ServiceFacade","getAgencies isIncache");
                list = cache.getAgencies();
            }
            else
            {
                if(hasInternet()) {
                    list = service.getAgencies();
                    cache.InitialiseAngenciesListIfNotExist(list);
                }
            }
        }
        else
        {
            if(hasInternet()){
                list = service.getAgencies();
            }
        }
        return list;
    }


    @Override
    public List<String> getCountries() {
        List<Agency> agencies = this.getAgencies();
        List<String> Countries = new ArrayList<>();
        for (Agency agency : agencies) {
            Countries.add(agency.getAdress().getCountry());
        }
        return Countries;

    }

    @Override
    public List<String> getCities(String country) {
        List<String> Cities = new ArrayList<>();
        List<Agency> agencies = this.getAgencies();
        for (Agency agency : agencies) {
            if (agency.getAdress().getCountry().equals(country)) {
                Cities.add(agency.getAdress().getCity());
            }
        }
        return Cities;

    }

    @Override
    public List<Agency> getAgencies(String country) {
        List<Agency> list = new ArrayList<>();
        List<Agency> agencies = this.getAgencies();
        for (Agency agency : agencies) {
            if (agency.getAdress().getCountry().equals(country)) {
                list.add(agency);
            }
        }
        return list;
    }

    @Override
    public Agency getAgencyByName(String name)
    {
        Agency agency = null;
        List<Agency> agencies = this.getAgencies();
        for (Agency a : agencies) {
            if (a.getName().equals(name)) {
                agency = a;
            }
        }
        return agency;
    }

    @Override
    public List<Agency> getAgencies(String country, String City) {
        List<Agency> list = new ArrayList<>();
        List<Agency> agencies = this.getAgencies();
        for (Agency agency : agencies) {
            if (agency.getAdress().getCountry().equals(country)) {
                if (agency.getAdress().getCity().equals(City)) {
                    list.add(agency);
                }
            }
        }
        return list;
    }

    @Override
    public List<Pole> getPoles() {
        List<Pole> list = null;
        if (CacheIsActivate) {
            boolean isInCache = cache.isInCache(SharedPreferencesTags.PREF_POLE);
            if (isInCache) {
                list = cache.getPoles();
            } else {
                if(hasInternet()) {
                    list = service.getPoles();
                    cache.InitialisePolesListIfNotExist(list);
                }
            }
        } else {
            if(hasInternet()) {
                list = service.getPoles();
            }
        }

        return list;
    }

    @Override
    public List<Pole> getPolesToAgency(String idAgency) {
        List<Pole> poles = this.getPoles();
        List<Pole> listAgencyPoles = new ArrayList<>();
        for (Pole pole : poles) {
            if (pole.getId().equals(idAgency)) {
                listAgencyPoles.add(pole);
            }
        }
        return listAgencyPoles;

    }

    @Override
    public List<Pole> getPolesFromName(String name) {
        List<Pole> listPoles = new ArrayList<>();
        for (Pole pole : this.getPoles()) {
            if (pole.getId().startsWith(name)) {
                listPoles.add(pole);
            }
        }
        return listPoles;
    }

    @Override
    public List<Project> getProjects() {
        List<Project> list = null;
        if (CacheIsActivate) {
            boolean isInCache = cache.isInCache(SharedPreferencesTags.PREF_PROJECT);
            if (isInCache) {
                list = cache.getProjects();
            } else
            {
                if(hasInternet()) {
                    list = service.getProjects();
                    cache.InitialiseProjetsListIfNotExist(list);
                }
            }
        } else {
            if(hasInternet()) {
                list = service.getProjects();
            }
        }

        return list;
    }

    @Override
    public List<Project> getProjectsToPole(String idPole) {

        List<Project> list = new ArrayList<>();
        for (Project project : this.getProjects()) {
            if (project.getIdPole().equals(idPole)) {
                list.add(project);
            }
        }
        return list;

    }

    @Override
    public List<Project> getProjectsFromName(String name) {

        List<Project> list = new ArrayList<>();
        for (Project project : this.getProjects()) {
            if (project.getName().startsWith(name)) {
                list.add(project);
            }
        }
        return list;

    }

    @Override
    public List<Collaborator> getCollaborators(){
        List<Collaborator> list = null;
        if (CacheIsActivate) {
            boolean isInCache = cache.isInCache(SharedPreferencesTags.PREF_PROJECT);
            if (isInCache) {
                list = cache.getCollaborators();
            } else
            {
                if(hasInternet()) {
                    list = service.getCollaborators();
                    cache.InitialiseCollaboratorListIfNotExist(list);
                }
            }
        } else {
            if(hasInternet()) {
                list = service.getCollaborators();
            }
        }

        return list;
    }

    @Override
    public boolean verify(String email, String password) throws IOException {
        return service.verify(email,password);
    }

    @Override
    public List<Collaborator> getCollaboratorsToAgency(String idAgency) {

        List<Collaborator> list = new ArrayList<>();
        for(Pole pole: this.getPoles())
        {
            if(pole.getIdAgency().equals(idAgency))
            {
                list.addAll(getCollaboratorsToPole(pole.getId()));
            }
        }
        return list;

    }

    @Override
    public List<Collaborator> getCollaboratorsToPole(String poleId) {
        List<Collaborator> list = new ArrayList<>();
        for(Project project: this.getProjects()){
            if(project.getIdPole().equals(poleId)) {
                list.addAll(getCollaboratorsToProject(project.getId()));
            }
        }
        return list;
    }

    @Override
    public List<Collaborator> getCollaboratorsToProject(String projectId) {
        List<Collaborator> list = new ArrayList<>();
        for(Project project: this.getProjects()){
            if(project.getId().equals(projectId)) {
                list.addAll(project.getColaborators());
                break;
            }
        }
        return list;
    }

    @Override
    public List<Collaborator> getCollaboratorsFromName(String name) {
        List<Collaborator> list = new ArrayList<>();
        for(Collaborator collaborator: this.getCollaborators()){
            if(collaborator.getName().startsWith(name)) {
                list.add(collaborator);
            }
        }
        return list;
    }
}
