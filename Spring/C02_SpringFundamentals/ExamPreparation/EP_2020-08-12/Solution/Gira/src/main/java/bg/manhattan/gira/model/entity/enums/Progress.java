package bg.manhattan.gira.model.entity.enums;

public enum Progress {
    OPEN, IN_PROGRESS, COMPLETED, OTHER;

    public boolean hasNextStatus(){
        return !this.equals(OTHER);
    }

    public Progress getNext(){
        return switch (this) {
            case OPEN -> IN_PROGRESS;
            case IN_PROGRESS -> COMPLETED;
            case COMPLETED -> OTHER;
            default -> throw new IllegalStateException("Cannot calculate new status");
        };
    }
}
