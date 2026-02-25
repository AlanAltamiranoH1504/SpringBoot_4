package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT p FROM Profile p WHERE p.status = :status")
    public abstract List<Profile> list_profiles(@Param("status") boolean status);

    @Query("SELECT p FROM Profile p WHERE p.profile = :name_profile")
    public abstract Profile get_profile_by_name(@Param("name_profile") String name_profile);
}
