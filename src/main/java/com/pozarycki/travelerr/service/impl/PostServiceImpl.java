package com.pozarycki.travelerr.service.impl;

import com.pozarycki.travelerr.domain.Location;
import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.dto.PostDTO;
import com.pozarycki.travelerr.repository.LocationRepository;
import com.pozarycki.travelerr.repository.PostRepository;
import com.pozarycki.travelerr.repository.UserRepository;
import com.pozarycki.travelerr.service.PostService;
import com.pozarycki.travelerr.service.mapper.LocationMapper;
import com.pozarycki.travelerr.service.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper, LocationRepository locationRepository, LocationMapper locationMapper, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
        this.userRepository = userRepository;
    }


    @Override
    public List<PostDTO> findAll() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PostDTO> findById(Long aLong) {
        return postRepository.findById(aLong)
                .map(postMapper::toDto);
    }

    @Override
    public PostDTO save(PostDTO object) {
        Post postSaved = postMapper.toEntity(object);
        postRepository.save(postSaved);
        return postMapper.toDto(postSaved);
    }

    @Override
    public Optional<Void> delete(PostDTO object) {
        postRepository.delete(postMapper.toEntity(object));
        return Optional.empty();
    }

    @Override
    public Optional<Void> deleteById(Long aLong) {
        postRepository.deleteById(aLong);
        return Optional.empty();
    }

    @Override
    public List<PostDTO> findAllPostsByCity(String city) {
        return  locationRepository.findByCity(city)
                .get()
                .getPosts()
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> findAllPostsByCountry(String country) {
        return locationRepository.findByCountry(country)
                .get()
                .getPosts()
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> findAllPostsByUser(String userName) {
        return userRepository.findOneByUserName(userName)
                .get()
                .getPosts()
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Post createPost(Long userId, PostDTO postDTO) {
        Post createdPost = postMapper.toEntity(postDTO);

        if(!locationRepository.findByCity(postDTO.getLocationDTO().getCity()).isPresent()) {
            Location location = Location.builder()
                    .city(postDTO.getLocationDTO().getCity())
                    .country(postDTO.getLocationDTO().getCity())
                    .build();
            locationRepository.save(location);
        }

        if(!locationRepository.findByCountry(postDTO.getLocationDTO().getCountry()).isPresent()) {
            Location location = Location.builder()
                    .city(postDTO.getLocationDTO().getCity())
                    .country(postDTO.getLocationDTO().getCity())
                    .build();
            locationRepository.save(location);
        } else {
            locationRepository.findByCity(postDTO.getLocationDTO().getCity()).get()
                    .setPosts(Collections.singletonList(createdPost));
            userRepository.findById(userId).get()
                    .setPosts(Collections.singletonList(createdPost));
        }

        return createdPost;
    }
}



