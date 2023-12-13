package pairmatching.model;

import pairmatching.constant.Exception;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course of(String target) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Exception.COURSE.getMessage()));
    }

    public String getName() {
        return name;
    }
}