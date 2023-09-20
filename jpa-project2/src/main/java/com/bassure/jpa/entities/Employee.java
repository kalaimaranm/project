package com.bassure.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Employees")
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Employee {

    @Id
//    @GenericGenerator(name = "",strategy = "id.hiberanate.HexUUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "hibernate_generator")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String technology;

    private String designation;

    private Date date;

}
