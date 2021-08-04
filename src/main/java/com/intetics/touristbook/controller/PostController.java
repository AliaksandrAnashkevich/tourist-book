package com.intetics.touristbook.controller;

import com.intetics.touristbook.exception.IncorrectDataException;
import com.intetics.touristbook.exception.LocationNotFoundException;
import com.intetics.touristbook.exception.PostNotFoundException;
import com.intetics.touristbook.service.PostService;
import com.intetics.touristbook.service.dto.PostDto;
import com.intetics.touristbook.util.JsonGenerator;
import com.intetics.touristbook.util.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {


    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> allPosts() {
        return postService.getAll();
    }

    @GetMapping("/posts/{id}")
    public PostDto getPost(@PathVariable int id) throws PostNotFoundException {
        return postService.getById(id);
    }

    @PostMapping("/posts")
    public PostDto createPost(@Valid @RequestBody PostDto post
    ) throws PostNotFoundException, LocationNotFoundException, IncorrectDataException {
        Validation.getInstance().validation(post);
        post.setDate(LocalDate.now());
        post = JsonGenerator.getInstance().getWeather(post);
        return postService.create(post);
    }

    @PutMapping("/posts/{id}")
    public PostDto updatePost(@PathVariable int id, @RequestBody PostDto post) throws PostNotFoundException, IncorrectDataException {
        Validation.getInstance().validation(post);
        PostDto oldPost = postService.getById(id);
        post.setId(id);
        post.setDate(oldPost.getDate());
        post.setLocation(oldPost.getLocation());
        post.setWeather(oldPost.getWeather());
        post.setTemperature(oldPost.getTemperature());
        return postService.update(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable int id) throws PostNotFoundException {
        postService.delete(id);
    }
}
