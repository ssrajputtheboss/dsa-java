package main.designs.factory;

public class PremiumUser extends User {
    private String logo;

    public PremiumUser(String userName, String name, String location, String bio) {
        super(userName, name, location, bio);
        grokEnabled=true;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }
}
