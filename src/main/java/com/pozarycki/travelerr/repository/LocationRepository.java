package com.pozarycki.travelerr.repository;

import com.pozarycki.travelerr.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findByCity (String cityName);

    Optional<Location> findByCountry (String countryName);

}
