package com.pozarycki.travelerr.service.impl;

import com.pozarycki.travelerr.domain.Location;
import com.pozarycki.travelerr.domain.dto.LocationDTO;
import com.pozarycki.travelerr.repository.LocationRepository;
import com.pozarycki.travelerr.service.LocationService;
import com.pozarycki.travelerr.service.mapper.LocationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }


    @Override
    public List<LocationDTO> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LocationDTO> findById(Long aLong) {
        return locationRepository.findById(aLong)
                .map(locationMapper::toDto);
    }

    @Override
    public LocationDTO save(LocationDTO object) {
        Location locationSaved = locationMapper.toEntity(object);
        locationRepository.save(locationSaved);
        return locationMapper.toDto(locationSaved);
    }

    @Override
    public Optional<Void> delete(LocationDTO object) {
        locationRepository.delete(
                locationMapper.toEntity(object)
        );
        return Optional.empty();
    }

    @Override
    public Optional<Void> deleteById(Long aLong) {
        locationRepository.deleteById(aLong);
        return Optional.empty();
    }

    @Override
    public Optional<LocationDTO> findByCity(String city) {
        return locationRepository.findByCity(city)
                .map(locationMapper::toDto);
    }

    @Override
    public Optional<LocationDTO> findByCountry(String country) {
        return locationRepository.findByCountry(country)
                .map(locationMapper::toDto);
    }
}
