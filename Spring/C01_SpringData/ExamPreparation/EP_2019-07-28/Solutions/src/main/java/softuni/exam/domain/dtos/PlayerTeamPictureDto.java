package softuni.exam.domain.dtos;

import javax.validation.constraints.NotBlank;

public class PlayerTeamPictureDto {
    private String url;

    @NotBlank
    public String getUrl() {
        return url;
    }
}
