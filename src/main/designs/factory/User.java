package main.designs.factory;

abstract class User {
    protected String userName,name,location,bio;
    protected boolean grokEnabled;

    public User(String userName, String name, String location, String bio) {
        this.userName = userName;
        this.name = name;
        this.location = location;
        this.bio = bio;
        grokEnabled=false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
