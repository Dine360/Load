package com.liveasy.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liveasy.api.model.Load;

@Repository
public interface LoadRepository extends JpaRepository<Load, Integer>{
	List<Load> findByShipperId(UUID shippingId);

}
