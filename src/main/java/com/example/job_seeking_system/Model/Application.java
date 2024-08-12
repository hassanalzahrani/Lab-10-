package com.example.job_seeking_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Application {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;



    //    @Column(columnDefinition = " not null ")
    @NotNull(message = "user ID should not be empty")
    private Integer userID;

    //    @Column(columnDefinition = " not null ")
    @NotNull(message = "post ID should not be empty")
    private Integer postID;


}
