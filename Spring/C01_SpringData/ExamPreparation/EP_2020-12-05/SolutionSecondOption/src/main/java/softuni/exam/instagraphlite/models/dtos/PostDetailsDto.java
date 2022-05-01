package softuni.exam.instagraphlite.models.dtos;

public class PostDetailsDto {
    private String caption;
    private Double pictureSize;

    public PostDetailsDto(String caption, Double pictureSize) {
        this.caption = caption;
        this.pictureSize = pictureSize;
    }

    @Override
    public String toString() {
        return String.format("==Post Details:%n----Caption: %s%n----Picture Size: %.2f", caption, pictureSize);
    }

    public Double getPictureSize() {
        return pictureSize;
    }
}
