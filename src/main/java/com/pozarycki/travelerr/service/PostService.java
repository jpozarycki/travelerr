package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.domain.dto.PostDTO;

import java.util.List;

public interface PostService extends CrudService<PostDTO, Long>{

    PostDTO findPostByCity(String city);

    List<PostDTO> findAllPostsByCity(String city);

    PostDTO findPostByCountry(String country);

    List<PostDTO> findAllPostsByCountry(String country);

    PostDTO findPostByUser(String userName);

    List<PostDTO> findAllPostsByUser(String userName);
}
