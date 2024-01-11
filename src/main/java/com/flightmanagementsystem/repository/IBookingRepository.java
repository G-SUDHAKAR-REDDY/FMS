package com.flightmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.entity.Booking;
@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {
	
	
	@Query(value = "select b from Booking b where b.bookingId=?1")
	public Optional<?> getById(long bookingId);
	
	
}
