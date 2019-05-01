package com.pozarycki.travelerr.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T,ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T object);

    Optional<Void> delete(T object);

    Optional<Void> deleteById(ID id);
}
