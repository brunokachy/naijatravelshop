package com.naijatravelshop.persistence.service;

import com.naijatravelshop.persistence.model.hotel.Location;

import java.util.List;

public interface LocationService {

    List<Location> getLocationsByRegion(String region);
}
