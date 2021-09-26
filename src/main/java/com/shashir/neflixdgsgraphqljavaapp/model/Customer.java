package com.shashir.neflixdgsgraphqljavaapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "CUSTOMER_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customerNumber;
    private String name;
    private String gender;
    private Long contact;
    private String mail;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;
}
