package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class PictureSeedDto {
    @Expose
    private String name; // a char sequence (between 2 to 20 exclusive).

    @Expose
    private String dateAndTime; // The date and time of a picture.

    @Expose
    private Long car;

    public PictureSeedDto() {
    }

    @Size(min = 2, max = 19)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }
}
