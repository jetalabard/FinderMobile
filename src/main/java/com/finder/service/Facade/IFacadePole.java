package com.finder.service.Facade;

import java.util.List;

import com.finder.business.Pole;

/**
 * Created by jerem on 04/03/2018.
 */

interface IFacadePole {


    /**
     * récupère la liste des poles d'une agence
     * @param idAgency
     * @return
     */
    List<Pole> getPolesToAgency(String idAgency);


    /**
     * récupère la liste des poles par leurs noms
     * @param name
     * @return
     */
    List<Pole> getPolesFromName(String name);

    /**
     * récupère la liste des poles
     * @return
     */
    List<Pole> getPoles();

}
