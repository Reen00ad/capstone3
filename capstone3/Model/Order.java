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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer laundryId;

    private Integer customerId;

    // ايجكت الخدمة
    @ManyToMany
    @JsonIgnore
    private Set<ServiceLaundry> serviceLaundries;

     @Column(columnDefinition = "double")
     @NotNull
    private double deliveryPrice;

    @Column(columnDefinition = "double")
    @NotNull
    private double totalPrice;


    //@Column(columnDefinition = "varchar(10) not null ")
    // @Column(columnDefinition = "varchar(8) not null")
    private String nationalAddress;
    private String district;
    private String street;

    @NotNull(message = "rating should not be empty")
    @Column(columnDefinition = "int not null ")
    private Integer rating;

    @NotEmpty(message = "comment should not be empty")
     @Column(columnDefinition = "varchar(30) not null ")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    @JsonIgnore
    private Driver driver;






}
