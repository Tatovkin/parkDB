package by.academy.it;

public class Services {

    private static UserService userService = null;
    private static PlantSevice plantSevice = null;

    public static synchronized UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public static synchronized PlantSevice getPlantSevice() {
        if (plantSevice == null) {
            plantSevice = new PlantSevice();
        }
        return plantSevice;
    }
}
