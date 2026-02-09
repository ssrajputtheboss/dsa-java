package main.designs.factory;

class UserFactory {
    public enum UserTypes{
        free,
        premium
    }
    static User getUser(UserTypes userType, String name, String userName, String location, String bio){
        return switch (userType){
            case free -> new FreeUser(userName,name,location,bio);
            case premium -> new PremiumUser(userName,name,location,bio);
        };
    }
    static void test(){
        User user  = UserFactory.getUser(
                UserTypes.free,
                "Test",
                "test",
                "earth",
                "math"
        ),
        u2 = UserFactory.getUser(
                UserTypes.premium,
                "fg",
                "fdff",
                "fdfd",
                "fdfdsgf"
        );
    }
}
