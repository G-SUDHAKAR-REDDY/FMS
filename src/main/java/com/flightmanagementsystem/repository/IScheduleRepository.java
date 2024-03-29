package com.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.entity.Schedule;
@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long> {

}
