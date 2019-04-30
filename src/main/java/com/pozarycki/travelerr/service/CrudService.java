package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.domain.dto.LocationDTO;

import java.util.List;
import java.util.Optional;

public interface CrudService<T,ID> {

    List<T> findAll();

    Optional<LocationDTO> findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
