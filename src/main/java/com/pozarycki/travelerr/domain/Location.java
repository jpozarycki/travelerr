package com.pozarycki.travelerr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "location")
public class Location extends BaseEntity {

    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @java.beans.ConstructorProperties({"country", "city"})
    public Location(@NotNull String country, @NotNull String city) {
        this.country = country;
        this.city = city;
    }

    @java.beans.ConstructorProperties({"id", "country", "city"})
    public Location(Long id,@NotNull String country, @NotNull String city) {
        super.setId(id);
        this.country = country;
        this.city = city;
    }


    public Location() {
    }

    public @NotNull String getCountry() {
        return this.country;
    }

    public @NotNull String getCity() {
        return this.city;
    }

    public void setCountry(@NotNull String country) {
        this.country = country;
    }

    public void setCity(@NotNull String city) {
        this.city = city;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Location)) return false;
        final Location other = (Location) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$country = this.getCountry();
        final Object other$country = other.getCountry();
        if (this$country == null ? other$country != null : !this$country.equals(other$country)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Location;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $country = this.getCountry();
        result = result * PRIME + ($country == null ? 43 : $country.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        return result;
    }

    public String toString() {
        return "Location(country=" + this.getCountry() + ", city=" + this.getCity() + ")";
    }
}
