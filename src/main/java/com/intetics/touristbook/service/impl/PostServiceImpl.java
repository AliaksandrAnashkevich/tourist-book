package com.intetics.touristbook.service.impl;

import com.intetics.touristbook.entity.Post;
import com.intetics.touristbook.exception.PostNotFoundException;
import com.intetics.touristbook.repository.PostRepository;
import com.intetics.touristbook.service.PostService;
import com.intetics.touristbook.service.dto.PostDto;
import com.intetics.touristbook.service.dto.mapper.PostMapper;
import com.intetics.touristbook.util.ConstantExceptionMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostMapper mapper;
    private final PostRepository postRepository;

    @Override
    public PostDto getById(int id) {
        Post post = postRepository.findById(id);
        if (!(post == null)) {
            return mapper.toDto(post);
        } else {
            throw new PostNotFoundException(ConstantExceptionMessage.postNotFoundExceptionMessage);
        }
    }

    @Override
    public List<PostDto> getAll() {
        return postRepository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto create(PostDto post) {
        postRepository.saveAndFlush(mapper.toEntity(post));
        return post;
    }

    @Override
    public PostDto update(PostDto post) {
        if (postRepository.existsById(post.getId())) {
            postRepository.save(mapper.toEntity(post));
        } else {
            throw new PostNotFoundException(ConstantExceptionMessage.postNotFoundExceptionMessage);
        }
        return post;
    }

    @Override
    public void delete(int id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new PostNotFoundException(ConstantExceptionMessage.postNotFoundExceptionMessage);
        }
    }

}
