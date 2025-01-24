package com.example.joblisting.Controller;

import com.example.joblisting.Repository.PostRepository;
import com.example.joblisting.Repository.SearchRepository;
import com.example.joblisting.Repository.SearchRepositoryimpl;
import com.example.joblisting.model.Post;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    SearchRepositoryimpl searchRepositoryimpl;
    @Hidden
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/posts")
    public List<Post> getAllPosts()  {
        return postRepository.findAll();
    }
    @GetMapping("/posts/{text}")
    public List<Post>search(@PathVariable String text){
        return searchRepositoryimpl.FindByText(text);
    }

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }
}
