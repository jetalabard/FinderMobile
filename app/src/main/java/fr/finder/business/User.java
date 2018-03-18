package fr.finder.business;

/**
 * Created by jerem on 07/03/2018.
 */

public class User {

    private String username;
    private String Password;

    public User(String id, String password) {
        username = id;
        Password = password;
    }

    public String getId() {
        return username;
    }

    public String getPassword() {
        return Password;
    }
}
