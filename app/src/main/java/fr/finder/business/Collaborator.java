package fr.finder.business;

/**
 * Created by jerem on 16/02/2018.
 */

public class Collaborator {

    private String Id;

    private String Name;

    private String FirstName;

    private String ImagePath;

    private String Job;


    /**
     *
     * @param id
     * @param name
     * @param firstName
     * @param imagePath
     * @param job
     */
    public Collaborator(String id,String name, String firstName, String imagePath, String job) {
        Name = name;
        this.Id = id;
        FirstName = firstName;
        ImagePath = imagePath;
        Job = job;
    }

    public String getName() {
        return Name;
    }

    public String getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getJob() {
        return Job;
    }

}
