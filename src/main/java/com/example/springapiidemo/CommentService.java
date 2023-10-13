package com.example.springapiidemo;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    private final String JSON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/comments";

    public List<Comment> getAllComments() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Comment[]> response = restTemplate.getForEntity(JSON_PLACEHOLDER_URL, Comment[].class);
        return Arrays.asList(response.getBody());
    }

    public List<PostCommentCount> countCommentsByPost(List<Comment> comments) {
        Map<Integer, Integer> postCommentCountMap = new HashMap<>();

        // Iterate through the comments and count by postId
        for (Comment comment : comments) {
            int postId = comment.getPostId();
            postCommentCountMap.put(postId, postCommentCountMap.getOrDefault(postId, 0) + 1);
        }

        List<PostCommentCount> result = new ArrayList<>();

        // Convert the map to a list of PostCommentCount objects
        for (Map.Entry<Integer, Integer> entry : postCommentCountMap.entrySet()) {
            result.add(new PostCommentCount(entry.getKey(), entry.getValue()));
        }

        return result;
    }
    public String formatCommentsAsJson(List<PostCommentCount> postCommentCounts) {

    	ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        try {
            // Convert the list of PostCommentCount objects to a JSON string with pretty printing
            return objectWriter.writeValueAsString(postCommentCounts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error formatting data.";
        }

    }
}