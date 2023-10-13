package com.example.springapiidemo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {
    @JsonProperty("postId")
    private int postId;

    // You can add other fields as needed

    public int getPostId() {
        return postId;
    }

	public void setPostId(int postId) {
		this.postId = postId;
	}

    // Add getters and setters for other fields as needed



}
