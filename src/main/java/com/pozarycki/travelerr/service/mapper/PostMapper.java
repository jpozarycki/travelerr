package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.Post;
import com.pozarycki.travelerr.domain.dto.PostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDTO postToPostDTO(Post post);

    Post postDTOToPost(PostDTO postDTO);
}
