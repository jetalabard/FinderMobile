package com.finder.business;

/**
 * Created by jerem on 07/03/2018.
 */

public class User {

    private String Id;

    private String Password;

    public User(String id, String password) {
        Id = id;
        Password = password;
    }

    public String getId() {
        return Id;
    }

    public String getPassword() {
        return Password;
    }
}
