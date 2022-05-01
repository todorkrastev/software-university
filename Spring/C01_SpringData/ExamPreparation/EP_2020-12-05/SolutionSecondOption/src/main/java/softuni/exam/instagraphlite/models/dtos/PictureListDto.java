package softuni.exam.instagraphlite.models.dtos;

public class PictureListDto {
    private Double size;
    private String path;

    public void setSize(Double size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return String.format("%.2f - %s",  size, path);
    }
}
