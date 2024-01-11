package com.flightmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.entity.Airport;
@Repository
public interface IAirportRepository extends JpaRepository<Airport, Long> {
	@Query(value = "select a from Airport a where a.airportId=?1")
	public Optional<?> getById(long airportId);

}
