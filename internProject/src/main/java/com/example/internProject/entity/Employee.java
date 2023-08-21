package com.example.internProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "first_name")
    String name;

    @Column(name = "last_name")
    String surname;
    @Column(name = "email")
    String email;
    @Column(name = "salary")
    int salary;

    //getter and setters


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    //generate constructors

    public Employee(){}

    public Employee(int id, String name, String surname, String email, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.salary = salary;
    }

    public Employee(String name, String surname, String email, int salary) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.salary = salary;
    }
}
