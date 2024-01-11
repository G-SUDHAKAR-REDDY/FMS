package com.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.entity.ScheduledFlight;
@Repository
public interface IScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {

}
