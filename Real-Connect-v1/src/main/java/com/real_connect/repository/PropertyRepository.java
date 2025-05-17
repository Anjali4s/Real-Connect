package com.real_connect.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.real_connect.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

	@Query("SELECT p FROM Property p " +
		       "WHERE (:location IS NULL OR LOWER(p.location) LIKE LOWER(CONCAT('%', :location, '%'))) " +
		       "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
		       "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
		       "AND (:type IS NULL OR LOWER(p.type) = LOWER(:type))")
		Page<Property> findByLocationAndPriceRangeAndType(
		    @Param("location") String location,
		    @Param("minPrice") Integer minPrice,
		    @Param("maxPrice") Integer maxPrice,
		    @Param("type") String type,
		    Pageable pageable
		);

	
	Page<Property> findAll(Pageable pageable);

}

