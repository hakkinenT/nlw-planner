package com.hakkinenT.planner.entities.participant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {
    public void registerParticipantsToTrip(List<String> participantToInvite){}

    public void triggerConfirmationEmailToParticipant(UUID tripId){}
}
