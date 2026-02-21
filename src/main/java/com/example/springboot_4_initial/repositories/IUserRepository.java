package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.status = :status")
    public abstract List<User> list_users_by_status(@Param("status") boolean status);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public abstract Optional<User> get_user_by_email(@Param("email") String email);
}
