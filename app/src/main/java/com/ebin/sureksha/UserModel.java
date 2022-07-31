package com.ebin.sureksha;

public class UserModel {
    public static final String JSON_EMAIL = "email";
    public static final String JSON_NAME = "name";
    public static final String JSON_LOCATION = "location";
    public static final String JSON_PASSWORD = "password";

    private String Email;
    private String Password;
    private String Location;
    private String Name;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
