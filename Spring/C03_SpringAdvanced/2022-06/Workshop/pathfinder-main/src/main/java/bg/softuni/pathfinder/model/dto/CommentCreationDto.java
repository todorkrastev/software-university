package bg.softuni.pathfinder.model.dto;

public class CommentCreationDto {
    private String username;
    private Long routeId;
    private String message;

    public CommentCreationDto(String username, Long routeId, String message) {
        this.username = username;
        this.routeId = routeId;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
