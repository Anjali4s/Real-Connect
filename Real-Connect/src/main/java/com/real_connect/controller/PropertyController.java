package com.real_connect.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.real_connect.dto.PropertyPublicDTO;
import com.real_connect.entity.Property;
import com.real_connect.mapper.PropertyMapper;
import com.real_connect.service.PropertyService;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "http://localhost:5173") 
public class PropertyController {

    @Autowired
    private PropertyService service;
    

    @PostMapping
    public ResponseEntity<Property> addProperty(@RequestBody Property property) {
        return ResponseEntity.ok(service.saveProperty(property));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getProperty(@PathVariable Long id) {
        Property prop = service.getPropertyById(id);
        return prop != null ? ResponseEntity.ok(prop) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return service.getAllProperties();
    }
    
    @GetMapping("/filter")
    public Page<Property> getProperties(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getProperties(location, minPrice, maxPrice, type, pageable);
    }
    
    @GetMapping("/public")
    public List<PropertyPublicDTO> getPublicProperties() {
        return service.getAllProperties()
            .stream()
            .map(PropertyMapper::toPublicDTO)
            .collect(Collectors.toList());
    }

    @GetMapping("/company")
    public List<Property> getCompanyProperties() {
        return service.getAllProperties(); // Full data (includes id, ownerName, contact)
    }

    
//    @GetMapping("/search")
//    public Page<Property> searchProperties(
//            @RequestParam(required = false) String location,
//            @RequestParam(required = false) String type,
//            @RequestParam(required = false) Integer minPrice,
//            @RequestParam(required = false) Integer maxPrice,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        return service.searchProperties(location, type, minPrice, maxPrice, pageable);
//    }
}












//@RestController
//@RequestMapping("/properties")
//public class PropertyController {
//
//    @Autowired
//    private PropertyService propertyService;
//
//    @PostMapping("/add")
//    public ResponseEntity<String> addProperty(@RequestBody Property property) {
//        if (property.getTitle() == null || property.getTitle().trim().isEmpty()) {
//            return ResponseEntity.badRequest().body("Title cannot be empty");
//        }
//        if (property.getPrice() <= 0) {
//            return ResponseEntity.badRequest().body("Price must be greater than zero");
//        }
//        if (property.getBroker() == null || property.getBroker().getUserId() == null) {
//            return ResponseEntity.badRequest().body("Broker ID is required");
//        }
//
//        propertyService.addProperty(property);
//        return ResponseEntity.ok("Property added successfully");
//    }
//
//    @GetMapping("/byBroker")
//    public ResponseEntity<?> getPropertiesByBroker(@RequestParam Long brokerId) {
//        if (brokerId == null || brokerId <= 0) {
//            return ResponseEntity.badRequest().body("Invalid broker ID");
//        }
//
//        User broker = new User();
//        broker.setUserId(brokerId); // Properly setting the ID
//
//        List<Property> properties = propertyService.getPropertiesByBroker(broker);
//        return ResponseEntity.ok(properties);
//    }
//
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Property>> getAllProperties() {
//        return ResponseEntity.ok(propertyService.getAllProperties());
//    }
//}