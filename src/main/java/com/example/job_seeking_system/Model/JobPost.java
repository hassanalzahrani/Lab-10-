package com.example.job_seeking_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class JobPost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;


    @NotEmpty(message = "title should not be empty")
    @Size(min = 5)
//    @Column(columnDefinition = " not null ")
    private String title;

@NotEmpty(message = "description should not be empty")
//@Column(columnDefinition = " not null ")
    private String description;

    @NotEmpty(message = "description should not be empty")
//    @Column(columnDefinition = " not null ")
private String location;

    @NotNull(message = "salary should not be null")
  @Positive(message = "salary should be positive number")
//    @Column(columnDefinition = " not null ")
    private int salary;
    private LocalDate postingDate;




}
