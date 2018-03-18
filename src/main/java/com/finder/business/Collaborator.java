package com.finder.business;

/**
 * Created by jerem on 16/02/2018.
 */

public class Collaborator {

    private String Id;

    private String Name;

    private String FirstName;

    private String ImagePath;

    private String Job;

    private String Email;


    public Collaborator(String id, String name, String firstName, String imagePath, String job, String email) {
        Id = id;
        Name = name;
        FirstName = firstName;
        ImagePath = imagePath;
        Job = job;
        Email = email;
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

    public String getEmail() {
        return Email;
    }
}
