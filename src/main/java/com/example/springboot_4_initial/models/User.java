package com.example.springboot_4_initial.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity()
@Table(name = "tbl_users")
@JsonPropertyOrder({"id", "name", "surnames", "email", "password", "username", "img_profile", "status", "register_date", "profiles"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surnames;
    private String email;
    private String username;
    private String password;
    private String img_profile;
    private String token_confirm_account;
    private String token_reset_password;
    private String randome_number;
    private boolean status;
    private Date register_date;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_rel_users_profile",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_profile")
    )
    private List<Profile> profiles = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String surnames, String email, List<Profile> profiles) {
        this.id = id;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.profiles = profiles;
    }

    public User(String name, String surnames, String email, String username, String password, String img_profile, boolean status, Date register_date, List<Profile> profiles) {
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.username = username;
        this.password = password;
        this.img_profile = img_profile;
        this.status = status;
        this.register_date = register_date;
        this.profiles = profiles;
    }

    public User(Long id, String name, String surnames, String email, String username, String password, String img_profile, boolean status, Date register_date) {
        this.id = id;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.username = username;
        this.password = password;
        this.img_profile = img_profile;
        this.status = status;
        this.register_date = register_date;
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

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
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
}
