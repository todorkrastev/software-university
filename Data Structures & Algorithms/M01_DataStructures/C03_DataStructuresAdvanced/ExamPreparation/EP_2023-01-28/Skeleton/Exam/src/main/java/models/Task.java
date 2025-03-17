package models;

public class Task {
    private String id;

    private String name;

    private int estimatedExecutionTime;

    private String domain;

    public Task(String id, String name, int estimatedExecutionTime, String domain) {
        this.id = id;
        this.name = name;
        this.estimatedExecutionTime = estimatedExecutionTime;
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimatedExecutionTime() {
        return estimatedExecutionTime;
    }

    public void setEstimatedExecutionTime(int estimatedExecutionTime) {
        this.estimatedExecutionTime = estimatedExecutionTime;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
