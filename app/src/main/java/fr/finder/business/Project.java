package fr.finder.business;

import java.util.List;

/**
 * Created by jerem on 16/02/2018.
 */

public class Project {

    private String Id;

    private String Name;

    private List<Collaborator> colaborators;

    private String Description;

    private String IdPole;

    /**
     *
     * @param id
     * @param name
     * @param colaborators
     * @param description
     * @param idPole
     */
    public Project(String id,String name, List<Collaborator> colaborators, String description,String idPole) {
        this.Id = id;
        Name = name;
        this.colaborators = colaborators;
        Description = description;
        this.IdPole = idPole;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getIdPole() {
        return IdPole;
    }

    public List<Collaborator> getColaborators() {
        return colaborators;
    }

    public String getDescription() {
        return Description;
    }
}
