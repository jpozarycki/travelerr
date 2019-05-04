package com.pozarycki.travelerr.bootstrap;

import com.pozarycki.travelerr.domain.Location;
import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.PostType;
import com.pozarycki.travelerr.domain.User;
import com.pozarycki.travelerr.repository.LocationRepository;
import com.pozarycki.travelerr.repository.PostRepository;
import com.pozarycki.travelerr.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class Bootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LocationRepository locationRepository;

    public Bootstrap(UserRepository userRepository, PostRepository postRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (postRepository.count() == 0) {
            initData();
        }

    }

    private void initData() {

        /**
         *  Create users
         */

        User user1 = User.builder()
                .userName("SanFranciscoFan")
                .description("I love San Francisco")
                .email("sanfrancisco@email.com")
                .firstName("John")
                .lastName("Doe")
                .password("password")
                .build();

        userRepository.save(user1);

        User user2 = User.builder()
                .userName("LosAngelesFan")
                .description("I love Los Angeles")
                .email("losangeles@email.com")
                .firstName("James")
                .lastName("Doe")
                .password("password")
                .build();

        userRepository.save(user2);

        /**
         *  Create locations
         */

        Location location1 = Location.builder()
                .country("The United States of America")
                .city("San Francisco")
                .build();

        locationRepository.save(location1);

        Location location2 = Location.builder()
                .country("The United States of America")
                .city("Los Angeles")
                .build();

        locationRepository.save(location2);

        /**
         *  Create posts
         */

        Post post1 = Post.builder()
                .title("My vacation in Los Angeles")
                .body("I was on vacation in Los Angeles. I loved it! Chilled out a lot")
                .location(location2)
                .publishDate(LocalDate.now())
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Los_Angeles%2C_Winter_2016.jpg/1200px-Los_Angeles%2C_Winter_2016.jpg")
                .postType(PostType.CHILLOUT)
                .user(user2)
                .build();

        postRepository.save(post1);

        Post post2 = Post.builder()
                .title("My vacation in San Francisco")
                .body("I was on vacation in San Francisco. I loved it! Partied a lot")
                .location(location2)
                .publishDate(LocalDate.now())
                .imageUrl("https://wonderfulengineering.com/wp-content/uploads/2015/05/San-Francisco-Wallpaper-4-800x500.jpg")
                .postType(PostType.PARTY)
                .user(user2)
                .build();

        postRepository.save(post2);

        saveUserPosts(user1, post1);
        saveUserPosts(user2, post2);

        saveLocationPosts(location1, post1);
        saveLocationPosts(location2, post2);

    }

    private void saveUserPosts(User user, Post post){
        user.setPosts(Collections.singletonList(post));
    }

    private void saveLocationPosts(Location location, Post post){
        location.setPosts(Collections.singletonList(post));
    }
}
