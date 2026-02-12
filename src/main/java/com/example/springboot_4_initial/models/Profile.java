package com.example.springboot_4_initial.models;

import jakarta.persistence.*;

@Entity()
@Table(name = "tbl_profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String profile;
    boolean status;

    public Profile() {
    }

    public Profile(String profile, boolean status) {
        this.profile = profile;
        this.status = status;
    }

    public Profile(Long id, String profile, boolean status) {
        this.id = id;
        this.profile = profile;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
