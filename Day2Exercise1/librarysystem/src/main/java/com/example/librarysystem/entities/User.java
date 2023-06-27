package com.example.librarysystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String Address;
    @Column(unique = true)
    private String Email;
    private String PhoneNumber;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    public User(String userName, String address, String email, String phoneNumber) {
        this.userName = userName;
        Address = address;
        Email = email;
        PhoneNumber = phoneNumber;
    }
}
