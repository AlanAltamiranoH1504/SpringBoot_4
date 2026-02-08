package com.example.springboot_4_initial.models;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.Date;

@Entity()
@Table(name = "tbl_vacancys")
@JsonPropertyOrder({ "id", "name", "description", "salary", "publication_date", "status", "image", "category", })
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date publication_date;
    private String description;
    private double salary;
    private boolean status;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private Category category;

    public Vacancy() {
    }

    public Vacancy(String name, Date publication_date, String description, double salary, boolean status, String image, Category category) {
        this.name = name;
        this.publication_date = publication_date;
        this.description = description;
        this.salary = salary;
        this.status = status;
        this.image = image;
        this.category = category;
    }

    public Vacancy(Long id, String name, Date publication_date, String description, double salary, boolean status, String image, Category category) {
        this.id = id;
        this.name = name;
        this.publication_date = publication_date;
        this.description = description;
        this.salary = salary;
        this.status = status;
        this.image = image;
        this.category = category;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
