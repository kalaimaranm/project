package com.bassure.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "seller")
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Seller {

//    @Id(state GeneratedType.)
//    @TableGenerator(name = "id_generator", table = "keygenerator",  )
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    @Id()
    @GenericGenerator(name = "hibernate_generator",
            strategy = "org.hibernate.id.UUIDHexGenerator",parameters = @Parameter(name = "seperator",value="-"))
    @GeneratedValue(generator = "hibernate_generator")
    private String id;
    private String name;

}
