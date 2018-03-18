package com.test;

import com.finder.business.Adress;
import com.finder.business.Agency;
import com.finder.business.Collaborator;
import com.finder.business.Pole;
import com.finder.business.Project;
import com.finder.business.User;
import com.finder.service.WebService.IAccessData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerem on 16/02/2018.
 */

/**
 * jeu de données de test
 */
public class AccessDataTest implements IAccessData {



    /**
     * liste d'adresse
     */
    public static List<Adress> Adresses = new ArrayList<Adress>(){{
        add(new Adress("5","rue Saint-George","Clermont-Ferrand","63000","France","45.783469","3.081629"));
        add(new Adress("18","rue Saint Honoré","Paris","75000","France","48.860783","2.345759"));
    }};

    /**
     * liste d'agences
     */
    public static List<Agency> Agencies = new ArrayList<Agency>(){{
        add(new Agency("124","AgenceTest","description","",Adresses.get(0)));
        add(new Agency("125","AgenceTest2","description","",Adresses.get(1)));
    }};
    /**
     * liste de pole
     */
    public static List<Pole> Poles = new ArrayList<Pole>(){{
        add(new Pole("1","Pole Bi","Decription du pole","124"));
        add(new Pole("2","Autre pole","Decription de l'autre pole","124"));
    }};

    /**
     * liste de collaborateurs
     */
    public static List<Collaborator> Collaborators = new ArrayList<Collaborator>(){{
        add(new Collaborator("10","Name","Firstname","","Developpeur","test@test.fr"));
        add(new Collaborator("11", "Name2","Firstname2","","Chef de Projet","test2@test.fr"));
    }};

    /**
     * liste de ustilisateurs pour la connexion
     */
    public static List<User> Users = new ArrayList<User>(){{
        add(new User("test","password"));
        add(new User("test2", "password"));
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

    @Override
    public boolean verify(String username, String password)
    {
        for (User u: Users) {
            if(u.getId().equals(username) && u.getPassword().equals(password)){
                return true;
            }
        };
        return false;
    }


}
