package softuni.exam.models.dtos;

import java.time.LocalDate;

public class CarsListDto {
    private String make;
    private String model;
    private int kilometers;
    private LocalDate dateOfRegistration;
    private int countOfPictures;

    public CarsListDto(String make, String model, int kilometers, LocalDate dateOfRegistration, int countOfPictures) {
        this.make = make;
        this.model = model;
        this.kilometers = kilometers;
        this.dateOfRegistration = dateOfRegistration;
        this.countOfPictures = countOfPictures;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Car make - %s, model - %s", make, model)).append(System.lineSeparator());
        sb.append(String.format("\tKilometers - %d", kilometers)).append(System.lineSeparator());
        sb.append(String.format("\tRegistered on - %s", dateOfRegistration)).append(System.lineSeparator());
        sb.append(String.format("\tNumber of pictures - %d", countOfPictures));
        return sb.toString();
    }
}
