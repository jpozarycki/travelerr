package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.model.Post;

import java.util.List;

public interface PostService extends CrudService<Post, Long>{

    Post findByCity(String city);

    List<Post> findAllByCity(String city);

    Post findByCountry(String country);

    List<Post> findAllByCountry(String country);
}
