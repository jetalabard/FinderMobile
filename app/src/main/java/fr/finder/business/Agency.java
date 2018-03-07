package fr.finder.business;

import java.util.List;

/**
 * Created by jerem on 16/02/2018.
 */

public class Agency {

    private String Id;

    private String Name;

    private String Description;

    private String ImagePath;

    private Adress Adress;


    /**
     *
     * @param id
     * @param name
     * @param description
     * @param imagePath
     * @param adress
     */
    public Agency(String id,String name, String description, String imagePath, Adress adress) {
        this.Id = id;
        Name = name;
        Description = description;
        ImagePath = imagePath;
        Adress = adress;
    }

    public String getId() {
        return Id;
    }

    public String getDescription() {
        return Description;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getName() {
        return Name;
    }

    public fr.finder.business.Adress getAdress() {
        return Adress;
    }

}
