package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.enumeration;

public enum Corps {

    AIRFORCES("Airforces"), MARINES("Marines");

    private final String corps;

    Corps(String corps) {
        this.corps = corps;
    }

    public String getCorps() {
        return corps;
    }

    public static boolean isValidCorps(String corps) {
        return corps.equals(AIRFORCES.getCorps()) || corps.equals(MARINES.getCorps());
    }
}
