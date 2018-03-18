package com.finder.business;

/**
 * Created by jerem on 16/02/2018.
 */

public class Adress {

    private String Number;

    private String Road;

    private String City;

    private String Country;

    private String Code;

    private String Lattitude;

    private String Longitude;

    public Adress(String number, String road, String city, String country, String code, String lattitude, String longitude) {
        Number = number;
        Road = road;
        City = city;
        Country = country;
        Code = code;
        Lattitude = lattitude;
        Longitude = longitude;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getRoad() {
        return Road;
    }

    public void setRoad(String road) {
        Road = road;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getLattitude() {
        return Lattitude;
    }

    public String getLongitude() {
        return Longitude;
    }
}
