package softuni.exam.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlayerTeamDto {
    private String name;

    private PlayerTeamPictureDto picture;

    @NotBlank
    public String getName() {
        return name;
    }

    @NotNull
    public PlayerTeamPictureDto getPicture() {
        return picture;
    }
}
