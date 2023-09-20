package com.kalai.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${team.name}")
    String teamName;
    @Value("${coach.name}")
    String coachName;

    @GetMapping("/home")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {

        return "Team name : " + teamName + "\nCoach name : " + coachName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

}
