package com.example.springapiidemo;

public class PostCommentCount {
    private int postId;
    private int total;

    public PostCommentCount(int postId, int total) {
        this.postId = postId;
        this.total = total;
    }

    public int getPostId() {
        return postId;
    }

    public int getTotal() {
        return total;
    }
}
