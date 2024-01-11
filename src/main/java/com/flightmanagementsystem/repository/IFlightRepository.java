package com.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.entity.Flight;
@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long> {

}
