package com.mongo.db;


import com.mongo.db.dao.PostRepository;
import com.mongo.db.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
public class PostController {

    @Autowired
    PostRepository repo;

    @RequestMapping
    public void redirect(HttpServletResponse response) throws IOException {
           response.sendRedirect("/swagger-ui.html");
    }



    @GetMapping("/posts")
    public List<Post> getAllPost(@RequestBody String hello) {
        return repo.findAll();
    }

    @PostMapping("addPost")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }


    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/post")
    public String helloPost(@RequestBody String hello) {
        return hello;
    }

    @PutMapping("/put")
    public String helloPut(@RequestBody String hello) {
        return hello;
    }
}

