package com.example.invoicing.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Client")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String billing_address;
}
