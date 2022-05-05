package softuni.exam.domain.dtos;

import softuni.exam.domain.entities.enums.Position;
import softuni.exam.util.MessageName;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@MessageName(name="player")
public class PlayerSeedDto {

    private String firstName;

    private String lastName;

    private int number;

    private BigDecimal salary;

    private Position position;

    private PlayerPictureDto picture;

    private PlayerTeamDto team;


    /**
     * A string (required).
     */
    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    /**
     * A string (required) between 3 and 15 characters.
     */
    @NotBlank
    @Size(min=3, max=15)
    public String getLastName() {
        return lastName;
    }

    /**
     * A Integer (required) between 1 and 99.
     */
    @Min(1)
    @Max(99)
    public int getNumber() {
        return number;
    }

    /**
     * A Bigdecimal (required) min 0.
     */
    @PositiveOrZero
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * A ENUM (required).
     */
//    @Pattern(regexp = "^(GK|CB|LB|RB|LWB|RWB|SW|DM|CM|AM|LW|RW|WF|CF|RM|LM|ST){1}$")
//    public String getPosition() {
//        return position;
//    }
    @NotNull
    public Position getPosition() {
        return position;
    }

    /**
     * A Picture entity (required).
     */
    @NotNull
    public PlayerPictureDto getPicture() {
        return picture;
    }

    /**
     * A Team entity (required).
     */
    @NotNull
    public PlayerTeamDto getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
