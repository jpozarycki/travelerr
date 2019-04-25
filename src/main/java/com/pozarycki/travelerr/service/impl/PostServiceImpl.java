package com.pozarycki.travelerr.service.impl;

import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {


    @Override
    public Set<Post> findAll() {
        return null;
    }

    @Override
    public Post findById(Long aLong) {
        return null;
    }

    @Override
    public Post save(Post object) {
        return null;
    }

    @Override
    public void delete(Post object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Post findPostByCity(String city) {
        return null;
    }

    @Override
    public List<Post> findAllPostsByCity(String city) {
        return null;
    }

    @Override
    public Post findPostByCountry(String country) {
        return null;
    }

    @Override
    public List<Post> findAllPostsByCountry(String country) {
        return null;
    }

    @Override
    public Post findPostByUser(String userName) {
        return null;
    }

    @Override
    public List<Post> findAllPostsByUser(String userName) {
        return null;
    }
}
