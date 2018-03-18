package com.finder.service.Facade;

import com.finder.business.Project;

import java.util.List;

/**
 * Created by jerem on 04/03/2018.
 */

interface IFacadeProject {

    /***
     * recupère la liste des projets d'un pole de l'entreprise
     * @param idPole
     * @return
     */
    List<Project> getProjectsToPole(String idPole);


    /***
     * recupère la liste des projets par leurs noms
     * @param name
     * @return
     */
    List<Project> getProjectsFromName(String name);


    /***
     * recupère la liste des projets
     * @return
     */
    List<Project> getProjects();
}
