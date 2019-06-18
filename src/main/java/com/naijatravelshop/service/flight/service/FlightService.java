package com.naijatravelshop.service.flight.service;

import com.naijatravelshop.service.flight.pojo.request.ReservationRequestDTO;
import com.naijatravelshop.service.flight.pojo.request.VisaRequestDTO;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;

public interface FlightService {

    ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO);

    ReservationResponseDTO createVisaRequest(VisaRequestDTO visaRequestDTO);

}
