package com.real_connect.dto;

import java.util.List;
import lombok.Data;

@Data
public class PropertyPublicDTO {
	private Long id;
	private String name;
    private String location;
    private double price;
    private String type;
    private String offerType;
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

    private String bigImage;
    private List<String> smallImages;
}
