package net.javaguides.springannotations.lazyeager;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "singleton")
@Lazy()

//  singleton is a eager loader I am using @Lazy annotation to load lazy on demand
public class EagerLoader {

    public EagerLoader() {

        System.out.println("eager loader...");
    }
}
