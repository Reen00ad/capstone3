package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor



public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "It must not be empty")
  @Column(columnDefinition = " varchar(40) not null ")
    private String district ;

    @NotEmpty(message = "It must not be empty")
    @Column(columnDefinition = " varchar(40) not null ")
    private String street ;


    private Double evaluation;
    private Double rating;
    private Integer numberOrder;

    @ManyToOne
    @JoinColumn(name = "laundry_id", referencedColumnName = "id")
    @JsonIgnore
    private Laundry laundry;



    @OneToMany(cascade = CascadeType.ALL , mappedBy = "branch")
    private Set<ServiceLaundry> serviceLaundries;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "branch1")
    private Set<Orders> orders;
}
