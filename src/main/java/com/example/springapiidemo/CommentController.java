package com.example.springapiidemo;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/count-by-post")

 
    public List<PostCommentCount> countCommentsByPost() {
        // Call the service to fetch comments and count by postId
        List<Comment> comments = commentService.getAllComments();
        List<PostCommentCount> result = commentService.countCommentsByPost(comments);
        return result;
    }
}
