package main.designs.factory;

import java.util.HashMap;

class UserFactoryFlyweight {
    public enum UserType{
        free,
        premium
    }
    private static HashMap<UserType,User> map = new HashMap<>();
    static User getUser(UserFactoryFlyweight.UserType userType, String name, String userName, String location, String bio){
        User user = null;
        switch (userType){
            case free : user = map.containsKey(UserType.free) ? map.get(UserType.free) : new FreeUser(userName,name,location,bio) ;
            user.setUserName(userName);
            user.setName(name);
            user.setLocation(location);
            user.setBio(bio);
            break;
            case premium : user = map.containsKey(UserType.premium) ? map.get(UserType.premium) : new PremiumUser(userName,name,location,bio) ;
            user.setUserName(userName);
            user.setName(name);
            user.setLocation(location);
            user.setBio(bio);
            break;
        };
        return user;
    }
    static void test(){
        User user  = UserFactoryFlyweight.getUser(
                UserFactoryFlyweight.UserType.free,
                "Test",
                "test",
                "earth",
                "math"
        ),
                u2 = UserFactoryFlyweight.getUser(
                        UserFactoryFlyweight.UserType.premium,
                        "fg",
                        "fdff",
                        "fdfd",
                        "fdfdsgf"
                );
    }
}
