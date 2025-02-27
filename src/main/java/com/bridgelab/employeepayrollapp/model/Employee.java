package com.bridgelab.employeepayrollapp.model;

import jakarta.persistence.*;
import lombok.*;

//Using lombok
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private double salary;
}
