package com.pozarycki.travelerr.service.impl;

import com.pozarycki.travelerr.domain.dto.LocationDTO;
import com.pozarycki.travelerr.domain.dto.PostDTO;
import com.pozarycki.travelerr.repository.PostRepository;
import com.pozarycki.travelerr.service.PostService;
import com.pozarycki.travelerr.service.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDTO findPostByCity(String city) {
        return null;
    }

    @Override
    public List<PostDTO> findAllPostsByCity(String city) {
        return null;
    }

    @Override
    public PostDTO findPostByCountry(String country) {
        return null;
    }

    @Override
    public List<PostDTO> findAllPostsByCountry(String country) {
        return null;
    }

    @Override
    public PostDTO findPostByUser(String userName) {
        return null;
    }

    @Override
    public List<PostDTO> findAllPostsByUser(String userName) {
        return null;
    }

    @Override
    public List<PostDTO> findAll() {
        return null;
    }

    @Override
    public Optional<LocationDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public PostDTO save(PostDTO object) {
        return null;
    }

    @Override
    public void delete(PostDTO object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}



