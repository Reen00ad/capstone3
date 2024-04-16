package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Laundry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "varchar(15) not null ")
    private String name;
    @NotEmpty(message = "commercialRegistertion should not be empty")
    @Column(columnDefinition = "varchar(10) not null ")
    private String commercialRegistertion;
    @NotEmpty(message = "phone number cannot be null")
    @Size(min = 10,max = 10,message = "phone number must be 10 digit")
    @Column(columnDefinition = "varchar(10) not null ")
    private String phoneNumber;
    @Email
    @NotEmpty(message = "email should not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
}
