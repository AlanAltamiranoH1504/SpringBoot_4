package com.example.springboot_4_initial.models;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.Date;

@Entity()
@Table(name = "tbl_vacancys")
@JsonPropertyOrder({"id_vacancy", "name", "description", "location",
        "salary", "publication_date", "finish_date", "requirements", "responsibilities",
        "image", "status", "contract_type", "progressStatus", "industrialSector", "workModality", "category",})
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vacancy;
    private String name;
    private String description;
    private String location;
    private double salary;
    private Date publication_date;
    private Date finish_date;
    private String requirements;
    private String responsibilities;
    private String image;
    private boolean status;

    // * Una vacante pertenece a un contract_type
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_contract_type")
    private ContractType contract_type;

    // * Un vacante pertence a un proress_status
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_progress_status")
    private ProgressStatus progressStatus;

    // * Una vacante pertenece a un sector de industrial
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_industrial_sector")
    private IndustrialSector industrialSector;

    // * Una vacante pertence a una modalidad de trabajo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_work_modality")
    private WorkModality workModality;

    // * Una vacante pertenece a una categoria
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private Category category;

    // * Una vacante pertenece a un reclutador
    @ManyToOne()
    @JoinColumn(name = "id_recruiter")
    private Recruiter recruiter;

    public Vacancy() {
    }

    public Vacancy(String name, String description, String location, double salary, Date publication_date, Date finish_date, String requirements, String responsibilities, String image, boolean status, ContractType contract_type, ProgressStatus progressStatus, IndustrialSector industrialSector, WorkModality workModality, Category category, Recruiter recruiter) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.publication_date = publication_date;
        this.finish_date = finish_date;
        this.requirements = requirements;
        this.responsibilities = responsibilities;
        this.image = image;
        this.status = status;
        this.contract_type = contract_type;
        this.progressStatus = progressStatus;
        this.industrialSector = industrialSector;
        this.workModality = workModality;
        this.category = category;
        this.recruiter = recruiter;
    }

    public Long getId_vacancy() {
        return id_vacancy;
    }

    public void setId_vacancy(Long id_vacancy) {
        this.id_vacancy = id_vacancy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ContractType getContract_type() {
        return contract_type;
    }

    public void setContract_type(ContractType contract_type) {
        this.contract_type = contract_type;
    }

    public ProgressStatus getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }

    public IndustrialSector getIndustrialSector() {
        return industrialSector;
    }

    public void setIndustrialSector(IndustrialSector industrialSector) {
        this.industrialSector = industrialSector;
    }

    public WorkModality getWorkModality() {
        return workModality;
    }

    public void setWorkModality(WorkModality workModality) {
        this.workModality = workModality;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}
