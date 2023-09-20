package com.bassure.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "event")
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Event {

    @Id
    private String id;
    private String description;

    public Event() {
        this.id = UUID.randomUUID().toString();

    }

}
