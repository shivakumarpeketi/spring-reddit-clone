package com.programming.techie.springredditclone.repository;

import com.programming.techie.springredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value = "select u from User u where u.username = ?1")
    User getUserByUsername(String username);

    @Query(value = "select u.email from User u where u.username = ?1", nativeQuery = true)
    String getUserEmailByUsername(String username);


    @Query(value = "select u.email from User u where u.username = :username", nativeQuery = true)
    String getUserEmailByUsernameByNamedNativeParam(@Param("username") String username);
}
