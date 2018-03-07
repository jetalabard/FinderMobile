package fr.finder.service.ImplementationService;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import fr.finder.business.Agency;
import fr.finder.business.Collaborator;
import fr.finder.business.Pole;
import fr.finder.business.Project;
import fr.finder.service.AbstractService.IAccessData;
import fr.finder.service.AbstractService.IService;
import fr.finder.service.AbstractService.IServiceCache;
import fr.finder.service.Cache.SharedPreferencesTags;
import fr.test.DataTest;

/**
 * Created by jerem on 04/03/2018.
 */

public class ServiceFacade implements IService {

    private IServiceCache cache;

    private boolean CacheIsActivate;

    private IAccessData service;

    public ServiceFacade(Activity activity)
    {
        cache = new ServiceCache(activity);
        CacheIsActivate = cache.cacheIsActivate();
        if (ChoiceDataTestOrRealData.DataTestOrRealData) {
            service = new AccessDataWebService();
        } else {
            service = new DataTest();
        }

    }

    @Override
    public List<Agency> getAgencies() {
        List<Agency> list;
        if (CacheIsActivate) {
            boolean isInCache = cache.isInCache(SharedPreferencesTags.PREF_AGENCY);
            if (isInCache) {
                list = cache.getAgencies();
            } else {
                list = service.getAgencies();
                cache.InitialiseAngenciesListIfNotExist(list);
            }
        } else {
            list = service.getAgencies();
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
        List<Pole> list;
        if (CacheIsActivate) {
            boolean isInCache = cache.isInCache(SharedPreferencesTags.PREF_POLE);
            if (isInCache) {
                list = cache.getPoles();
            } else {
                list = service.getPoles();
                cache.InitialisePolesListIfNotExist(list);
            }
        } else {
            list = service.getPoles();
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
        List<Project> list;
        if (CacheIsActivate) {
            boolean isInCache = cache.isInCache(SharedPreferencesTags.PREF_PROJECT);
            if (isInCache) {
                list = cache.getProjects();
            } else {
                list = service.getProjects();
                cache.InitialiseProjetsListIfNotExist(list);
            }
        } else {
            list = service.getProjects();
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
        List<Collaborator> list;
        if (CacheIsActivate) {
            boolean isInCache = cache.isInCache(SharedPreferencesTags.PREF_PROJECT);
            if (isInCache) {
                list = cache.getCollaborators();
            } else {
                list = service.getCollaborators();
                cache.InitialiseCollaboratorListIfNotExist(list);
            }
        } else {
            list = service.getCollaborators();
        }

        return list;
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
