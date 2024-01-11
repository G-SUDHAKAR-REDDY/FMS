package com.flightmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.entity.Client;
@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
	
	@Query(value = "select c from Client c where c.clientName=?1")
	public Optional<?> getClientByName(String clientName);

	
	@Query(value = "select c2 from Client c2 where c2.clientName=?1")
	public Optional<Client> getClientByClientname(String clientName);


}
