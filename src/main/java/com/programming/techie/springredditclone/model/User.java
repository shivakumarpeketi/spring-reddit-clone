package com.programming.techie.springredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
/*@Table(name="tbl_user", uniqueConstraints = {
        @UniqueConstraint(name = "username_unique", columnNames = "username"),
        @UniqueConstraint(name = "username_unique", columnNames = "username")
})*/
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
//    @SequenceGenerator(name = "User_Sequencer", allocationSize = 1)
    private Long userId;
    @NotBlank(message = "Username is required")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    private Instant created;
    private boolean enabled;
}
