package com.Jones.Hotel_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Room")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer roomId;

    @Column(unique = true)
    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private Double roomPrice;

    @Column(name = "status")
    private Boolean roomStatus;
}
