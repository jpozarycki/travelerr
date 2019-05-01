package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.domain.dto.LocationDTO;

import java.util.Optional;

public interface LocationService extends CrudService<LocationDTO, Long> {

    Optional<LocationDTO> findByCity(String city);

    Optional<LocationDTO> findByCountry(String country);
}
