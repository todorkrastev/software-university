package softuni.exam.domain.dtos;

import javax.validation.constraints.NotBlank;

public class PlayerPictureDto {
    private String url;

    @NotBlank
    public String getUrl() {
        return url;
    }
}
