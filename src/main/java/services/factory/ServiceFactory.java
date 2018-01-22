package services.factory;

import services.impl.MasterService;
import services.impl.UserService;

public class ServiceFactory {
    static private UserService userService;
    static private MasterService masterService;

    static {
        userService = new UserService();
        masterService = new MasterService();
    }

    public static UserService getUserService() {
        return userService;
    }

    public static MasterService getMasterService() {
        return masterService;
    }
}

