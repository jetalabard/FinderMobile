package com.finder.business;

import java.util.List;

/**
 * Created by jerem on 16/02/2018.
 */

public class Pole {

    private String Id;

    private String Name;

    private String Description;

    private String IdAgency;

    /**
     *
     * @param id
     * @param name
     * @param description
     * @param idAgency
     */
    public Pole(String id,String name, String description,String idAgency) {
        this.Id = id;
        Name = name;
        Description = description;
        this.IdAgency = idAgency;
    }

    public String getId() {
        return Id;
    }

    public String getIdAgency() {
        return IdAgency;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

}
