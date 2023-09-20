package com.bassure.jpa.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class CoursePK {

    private Integer id;
    private Integer candidateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

}
