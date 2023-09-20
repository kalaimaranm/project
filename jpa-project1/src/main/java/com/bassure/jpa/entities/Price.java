package com.bassure.jpa.entities;

import com.bassure.jpa.entities.enums.Currency;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "price")
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Price {

    @Id
    @GenericGenerator(name = "hibernate_generator",
            strategy = "org.hibernate.id.UUIDHexGenerator")
    @GeneratedValue(generator = "hibernate_generator")
    private String id;

    private double amount;
//    @Enumerated(EnumType.STRING) - for string value enum full type
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;

}
