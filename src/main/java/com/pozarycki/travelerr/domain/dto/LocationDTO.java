package com.pozarycki.travelerr.domain.dto;

import com.pozarycki.travelerr.domain.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LocationDTO {

    private Long id;

    @NotNull
    private String country;

    @NotNull
    private String city;

    public LocationDTO(Location location){

        this.id=location.getId();
        this.country=location.getCountry();
        this.city=location.getCity();
    }
}
