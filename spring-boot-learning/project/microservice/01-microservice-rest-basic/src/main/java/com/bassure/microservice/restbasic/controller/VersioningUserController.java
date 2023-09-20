package com.bassure.microservice.restbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningUserController {

    @GetMapping("/v1/users")
    public String getUser() {

        return "Bob Nikol";

    }

    @GetMapping("/v2/users")
    public UserVersion getUSer() {

        return new UserVersion(new Name("Bob", "Nikol"));

    }

    @GetMapping(path = "/users", params = "version=1")
    public String getFirstVersionUser() {

        return "Bob Nikol";
    }

    @GetMapping(path = "/users", params = "version=2")
    public UserVersion getSecondVersionUser() {

        return new UserVersion(new Name("Bob", "Nikol"));
    }

    @GetMapping(path = "/users", headers = "X-API-VERSION=1")
    public String getFirstHeaderVersion() {

        return "Bob Nikol";
    }

    @GetMapping(path = "/users", headers = "X-API-VERSION=2")
    public UserVersion getSecondHeaderVersion() {

        return new UserVersion(new Name("Bob", "Nikol"));
    }

    @GetMapping(path = "/users", produces = "application/vnd.company.app-v1+json")
    public UserVersion getFirstAcceptVersion() {

        return new UserVersion("Bob Nikol");
    }

    @GetMapping(path = "/users", produces = "application/vnd.company.app-v2+json")
    public UserVersion getSecondAcceptVersion() {

        return new UserVersion(new Name("Bob", "Nikol"));

    }
}
