package com.bassure.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Table(name = "A")
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Address {

    @Id

    private Integer id;

    @Column(name = "door_no")
    private String doorNo;

    private String street;

    private String distric;

    private String state;

}
