package com.AK.Hotel_Management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

    @Id
    private Integer roomId;
    @Column(unique = true)
    private Integer roomNo;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private Double roomPrice;
    private Boolean roomAvailableStatus;


}
