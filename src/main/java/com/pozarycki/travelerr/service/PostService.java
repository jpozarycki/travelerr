package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.model.Post;

import java.util.List;

public interface PostService extends CrudService<Post, Long>{

    Post findPostByCity(String city);

    List<Post> findAllPostsByCity(String city);

    Post findPostByCountry(String country);

    List<Post> findAllPostsByCountry(String country);

    Post findPostByUser(String userName);

    List<Post> findAllPostsByUser(String userName);
}
