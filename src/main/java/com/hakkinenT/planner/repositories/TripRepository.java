package com.hakkinenT.planner.repositories;

import com.hakkinenT.planner.entities.trips.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
}
