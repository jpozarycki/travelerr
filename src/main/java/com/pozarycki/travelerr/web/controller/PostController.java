package com.pozarycki.travelerr.web.controller;

import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.dto.PostDTO;
import com.pozarycki.travelerr.repository.LocationRepository;
import com.pozarycki.travelerr.repository.PostRepository;
import com.pozarycki.travelerr.repository.UserRepository;
import com.pozarycki.travelerr.service.LocationService;
import com.pozarycki.travelerr.service.PostService;
import com.pozarycki.travelerr.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {
    /**
     * todo -
     *
     * updatePost
     * deletePost
     */

    private final PostService postService;
    private final PostRepository postRepository;
    private final UserService userService;
    private final LocationService locationService;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public PostController(PostService postService, PostRepository postRepository, UserService userService, LocationService locationService, LocationRepository locationRepository, UserRepository userRepository) {
        this.postService = postService;
        this.postRepository = postRepository;
        this.userService = userService;
        this.locationService = locationService;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts() {

        List<PostDTO> postDTOList = postService.findAll();
        return new ResponseEntity<List<PostDTO>>(postDTOList, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<PostDTO>> getPostById(@PathVariable Long id) {

        Optional<PostDTO> postDTO = postService.findById(id);
        return new ResponseEntity<Optional<PostDTO>>(postDTO, HttpStatus.OK);
    }

    @GetMapping("/users/{username}/posts")
    public ResponseEntity<List<PostDTO>> getAllPostsByUsername(@PathVariable String username) {

        List<PostDTO> postDTOList = postService.findAllPostsByUser(username);
        return new ResponseEntity<List<PostDTO>>(postDTOList, HttpStatus.OK);
    }

    @GetMapping("/locations/{location}/posts")
    public ResponseEntity<List<PostDTO>> getAllPostsByLocation(@PathVariable String location) {

        List<PostDTO> postDTOListCities = postService.findAllPostsByCity(location);
        List<PostDTO> postDTOListCountries = postService.findAllPostsByCountry(location);
        List<PostDTO> postDTOListResult = new ArrayList<>();

        postDTOListResult.addAll(postDTOListCities);
        postDTOListResult.addAll(postDTOListCountries);

        return new ResponseEntity<List<PostDTO>>(postDTOListResult, HttpStatus.OK);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Void> createPost(@PathVariable Long id, @RequestBody PostDTO postDTO) {

        if(postService.findById(postDTO.getId()).isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        Post createdPost = postService.createPost(id, postDTO);
        postRepository.save(createdPost);

        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }

}
