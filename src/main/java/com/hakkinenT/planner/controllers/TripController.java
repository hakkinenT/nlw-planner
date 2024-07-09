package com.hakkinenT.planner.controllers;

import com.hakkinenT.planner.entities.participant.ParticipantService;
import com.hakkinenT.planner.entities.trips.Trip;
import com.hakkinenT.planner.entities.trips.TripCreateResponse;
import com.hakkinenT.planner.entities.trips.TripRequestPayload;
import com.hakkinenT.planner.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private ParticipantService participantService;

    @Autowired
    private TripRepository repository;

    @PostMapping
    public ResponseEntity<TripCreateResponse> createTrip(@RequestBody TripRequestPayload payload){
        Trip newTrip = new Trip(payload);

        repository.save(newTrip);
        participantService.registerParticipantsToTrip(payload.emails_to_invite());

        return ResponseEntity.ok(new TripCreateResponse(newTrip.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripDetails(@PathVariable UUID id){
        Optional<Trip> trip = repository.findById(id);

        return trip.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
