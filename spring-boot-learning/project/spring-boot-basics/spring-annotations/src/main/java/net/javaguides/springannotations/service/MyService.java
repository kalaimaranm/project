package net.javaguides.springannotations.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String service() {

        return "From my service class";
    }

}
