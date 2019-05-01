package com.pozarycki.travelerr.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table (name = "post")
public class Post extends BaseEntity {

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "location_id")
    @Column(name = "location", nullable = false)
    private Location location;

    @NotNull
    @Column(name = "image_url")
    private String imageUrl;

    @NotNull
    @Column(name = "body", nullable = false)
    private String body;

    @NotNull
    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "post_type", nullable = false)
    private PostType postType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {
    }

    @java.beans.ConstructorProperties({"title", "location", "imageUrl", "body", "publishDate", "postType", "user"})
    public Post(@NotNull String title, @NotNull Location location, @NotNull String imageUrl, @NotNull String body, @NotNull LocalDate publishDate, @NotNull PostType postType, @NotNull User user) {
        this.title = title;
        this.location = location;
        this.imageUrl = imageUrl;
        this.body = body;
        this.publishDate = publishDate;
        this.postType = postType;
        this.user = user;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Post;
    }

    public @NotNull String getTitle() {
        return this.title;
    }

    public @NotNull Location getLocation() {
        return this.location;
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

    public @NotNull User getUser() {
        return this.user;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public void setLocation(@NotNull Location location) {
        this.location = location;
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

    public void setUser(@NotNull User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Post)) return false;
        final Post other = (Post) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$location = this.getLocation();
        final Object other$location = other.getLocation();
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) return false;
        final Object this$imageUrl = this.getImageUrl();
        final Object other$imageUrl = other.getImageUrl();
        if (this$imageUrl == null ? other$imageUrl != null : !this$imageUrl.equals(other$imageUrl)) return false;
        final Object this$body = this.getBody();
        final Object other$body = other.getBody();
        if (this$body == null ? other$body != null : !this$body.equals(other$body)) return false;
        final Object this$publishDate = this.getPublishDate();
        final Object other$publishDate = other.getPublishDate();
        if (this$publishDate == null ? other$publishDate != null : !this$publishDate.equals(other$publishDate))
            return false;
        final Object this$postType = this.getPostType();
        final Object other$postType = other.getPostType();
        if (this$postType == null ? other$postType != null : !this$postType.equals(other$postType)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $location = this.getLocation();
        result = result * PRIME + ($location == null ? 43 : $location.hashCode());
        final Object $imageUrl = this.getImageUrl();
        result = result * PRIME + ($imageUrl == null ? 43 : $imageUrl.hashCode());
        final Object $body = this.getBody();
        result = result * PRIME + ($body == null ? 43 : $body.hashCode());
        final Object $publishDate = this.getPublishDate();
        result = result * PRIME + ($publishDate == null ? 43 : $publishDate.hashCode());
        final Object $postType = this.getPostType();
        result = result * PRIME + ($postType == null ? 43 : $postType.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Post(title=" + this.getTitle() + ", location=" + this.getLocation() + ", imageUrl=" + this.getImageUrl() + ", body=" + this.getBody() + ", publishDate=" + this.getPublishDate() + ", postType=" + this.getPostType() + ", user=" + this.getUser() + ")";
    }
}
