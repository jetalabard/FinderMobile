package com.finder.service.Cache;

import com.finder.business.Agency;
import com.finder.business.Collaborator;
import com.finder.business.Pole;
import com.finder.business.Project;
import com.finder.business.User;

import java.util.List;

/**
 * Created by jerem on 05/03/2018.
 */

public interface IServiceCache
{
    /**
     * recupère les agences en cache
     * @return
     */
    List<Agency> getAgencies();

    /**
     * ajoute une agence en cache
     * @param agency
     */
    void addAgencies(Agency agency);

    /**
     * ajoute une liste d'agences sous forme JSON en cache
     * @param agencies
     */
    void InitialiseAngenciesListIfNotExist(List<Agency> agencies);

    /**
     * recupère les agences favorites en cache
     * @return
     */
    List<Agency> getFavoriteAgencies();

    /**
     *  ajoute une agence favorite en cache
     * @param agency
     */
    void addFavoriteAgencies(Agency agency);

    /**
     * ajoute une liste d'agences favorites sous forme JSON en cache
     * @param agencies
     */
    void InitialiseFavoritesAngenciesListIfNotExist(List<Agency> agencies);

    /**
     * recupère les poles en cache
     * @return
     */
    List<Pole> getPoles();

    /**
     * ajoute un pole en cache
     * @param pole
     */
    void addPole(Pole pole);

    /**
     * ajoute une liste de poles sous forme JSON en cache
     * @param poles
     */
    void InitialisePolesListIfNotExist(List<Pole> poles);

    /**
     * recupère les projets en cache
     * @return
     */
    List<Project> getProjects();

    /**
     * ajoute un projet en cache
     * @param project
     */
    void addProject(Project project);

    /**
     * ajoute une liste de projets sous forme JSON en cache
     * @param project
     */
    void InitialiseProjetsListIfNotExist(List<Project> project);

    /**
     * recupère les collaborateurs en cache
     * @return
     */
    List<Collaborator> getCollaborators();

    /**
     * ajoute un collaborateur en cache
     * @param collaborator
     */
    void addCollaborator(Collaborator collaborator);

    /**
     * ajoute une liste de collaborateurs sous forme JSON en cache
     * @param collaborators
     */
    void InitialiseCollaboratorListIfNotExist(List<Collaborator> collaborators);

    /**
     * vérifie si la liste correspondant au tag est en cache et a une date de validité correcte
     * @return
     */
    boolean isInCache(String tag);

    /**
     * ajoute une liste en cache pour connaitre son temps de validité
     * @param cache
     */
    void addCache(FinderCache cache);


    /**
     * recupère en cache la durée de validité
     * @return
     */
    long getDeadlineValidity();


    /**
     * vérifie si le cache est activé
     * @return
     */
    boolean cacheIsActivate();

    /**
     * désactive le cache
     * @return
     */
    void desactivateCache();

    /**
     * active le cache
     * @return
     */
    void activateCache();

    /**
     * retourne l'identité de la personne si elle c'est déjà connecté
     * @return
     */
    User getIdentity() ;

    /**
     * ajoute un utilisateur en cache
     * @param user
     */
    void addIdentity(User user);

}
