package com.bassure.microservice.restbasic.controller;

public class UserVersion {

    private Name versionName;

    private String name;

    public UserVersion() {
    }

    public UserVersion(Name versionName) {
        this.versionName = versionName;
    }

    public UserVersion(String name) {
        this.name = name;
    }

    public Name getVersionName() {
        return versionName;
    }

    public void setVersionName(Name versionName) {
        this.versionName = versionName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVersion{" + "versionName=" + versionName + ", name=" + name + '}';
    }

}
