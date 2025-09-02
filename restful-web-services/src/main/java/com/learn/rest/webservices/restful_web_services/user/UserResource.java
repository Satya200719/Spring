package com.learn.rest.webservices.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class UserResource {


    private final MessageSource messageSource;

    public UserResource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    private UserDaoService userService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PostRepository postRepo;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        //return userService.findAll();
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id) {
        //User user = userService.findOne(id);
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User Id: " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        //User savedUser = userService.save(user);
        userRepo.save(user);
        //User savedUser = userService.save(user);
        User savedUser = userRepo.findByName(user.getName());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        //userService.deleteById(id);
        userRepo.deleteById(id);
    }

    @GetMapping("/hello-i18n")
    public String hello() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null,
                "Default Message - Good Morning", locale);
    }

    @GetMapping("users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User Id: " + id);
        }

        return user.get().getPosts();
        //return postRepo.findByUserId(id);
    }

    @PostMapping("users/{id}/post")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User Id: " + id);
        }
        post.setUser(user.get());
        Post savedPost = postRepo.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("users/{id}/post/{postId}")
    public Post retrievePostForUser(@PathVariable int id, @PathVariable Integer postId) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User Id: " + id);
        }
        Post post = postRepo.findPostById(postId);
        if (post == null) {
            throw new UserNotFoundException("Post Id: " + postId);
        }
        return post;
    }

}
