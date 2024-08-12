package com.example.job_seeking_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;



//    @Column(columnDefinition = " not null ")
@NotEmpty(message = "name name should not be empty")
    @Size(min=5)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "name contain only characters (no numbers)")
    String name;
//    @Column(columnDefinition = " not null unique")

    @Email
    @NotEmpty(message = "email name should not be empty")
    private String email;


    @NotEmpty(message = "password name should not be empty")
//    @Column(columnDefinition = " not null ")
    private String password;


    @NotNull(message = "age should not be null")
//     @Column(columnDefinition = " not null  ")
    @Size(min = 22)
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "age Must be a valid number without decimals.")

     private int age;

    @NotEmpty(message = "role should not be empty ")
    @Pattern(regexp = "^(job_seeker|employer|)$")
//    @Column(columnDefinition = " check(role='job_seeker' or role= 'employer')")
    private String role;




















}
