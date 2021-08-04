package com.intetics.touristbook.service;

import com.intetics.touristbook.service.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    PostDto getById(int id);

    List<PostDto> getAll();

    PostDto create(PostDto post);

    PostDto update(PostDto post);

    void delete(int id);

}
