package com.pozarycki.travelerr.domain.dto;

import com.pozarycki.travelerr.domain.Location;

import javax.validation.constraints.NotNull;

public class LocationDTO {

    private Long id;

    @NotNull
    private String country;

    @NotNull
    private String city;

    public LocationDTO(){}

    public LocationDTO(Location location){

        this.id=location.getId();
        this.country=location.getCountry();
        this.city=location.getCity();
    }

    public Long getId() {
        return this.id;
    }

    public @NotNull String getCountry() {
        return this.country;
    }

    public @NotNull String getCity() {
        return this.city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(@NotNull String country) {
        this.country = country;
    }

    public void setCity(@NotNull String city) {
        this.city = city;
    }

    public String toString() {
        return "LocationDTO(id=" + this.getId() + ", country=" + this.getCountry() + ", city=" + this.getCity() + ")";
    }
}
