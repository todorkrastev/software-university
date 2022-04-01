package com.manhattan.models;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class ProjectModel {
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ProjectModel(String name, String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        stringBuilder.append("Project name: ").append(this.name).append(System.lineSeparator());
        stringBuilder.append("\tProject Description: ")
                .append(String.format("%s...", this.description.substring(0, 35))).append(System.lineSeparator());
        stringBuilder.append("\tProject Start Date: ")
                .append(this.startDate == null ? "null" :
                        convertToUtc(this.startDate, Clock.systemDefaultZone().getZone()).format(formatter))
                .append(System.lineSeparator());
        stringBuilder.append("\tProject End Date: ")
                .append(this.endDate == null ? "null" :
                        convertToUtc(this.endDate, Clock.systemDefaultZone().getZone()).format(formatter));
        return stringBuilder.toString();
    }

    LocalDateTime convertToUtc(LocalDateTime time, ZoneId zone) {
        return time.atZone(zone).withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
    }
}
