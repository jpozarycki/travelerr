package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.dto.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper extends EntityMapper<PostDTO, Post>{

    @Override
    @Mapping(source = "locationDTO", target = "location")
    Post toEntity(PostDTO dto);

    @Override
    @Mapping(source = "location", target = "locationDTO")
    PostDTO toDto(Post entity);

    default Post fromId(Long id){
        if (id==null){
            return null;
        }
        Post post = new Post();
        post.setId(id);
        return post;
    }

}
