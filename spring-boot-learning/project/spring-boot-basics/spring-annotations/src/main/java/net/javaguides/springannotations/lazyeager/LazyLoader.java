package net.javaguides.springannotations.lazyeager;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
@Lazy(false)
// by default it is lazy loader i am change it and scope is prototype so it loaded on demand
public class LazyLoader {

    public LazyLoader() {

        System.out.println("lazy loader...");
    }
}
