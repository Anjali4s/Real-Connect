package com.real_connect.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.real_connect.entity.Property;
import com.real_connect.repository.PropertyRepository;


@Service
public class PropertyService {
    @Autowired
    private PropertyRepository repository;

    public Property saveProperty(Property property) {
        return repository.save(property);
    }

    public Property getPropertyById(Long id) {
        return repository.findById(id).orElseThrow();
    }
    //() -> PropertyNotFoundException("Propert with id "+id+" not found!!")
	public List<Property> getAllProperties() {
        return repository.findAll();
    }
    
    public Page<Property> getProperties(String location, Integer minPrice, Integer maxPrice, String type, Pageable pageable) {

        boolean noFilter = !StringUtils.hasText(location) && minPrice == null && maxPrice == null && !StringUtils.hasText(type);

        if (noFilter) {
            // No filter applied — return all properties paginated
            return repository.findAll(pageable);
        } else {
            // At least one filter applied — return filtered properties
            return repository.findByLocationAndPriceRangeAndType(location, minPrice, maxPrice, type, pageable);
        }
    }
    
//    public Page<Property> searchProperties(String location, String propertyType, Integer minPrice, Integer maxPrice, Pageable pageable) {
//        return repository.findByFilters(location, propertyType, minPrice, maxPrice, pageable);
//    }
}











//@Service
//public class PropertyService {
//
//    @Autowired
//    private PropertyRepository propertyRepository;
//
//    public Property addProperty(Property property) {
//        return propertyRepository.save(property);
//    }
//
//    public List<Property> getPropertiesByBroker(User broker) {
//        return propertyRepository.findByBroker(broker);
//    }
//
//    public List<Property> getAllProperties() {
//        return propertyRepository.findAll();
//    }
//}
