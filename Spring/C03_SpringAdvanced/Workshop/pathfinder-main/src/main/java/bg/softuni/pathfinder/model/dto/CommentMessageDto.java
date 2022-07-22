package bg.softuni.pathfinder.model.dto;

public class CommentMessageDto {
    private String message;

    public CommentMessageDto() {
    }

    public CommentMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
