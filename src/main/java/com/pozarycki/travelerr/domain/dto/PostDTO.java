package com.pozarycki.travelerr.domain.dto;

import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.PostType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDTO {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private LocationDTO locationDTO;

    @NotNull
    private String imageUrl;

    @NotNull
    private String body;

    @NotNull
    private LocalDate publishDate;

    @NotNull
    private PostType postType;

    public PostDTO(Post post) {
        this.id=post.getId();
        this.locationDTO = new LocationDTO(post.getLocation());
        this.imageUrl = post.getImageUrl();
        this.body = post.getBody();
        this.publishDate = post.getPublishDate();
        this.postType = post.getPostType();
    }

}
