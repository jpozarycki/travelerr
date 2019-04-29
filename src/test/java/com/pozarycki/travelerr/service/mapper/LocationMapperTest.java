package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.Location;
import com.pozarycki.travelerr.domain.dto.LocationDTO;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class LocationMapperTest {

    private static final String DEFAULT_CITY_NAME = "some city";
    private static final String DEFAULT_COUNTRY_NAME = "some country";
    private static final Long DEFAULT_ID = 1L;

    private LocationMapper locationMapper = Mappers.getMapper(LocationMapper.class);

    private Location location;
    private LocationDTO locationDTO;

    @Before
    public void setUp() throws Exception {
        location = new Location();
        location.setId(DEFAULT_ID);
        location.setCity(DEFAULT_CITY_NAME);
        location.setCountry(DEFAULT_COUNTRY_NAME);

        locationDTO = new LocationDTO(location);

    }

    @Test
    public void locationToLocationDTOTest() throws Exception {

        LocationDTO locationDTOTest = locationMapper.toDto(location);

        assertEquals(DEFAULT_CITY_NAME, locationDTOTest.getCity());
        assertEquals(DEFAULT_COUNTRY_NAME, locationDTOTest.getCountry());
        assertEquals(DEFAULT_ID, locationDTOTest.getId());
    }

    @Test
    public void locationListToLocationDTOListTest() throws Exception {
        List<Location> locations = new ArrayList<>();
        locations.add(location);
        locations.add(new Location());
        locations.add(new Location());
        locations.add(new Location());

        List<LocationDTO> locationDTOS = locationMapper.toDto(locations);

        assertEquals(locations.size(), locationDTOS.size());
        assertEquals(locations.get(DEFAULT_ID.intValue()).getCity(), locationDTOS.get(DEFAULT_ID.intValue()).getCity());
    }

    @Test
    public void locationDTOToLocationTest() throws Exception {
        Location locationTest = locationMapper.toEntity(locationDTO);

        assertEquals(DEFAULT_CITY_NAME, locationTest.getCity());
        assertEquals(DEFAULT_COUNTRY_NAME, locationTest.getCountry());
        assertEquals(DEFAULT_ID, locationTest.getId());
    }

    @Test
    public void locationDTOListToLocationListTest() throws Exception {
        List<LocationDTO> locationDTOS = new ArrayList<>();
        locationDTOS.add(locationDTO);
        locationDTOS.add(new LocationDTO());
        locationDTOS.add(new LocationDTO());
        locationDTOS.add(new LocationDTO());
        locationDTOS.add(new LocationDTO());

        List<Location> locations = locationMapper.toEntity(locationDTOS);

        assertEquals(locationDTOS.size(), locations.size());
        assertEquals(locationDTOS.get(DEFAULT_ID.intValue()).getCity(), locations.get(DEFAULT_ID.intValue()).getCity());
        assertEquals(locationDTOS.get(DEFAULT_ID.intValue()).getCountry(), locations.get(DEFAULT_ID.intValue()).getCountry());
    }

    @Test
    public void fromIdTest() throws Exception {
        assertEquals(locationMapper.fromId(DEFAULT_ID).getId(), DEFAULT_ID);
    }
}
