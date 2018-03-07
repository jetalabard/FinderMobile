package fr.finder.service.AbstractService;

import android.app.Activity;

import java.util.List;

import fr.finder.business.Agency;

/**
 * Created by jerem on 04/03/2018.
 */

interface IServiceAgency {

    /**
     * récupere la liste des agences de l'entreprise
     * @return
     */
    List<Agency> getAgencies();

    /**
     * récupère la liste des pays des agences
     * @return
     */
    List<String> getCountries();

    /**
     * récupère la liste des villes d'un pays
     * @return
     */
    List<String> getCities(String country);

    /**
     * récupère la liste des agences d'un pays
     * @return
     */
    List<Agency> getAgencies(String country);

    /**
     * récupère la liste des agences d'un pays et d'une ville
     * @return
     */
    List<Agency> getAgencies(String country,String City);

}
