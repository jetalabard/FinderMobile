package fr.finder.service.AbstractService;

import java.util.List;

import fr.finder.business.Collaborator;
import fr.finder.business.Pole;

/**
 * Created by jerem on 04/03/2018.
 */

interface IServiceCollaborator {

    /**
     * récupère la liste des collaborateurs d'une agence
     * @param idAgency
     * @return
     */
    List<Collaborator> getCollaboratorsToAgency(String idAgency);


    /**
     * récupère la liste des collaborateurs d'un pôle
     * @param poleId
     * @return
     */
    List<Collaborator> getCollaboratorsToPole(String poleId);

    /**
     * récupère la liste des collaborateurs d'un projet
     * @param projectId
     * @return
     */
    List<Collaborator> getCollaboratorsToProject(String projectId);

    /**
     * récupère la liste des collaborateurs par leurs noms
     * @param name
     * @return
     */
    List<Collaborator> getCollaboratorsFromName(String name);

    /**
     * récupère la liste des collaborateurs
     * @return
     */
    List<Collaborator> getCollaborators();








}
