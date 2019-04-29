package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.Location;
import com.pozarycki.travelerr.domain.dto.LocationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper extends EntityMapper<LocationDTO, Location>{

//    LocationDTO locationToLocationDTO(Location location);
//
//    Location locationDTOToLocation(LocationDTO locationDTO);

    default Location fromId(Long id){
        if (id==null) {
            return null;
        }
        Location location = new Location();
        location.setId(id);
        return location;

    }
}
