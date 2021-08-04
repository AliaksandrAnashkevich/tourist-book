package com.intetics.touristbook.service.dto.mapper;

import com.intetics.touristbook.entity.Post;
import com.intetics.touristbook.service.dto.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PostMapper {

    private final ModelMapper mapper;

    public PostMapper() {
        this.mapper = new ModelMapper();
    }

    public Post toEntity(PostDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Post.class);
    }

    public PostDto toDto(Post entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, PostDto.class);
    }
}
