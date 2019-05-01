package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.domain.dto.PostDTO;

import java.util.List;

public interface PostService extends CrudService<PostDTO, Long>{

    List<PostDTO> findAllPostsByCity(String city);

    List<PostDTO> findAllPostsByCountry(String country);

    List<PostDTO> findAllPostsByUser(String userName);
}
