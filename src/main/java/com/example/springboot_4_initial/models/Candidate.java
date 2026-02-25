package com.example.springboot_4_initial.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity()
@Table(name = "tbl_candidates")
@JsonPropertyOrder({"id_candidate", "name_candidate", "lastname_candidate", "email", "img_profile", "cellphone", "address", "token_confirm_account", "token_reset_password", "randome_number", "status", "profile"})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_candidate;
    private String name_candidate;
    private String lastname_candidate;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String img_profile;
    private String cellphone;
    private String address;
    private String token_confirm_account;
    private String token_reset_password;
    private String randome_number;
    private boolean status;

    // * Un candidato pertenece a un perfil
    @ManyToOne()
    @JoinColumn(name = "id_profile")
    private Profile profile;

    public Candidate() {
    }

    public Candidate(String name_candidate, String lastname_candidate, String email, String password, String img_profile, String cellphone, String address, String token_confirm_account, String token_reset_password, String randome_number, boolean status) {
        this.name_candidate = name_candidate;
        this.lastname_candidate = lastname_candidate;
        this.email = email;
        this.password = password;
        this.img_profile = img_profile;
        this.cellphone = cellphone;
        this.address = address;
        this.token_confirm_account = token_confirm_account;
        this.token_reset_password = token_reset_password;
        this.randome_number = randome_number;
        this.status = status;
    }

    public Candidate(Long id_candidate, String name_candidate, String lastname_candidate, String email, String password, String img_profile, String cellphone, String address, String token_confirm_account, String token_reset_password, String randome_number, boolean status) {
        this.id_candidate = id_candidate;
        this.name_candidate = name_candidate;
        this.lastname_candidate = lastname_candidate;
        this.email = email;
        this.password = password;
        this.img_profile = img_profile;
        this.cellphone = cellphone;
        this.address = address;
        this.token_confirm_account = token_confirm_account;
        this.token_reset_password = token_reset_password;
        this.randome_number = randome_number;
        this.status = status;
    }

    public Candidate(String name_candidate, String lastname_candidate, String email, String password, String img_profile, String cellphone, String address, String token_confirm_account, String token_reset_password, String randome_number, boolean status, Profile profile) {
        this.name_candidate = name_candidate;
        this.lastname_candidate = lastname_candidate;
        this.email = email;
        this.password = password;
        this.img_profile = img_profile;
        this.cellphone = cellphone;
        this.address = address;
        this.token_confirm_account = token_confirm_account;
        this.token_reset_password = token_reset_password;
        this.randome_number = randome_number;
        this.status = status;
        this.profile = profile;
    }

    public Long getId_candidate() {
        return id_candidate;
    }

    public void setId_candidate(Long id_candidate) {
        this.id_candidate = id_candidate;
    }

    public String getName_candidate() {
        return name_candidate;
    }

    public void setName_candidate(String name_candidate) {
        this.name_candidate = name_candidate;
    }

    public String getLastname_candidate() {
        return lastname_candidate;
    }

    public void setLastname_candidate(String lastname_candidate) {
        this.lastname_candidate = lastname_candidate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg_profile() {
        return img_profile;
    }

    public void setImg_profile(String img_profile) {
        this.img_profile = img_profile;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken_confirm_account() {
        return token_confirm_account;
    }

    public void setToken_confirm_account(String token_confirm_account) {
        this.token_confirm_account = token_confirm_account;
    }

    public String getToken_reset_password() {
        return token_reset_password;
    }

    public void setToken_reset_password(String token_reset_password) {
        this.token_reset_password = token_reset_password;
    }

    public String getRandome_number() {
        return randome_number;
    }

    public void setRandome_number(String randome_number) {
        this.randome_number = randome_number;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
