package com.app.hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_hotel")
@ToString
public class Hotel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hotelId;
    private String hotelName;
    private String description;
}
