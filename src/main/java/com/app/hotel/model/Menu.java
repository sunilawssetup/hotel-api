package com.app.hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name="tbl_menue")
@ToString
public class Menu extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menueId;
    private String name;
    private String description;
    private Double price;
    private boolean type;
    private Long hotelId;

}
