package fr.finder.service.AbstractService;

import java.util.List;

import fr.finder.business.Project;

/**
 * Created by jerem on 04/03/2018.
 */

interface IServiceProject {

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
