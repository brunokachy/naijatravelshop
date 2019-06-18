package com.naijatravelshop.persistence.service.impl;

import com.naijatravelshop.persistence.model.hotel.Location;
import com.naijatravelshop.persistence.repository.hotel.LocationRepository;
import com.naijatravelshop.persistence.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bruno on
 * 08/05/2019
 */
@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getLocationsByRegion(String region) {
        return locationRepository.getAllByRegionLike(region);
    }
}
