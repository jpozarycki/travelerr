package com.pozarycki.travelerr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table (name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

    @NotNull
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @NotNull
    @Column(name = "body", nullable = false)
    private String body;

    @NotNull
    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;
}
