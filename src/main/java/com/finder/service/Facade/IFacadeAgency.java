package com.finder.service.Facade;

import com.finder.business.Agency;

import java.util.List;

/**
 * Created by jerem on 04/03/2018.
 */

interface IFacadeAgency {

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
     * récupère l'agence qui porte ce nom
     * @return
     */
    Agency getAgencyByName(String name);

    /**
     * récupère la liste des agences d'un pays et d'une ville
     * @return
     */
    List<Agency> getAgencies(String country,String City);

}
