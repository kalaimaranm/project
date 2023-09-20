package net.javaguides.springannotations.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

    public String repository() {

        return "From myrepository class";
    }

}
