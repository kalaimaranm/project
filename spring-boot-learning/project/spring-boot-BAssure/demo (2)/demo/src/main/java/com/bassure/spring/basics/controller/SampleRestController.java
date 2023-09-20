package com.bassure.spring.basics.controller;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleRestController {

    @GetMapping("/users/posts")
    public Post[] getUserPosts() {

        Post[] posts = new RestTemplate()
                .getForObject(URI.create("https://jsonplaceholder.typicode.com/posts"), Post[].class);

        return posts;
    }

    private static class Post {

        private int id;
        private int it;
        private String title;
        private String body;

        public Post() {
        }

        public Post(int id, int it, String title, String body) {
            this.id = id;
            this.it = it;
            this.title = title;
            this.body = body;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIt() {
            return it;
        }

        public void setIt(int it) {
            this.it = it;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        @Override
        public String toString() {
            return "Post{" + "id=" + id + ", it=" + it + ", title=" + title + ", body=" + body + '}';
        }

    }
}
