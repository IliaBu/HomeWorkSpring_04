package ru.gb_spring.homeworkspring_04.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
