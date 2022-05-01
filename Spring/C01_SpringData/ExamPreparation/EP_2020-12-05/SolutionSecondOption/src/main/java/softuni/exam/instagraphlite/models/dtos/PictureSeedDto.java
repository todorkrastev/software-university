package softuni.exam.instagraphlite.models.dtos;

import softuni.exam.instagraphlite.util.MessageName;

import javax.validation.constraints.*;

@MessageName(name = "Picture")
public class PictureSeedDto {

    private String path;

    private Double size;

    /**
     *  A char sequence. Cannot be null. The path is unique.
     */
    @NotBlank
    public String getPath() {
        return path;
    }

    /**
     * A floating point number. Cannot be null.
     * Must be between 500 and 60000 (both numbers are INCLUSIVE)
     */
    @Min(500)
    @Max(60000)
    @NotNull
    public Double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format(", with size %.2f", size);
    }
}
