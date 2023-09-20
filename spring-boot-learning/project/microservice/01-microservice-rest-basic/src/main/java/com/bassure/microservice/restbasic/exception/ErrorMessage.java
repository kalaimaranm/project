package com.bassure.microservice.restbasic.exception;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ErrorMessage {

    private LocalDate date;
    private String message;
    private String detail;

}
