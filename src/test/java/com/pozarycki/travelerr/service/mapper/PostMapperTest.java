package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.Location;
import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.PostType;
import com.pozarycki.travelerr.domain.dto.PostDTO;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostMapperTest {

    private static final Long DEFAULT_ID = 1L;
    private static final String DEFAULT_TITLE = "default title";
    private static final Location DEFAULT_LOCATION = new Location(DEFAULT_ID,"country", "city");
    private static final String DEFAULT_IMAGE_URL = "http://www.imageurl.com";
    private static final String DEFAULT_BODY = "default body";
    private static final LocalDate DEFAULT_PUBLISH_DATE = LocalDate.now();
    private static final PostType DEFAULT_POST_TYPE = PostType.DEFAULT;

    private PostMapper postMapper = Mappers.getMapper(PostMapper.class);

    private Post post;
    private PostDTO postDTO;

    @Before
    public void setUp() throws Exception {
        post = new Post();
        post.setId(DEFAULT_ID);
        post.setBody(DEFAULT_BODY);
        post.setTitle(DEFAULT_TITLE);
        post.setImageUrl(DEFAULT_IMAGE_URL);
        post.setPostType(DEFAULT_POST_TYPE);
        post.setPublishDate(DEFAULT_PUBLISH_DATE);
        post.setLocation(DEFAULT_LOCATION);

        postDTO = new PostDTO(post);
    }

    @Test
    public void postToPostDTOTest() throws Exception {
        PostDTO postDTOTest = postMapper.toDto(post);
        
        assertEquals(DEFAULT_ID, postDTOTest.getId());
        assertEquals(DEFAULT_BODY, postDTOTest.getBody());
        assertEquals(DEFAULT_IMAGE_URL, postDTOTest.getImageUrl());
        assertEquals(DEFAULT_LOCATION.getId(), postDTOTest.getLocationDTO().getId());
        assertEquals(DEFAULT_LOCATION.getCountry(), postDTOTest.getLocationDTO().getCountry());
        assertEquals(DEFAULT_LOCATION.getCity(), postDTOTest.getLocationDTO().getCity());
        assertEquals(DEFAULT_POST_TYPE, postDTOTest.getPostType());
        assertEquals(DEFAULT_TITLE, postDTOTest.getTitle());
        assertEquals(DEFAULT_PUBLISH_DATE, postDTOTest.getPublishDate());
    }
    @Test
    public void postDTOToPostTest() throws Exception {
        Post postTest = postMapper.toEntity(postDTO);
        
        assertEquals(DEFAULT_ID, postTest.getId());
        assertEquals(DEFAULT_BODY, postTest.getBody());
        assertEquals(DEFAULT_IMAGE_URL, postTest.getImageUrl());
        assertEquals(DEFAULT_LOCATION, postTest.getLocation());
        assertEquals(DEFAULT_POST_TYPE, postTest.getPostType());
        assertEquals(DEFAULT_TITLE, postTest.getTitle());
        assertEquals(DEFAULT_PUBLISH_DATE, postTest.getPublishDate());
    }

    @Test
    public void postListToPostDTOListTest() throws Exception {
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());

        List<PostDTO> postDTOS = postMapper.toDto(posts);

        assertEquals(postDTOS.size(), posts.size());
        assertEquals(posts.get(0).getBody(),postDTOS.get(0).getBody());
        assertEquals(posts.get(0).getImageUrl(),postDTOS.get(0).getImageUrl());
        assertEquals(posts.get(0).getPostType(),postDTOS.get(0).getPostType());
        assertEquals(posts.get(0).getPublishDate(),postDTOS.get(0).getPublishDate());
        assertEquals(posts.get(0).getTitle(),postDTOS.get(0).getTitle());
        assertEquals(posts.get(0).getLocation().getId(),postDTOS.get(0).getLocationDTO().getId());
    }

    @Test
    public void postDTOListToPostListTest() throws Exception {
        List<PostDTO> postDTOS = new ArrayList<>();
        postDTOS.add(postMapper.toDto(post));
        postDTOS.add(new PostDTO());
        postDTOS.add(new PostDTO());
        postDTOS.add(new PostDTO());
        postDTOS.add(new PostDTO());

        List<Post> posts = postMapper.toEntity(postDTOS);

        assertEquals(postDTOS.size(), posts.size());
        assertEquals(posts.get(0).getBody(),postDTOS.get(0).getBody());
        assertEquals(posts.get(0).getImageUrl(),postDTOS.get(0).getImageUrl());
        assertEquals(posts.get(0).getPostType(),postDTOS.get(0).getPostType());
        assertEquals(posts.get(0).getPublishDate(),postDTOS.get(0).getPublishDate());
        assertEquals(posts.get(0).getTitle(),postDTOS.get(0).getTitle());
        assertEquals(posts.get(0).getLocation().getId(),postDTOS.get(0).getLocationDTO().getId());
    }

    @Test
    public void fromIdTest() throws Exception{
        assertEquals(postMapper.fromId(DEFAULT_ID).getId(),DEFAULT_ID);
    }
}
