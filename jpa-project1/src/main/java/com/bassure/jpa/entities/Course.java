package com.bassure.jpa.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
//@IdClass(CoursePK.class)
@Table(name = "course")
public class Course {

//    private Integer id;
//    private Integer candidateId;
    @EmbeddedId()
    @AttributeOverride(name = "id", column = @Column(name = "id"))
    @AttributeOverride(name = "candidateId", column = @Column(name = "candidate_id"))
    private CoursePK id;
    private String name;

    public CoursePK getId() {
        return id;
    }

    public void setId(CoursePK id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
