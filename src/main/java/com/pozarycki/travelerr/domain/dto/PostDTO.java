package com.pozarycki.travelerr.domain.dto;

import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.PostType;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    public PostDTO(){}

    public PostDTO(Post post) {
        this.id=post.getId();
        this.locationDTO = new LocationDTO(post.getLocation());
        this.imageUrl = post.getImageUrl();
        this.body = post.getBody();
        this.publishDate = post.getPublishDate();
        this.postType = post.getPostType();
    }

    public Long getId() {
        return this.id;
    }

    public @NotNull String getTitle() {
        return this.title;
    }

    public @NotNull LocationDTO getLocationDTO() {
        return this.locationDTO;
    }

    public @NotNull String getImageUrl() {
        return this.imageUrl;
    }

    public @NotNull String getBody() {
        return this.body;
    }

    public @NotNull LocalDate getPublishDate() {
        return this.publishDate;
    }

    public @NotNull PostType getPostType() {
        return this.postType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public void setLocationDTO(@NotNull LocationDTO locationDTO) {
        this.locationDTO = locationDTO;
    }

    public void setImageUrl(@NotNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setBody(@NotNull String body) {
        this.body = body;
    }

    public void setPublishDate(@NotNull LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setPostType(@NotNull PostType postType) {
        this.postType = postType;
    }

    public String toString() {
        return "PostDTO(id=" + this.getId() + ", title=" + this.getTitle() + ", locationDTO=" + this.getLocationDTO() + ", imageUrl=" + this.getImageUrl() + ", body=" + this.getBody() + ", publishDate=" + this.getPublishDate() + ", postType=" + this.getPostType() + ")";
    }
}
