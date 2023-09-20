package com.bassure.jpa.entities;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@Setter
//@Getter
@ToString
@NoArgsConstructor
@Access(AccessType.PROPERTY)
public class Employee {

//    @Id
//    @GenericGenerator(name = "hibernate_generator",
//            strategy = "org.hibernate.id.UUIDHexGenerator")
//    @GeneratedValue(generator = "hibernate_generator")
    private String id;

    private String name;

//    @Temporal(TemporalType.DATE)
    private Date date;

//    @Embedded
//    @AttributeOverrides({
//        @AttributeOverride(name = "str", column = @Column(name = "street")),
//        @AttributeOverride(name = "dis", column = @Column(name = "distric"))})

    private Address address;

    @Id
    @GenericGenerator(name = "hibernate_generator",
            strategy = "org.hibernate.id.UUIDHexGenerator")
    @GeneratedValue(generator = "hibernate_generator")
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "str", column = @Column(name = "street")),
        @AttributeOverride(name = "dis", column = @Column(name = "distric"))})
    public Address getAddress() {
        return address;
    }

}
