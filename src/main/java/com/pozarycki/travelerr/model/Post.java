package com.pozarycki.travelerr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table (name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {

    private String city;
    private String country;
    private String imageUrl;
    private String text;
    private LocalDate publishDate;
}
