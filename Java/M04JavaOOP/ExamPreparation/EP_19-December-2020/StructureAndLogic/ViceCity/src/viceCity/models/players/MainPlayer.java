package viceCity.models.players;

public class MainPlayer extends BasePlayer {
    private static final String DEFAULT_NAME = "Tommy Vercetti";
    private static final int DEFAULT_LIFE_POINTS = 100;

    public MainPlayer() {
        super(DEFAULT_NAME, DEFAULT_LIFE_POINTS);
    }
}
