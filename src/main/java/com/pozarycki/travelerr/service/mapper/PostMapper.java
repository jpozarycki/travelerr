package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.dto.PostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends EntityMapper<PostDTO, Post>{

    default Post fromId(Long id){
        if (id==null){
            return null;
        }
        Post post = new Post();
        post.setId(id);
        return post;
    }

}
