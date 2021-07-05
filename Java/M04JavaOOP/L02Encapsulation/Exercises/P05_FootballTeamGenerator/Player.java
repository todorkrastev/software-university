package bg.softuni.java_oop.encapsulation.exercises.P05_FootballTeamGenerator;

public class Player {
    private String playerName;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String playerName, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(playerName);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String playerName) {
        Validator.validateName(playerName);
        this.playerName = playerName;
    }

    public String getName() {
        return this.playerName;
    }

    private void setEndurance(int endurance) {
        Validator.validateStat(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        Validator.validateStat(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        Validator.validateStat(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        Validator.validateStat(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        Validator.validateStat(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (double) (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5;
    }
}
