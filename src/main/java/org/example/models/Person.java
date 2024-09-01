package org.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity //в конфигурации SessionFactory просканит этот класс с этой аннотацией
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Аннотации от hibernate-validator для ограничения на поля формы по вводимым данным

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Size of name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "age can't be negative")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid") //проверяет формат
    @Column(name = "email")
    private String email;

//    //Страна, город, индекс (6 цифр)
//    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your adress should be in this format: Country, City, Postal Code (6 digits)")
//    private String adress;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
