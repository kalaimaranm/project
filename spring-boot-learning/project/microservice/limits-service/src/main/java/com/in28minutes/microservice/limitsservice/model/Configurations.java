package com.in28minutes.microservice.limitsservice.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configurations {

    private int minimum;
    private int maximum;

    public Configurations(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Configurations() {
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "Configurations{" + "minimum=" + minimum + ", maximum=" + maximum + '}';
    }

}
