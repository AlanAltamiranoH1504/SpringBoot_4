package com.example.springboot_4_initial.models;


import java.util.Date;

public class Vacancy {
    private Long id;
    private String name;
    private Date publication_date;
    private String description;
    private double salary;
    private boolean status;

    public Vacancy() {
    }

    public Vacancy(Long id, String name, Date publication_date, String description, double salary, boolean status) {
        this.id = id;
        this.name = name;
        this.publication_date = publication_date;
        this.description = description;
        this.salary = salary;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publication_date=" + publication_date +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}
