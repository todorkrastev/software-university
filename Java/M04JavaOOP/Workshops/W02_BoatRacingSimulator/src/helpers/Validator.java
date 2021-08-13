package helpers;

public class Validator {

    public static boolean validateBoatModel(String model){
        return model.length() >= 5;
    }

    public static boolean validateEngineModel(String model){
        return model.length() >= 3;
    }
    public static String generateErrorMessage(String paramName) {
        return String.format("%s must be a positive integer.", paramName);
    }


    public static boolean validateParam(int param) {
        return param > 0;
    }
    public static boolean validateSailEfficiency(int efficiency){
        return efficiency > 0 && efficiency < 101;
    }
}
