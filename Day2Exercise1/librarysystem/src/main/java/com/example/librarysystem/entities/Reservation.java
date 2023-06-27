package com.example.librarysystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    private Date ReservationDate;
    private Date ReturnDate;
    private String Status;
    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_Id", nullable = false)
    private Book book;
}
