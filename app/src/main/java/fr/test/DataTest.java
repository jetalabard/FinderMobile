package fr.test;

import java.util.ArrayList;
import java.util.List;

import fr.finder.business.Adress;
import fr.finder.business.Agency;
import fr.finder.business.Collaborator;
import fr.finder.business.Pole;
import fr.finder.business.Project;
import fr.finder.service.AbstractService.IAccessData;
import fr.finder.service.AbstractService.IService;

/**
 * Created by jerem on 16/02/2018.
 */

/**
 * jeu de données de test
 */
public class DataTest implements IAccessData {

    /**
     * liste d'agences
     */
    public static List<Agency> Agencies = new ArrayList<Agency>(){{
        add(new Agency("124","AgenceTest","description","",Adresses.get(0)));
    }};

    /**
     * liste d'adresse
     */
    public static List<Adress> Adresses = new ArrayList<Adress>(){{
        add(new Adress("5","rue George Clemenceau","Clermont-Ferrand","63000","France"));
        add(new Adress("18","rue Saint Honoré","Paris","75000","France"));
    }};

    /**
     * liste de pole
     */
    public static List<Pole> Poles = new ArrayList<Pole>(){{
        add(new Pole("1","Pole Bi","Decription du pole","124"));
        add(new Pole("2","Autre pole","Decription de l'autre pole","124"));
    }};

    /**
     * liste de projets pour le pole 1
     */
    public static List<Project> Projects = new ArrayList<Project>(){{
        add(new Project("10275","Nom du Projet",Collaborators,"Description du projet","1"));
        add(new Project("10276","Nom de l'autre Projet",Collaborators,"Description de l'autre projet","1"));

        add(new Project("105","FFFFFFFFFFF",Collaborators,"Description de FFFFFFFF","2"));
        add(new Project("106","Nom de l'autre FFGGV",Collaborators,"Description de l'autre projet FFGGV","2"));
    }};

    /**
     * liste de collaborateurs
     */
    public static List<Collaborator> Collaborators = new ArrayList<Collaborator>(){{
        add(new Collaborator("10","Name","Firstname","","Developpeur"));
        add(new Collaborator("11", "Name2","Firstname2","","Chef de Projet"));
    }};

    @Override
    public List<Agency> getAgencies() {
        return Agencies;
    }

    @Override
    public List<Pole> getPoles() {
        return Poles;
    }

    @Override
    public List<Project> getProjects() {
        return Projects;
    }

    @Override
    public List<Collaborator> getCollaborators() {
        return Collaborators;
    }



}
