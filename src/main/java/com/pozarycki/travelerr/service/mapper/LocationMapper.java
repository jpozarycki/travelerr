package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.Location;
import com.pozarycki.travelerr.domain.dto.LocationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationDTO locationToLocationDTO(Location location);

    Location locationDTOToLocation(LocationDTO locationDTO);
}
