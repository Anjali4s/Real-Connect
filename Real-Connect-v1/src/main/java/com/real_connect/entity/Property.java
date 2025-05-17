package com.real_connect.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private double price;
    private String ownerName;
    private String contact;
    private String type; // e.g., flat, villa
    private String offerType; // sale/rent
    private String postedDate;

    private String rooms;
    private String deposit;
    private String status;
    private int bedroom;
    private int bathroom;
    private int balcony;

    private String carpetArea;
    private String age;
    private int roomFloor;
    private int totalFloors;
    private String furnished;
    private String loan;

    @Lob
    private String description;

    // Amenities
    private boolean lifts;
    private boolean securityGuards;
    private boolean playGround;
    private boolean gardens;
    private boolean waterSupply;
    private boolean powerBackup;
    private boolean parkingArea;
    private boolean gym;
    private boolean shoppingMall;
    private boolean hospital;
    private boolean schools;
    private boolean marketArea;

    // Main & extra image URLs
    private String bigImage;
    @ElementCollection
    private List<String> smallImages;

    // Getters, setters, constructors (you can use Lombok too)
}









//@Entity
//@Table(name = "properties")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Property {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long propertyId;
//
//    @Column(nullable = false)
//    private String title;
//
//    @Column(nullable = false)
//    private Double price;
//
//    @Column(nullable = false)
//    private String type;  // e.g., "Apartment", "Commercial", "Villa"
//
//    @ManyToOne
//    @JoinColumn(name = "broker_id", nullable = false)
//    private User broker;  // Broker who owns the property
//}